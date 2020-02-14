package ThreadMy;

public class yieldDemo {

    private static class MyThread extends Thread{
        private final String message;
        public MyThread(String name,String message) {
            super(name);
            this.message = message;
        }

        @Override
        public void run() {
            while(true){
                System.out.println(Thread.currentThread().getName() + ":" + message);
            }
        }
    }
    private static class MyThread2 extends Thread{
        private final String message;
        public MyThread2(String name,String message) {
            super(name);
            this.message = message;
        }

        @Override
        public void run() {
            while(true){
                System.out.println(Thread.currentThread().getName() + ":" + message);
                    yield();
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread("自私的","我在唱歌");
        MyThread2 thread1 = new MyThread2("不是那么自私的","我在唱歌");
        thread.start();
        thread1.start();
    }
}
