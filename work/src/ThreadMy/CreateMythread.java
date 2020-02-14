package ThreadMy;

import static java.lang.Math.pow;

public class CreateMythread {
    private static final long COUNT = 100000000;

    public static class MyThread extends Thread{//第一种方法
        @Override
        public void run() {
            double sum = 0;
            for (long i = 0; i < COUNT; i++) {
                sum += pow(i,2);
            }
            System.out.println(sum);
        }
    }
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            double sum = 0;
            for (long i = 0; i < COUNT; i++) {
                sum += pow(i,2);
            }
            System.out.println(sum);

        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();

        MyThread myThread = new MyThread();
        Thread thread3 = new Thread(myThread);
        thread2.start();
    }

}
