package ThreadMy;

public class safeThread {
    private static long n = 1L;
    private static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
               synchronized (safeThread.class){//演示线程安全
                    n++;
               }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Thread t = new MyThread();//启动五个线程
            t.start();
            threads[i] = t;
        }
        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }
        System.out.println(n);
    }
}
