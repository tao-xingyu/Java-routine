package ThreadMy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyPool {
    public static class Worker extends Thread{
        private BlockingQueue<Runnable> queue;
        Worker(BlockingQueue<Runnable> queue){
            super("工作者");
            this.queue = queue;
        }
        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    Runnable command = queue.take();
                    command.run();
                }
            }catch (InterruptedException e){}
        }
    }
    private int corePoolSize = 0;
    private int currentPoolSize = 0;
    private List<Worker> workerList = new ArrayList<>();
    private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();

    public void execute(Runnable command){
        if(currentPoolSize < corePoolSize){
            Worker worker = new Worker(queue);//雇人
            worker.start();
            currentPoolSize++;
        }
        queue.add(command);
    }
    public void shutDown() throws InterruptedException {//公司破产
        for (Worker worker:workerList) {
            worker.interrupt();
        }
        for (Worker worker:workerList) {
            worker.join();
        }
    }
}
