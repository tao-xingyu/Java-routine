package ThreadMy;

import java.util.Scanner;

public class Main {

//jconsole
//    public static void main1(String[] args) {
//        ThreadMy.Main main = new ThreadMy.Main();
//        main.start();
//        while(true){
//            System.out.println("我是主线程");
//        }
//    }
//    private static final long COUNT = 1000000L;
//    private static class MyThread extends Thread{
//        @Override
//        public void run() {
//            long b = 0;
//            for (int i = 0; i < COUNT; i++) {
//                b += i;
//            }
//        }
//
//        private static void multiThread() throws InterruptedException {
//            long begin = System.currentTimeMillis();
//            MyThread thread = new MyThread();
//            thread.start();
//            long a = 0;
//            for (long i = 0; i < COUNT; i++) {
//                a += i;
//            }
//            thread.join();
//            long end = System.currentTimeMillis();
//            System.out.println(end - begin);
//        }
//
//        private  static void oneThread(){
//            long begin = System.currentTimeMillis();
//
//            long a = 0;
//            for (int i = 0; i < COUNT; i++) {
//                a += i;
//            }
//
//            long b = 0;
//            for (int i = 0; i < COUNT; i++) {
//                b += i;
//            }
//            long end = System.currentTimeMillis();
//            System.out.println(end - begin);
//        }
//
//
//        public static void main2(String[] args) throws InterruptedException {
//            oneThread();
//            multiThread();
//        }
        public static int fib(int n){
            int a = 0;
            int b = 1;
            int c = 0;
            for (int i = 0; i < n; i++) {
                c = a+ b;
                a = b;
                b = c;
            }
            return c;
        }
        private static class MyThread extends Thread{
            private int n;
            MyThread(int n){
                this.n = n;
            }

            @Override
            public void run() {
                long result = fib(n);
                System.out.printf("fib的计算结果为 %d%n",n);
            }
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入要计算的 n:");
            int n = scanner.nextInt();
            Thread thread = new MyThread(n);
            thread.start();
        }
    }

}
