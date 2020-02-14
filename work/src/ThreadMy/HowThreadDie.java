package ThreadMy;

import javafx.concurrent.Worker;

public class HowThreadDie {
    public static class  Worker extends Thread{
        @Override
        public void run() {
            while(!Thread.interrupted()){
                System.out.println("挖煤");
                try{
                    Thread.sleep(20*1000);
                } catch (InterruptedException e) {
                   break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(10*1000);
        System.out.println("媳妇生了,赶紧回家");
        //worker.quit();
        worker.join();
        System.out.println("他回去了");
    }


}
