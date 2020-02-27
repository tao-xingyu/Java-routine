package task;

import java.io.File;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FileScanTask {
    private  final ExecutorService pool = Executors.newFixedThreadPool(4);
    //private static volatile int COUNT;
    private  AtomicInteger count = new AtomicInteger();//原子性

    private  final CountDownLatch latch = new CountDownLatch(1);

    private FileScanCallback callback;

    public FileScanTask(FileScanCallback callback){
        this.callback = callback;
    }
    public void startScan(File root) {
//        synchronized (this){
//            COUNT++;
//        }
        count.incrementAndGet();
        pool.execute(new Runnable() {
              @Override
              public void run() {
                  list(root);
              }
          });
    }
    public void waitFinish() throws InterruptedException {
//        try {
//            synchronized (this) {
//                this.wait();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //等待
        try {
            latch.await();
        }finally {
            pool.shutdown();//调用interrupt()中断
            //POOL.shutdownNow();//调用每个线程的STOP()关闭,立即停止
        }
    }
    public  void list(File dir) {
       if(!Thread.interrupted()) {
           try {
               callback.execute(dir);
               //System.out.println(dir.getPath());
               if (dir.isDirectory()) {
                   File[] children = dir.listFiles();
                   if (children != null && children.length > 0) {
                       for (File child : children) {//启动新线程,执行子文件夹扫描任务
                           if (child.isDirectory()) {
//                            synchronized (this) {
//                                COUNT++;
//                            }
                               count.incrementAndGet();
                               pool.execute(new Runnable() {
                                   @Override
                                   public void run() {
                                       list(child);
                                   }
                               });
                           } else {
                               callback.execute(child);
                               //System.out.println(child.getPath());
                           }
                       }
                   }
               }
           } finally {
//            synchronized (this) {
////                COUNT--;
////                if (COUNT == 0) {
////                    POOL.notifyAll();
////                }
////            }
               if (count.decrementAndGet() == 0) {
                   //通知
                   latch.countDown();
               }
           }
       }
    }
//    public static void main(String[] args) throws InterruptedException{
//        FileScanTask task = new FileScanTask();
//        task.startScan(new File("C:\\Users\\taoxingyu\\Desktop\\项目"));
//        synchronized (task) {
//            task.wait();
//        }
//        System.out.println("执行完毕");
//    }
}