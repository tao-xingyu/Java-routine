package ThreadMy;

public class PrintlnOrder {
    private int i = 0;
    public synchronized void first() throws InterruptedException {
       if(i == 0) {
           System.out.println("one");
           i = 1;
           notifyAll();
       }
       wait();
    }

    public synchronized void second() throws InterruptedException {
        if (i == 1) {
            System.out.println("two");
            i = 2;
            notifyAll();
        }
        wait();
    }

    public synchronized void third() throws InterruptedException {
        if(i == 2){
            System.out.println("three");
            i = 0;
            notifyAll();
        }
        wait();
    }

    private static class PrintOne extends Thread {
        PrintlnOrder object;
        PrintOne(PrintlnOrder object) {

            this.object = object;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    object.first();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class PrintTwo extends Thread {
        PrintlnOrder object;
        PrintTwo(PrintlnOrder object) {
            this.object = object;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    object.second();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class PrintThree extends Thread {
        PrintlnOrder object;
        PrintThree(PrintlnOrder object) {
            this.object = object;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    object.third();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintlnOrder object = new PrintlnOrder();
        Thread t1 = new PrintOne(object);
        t1.start();
        Thread t2 = new PrintTwo(object);
        t2.start();
        Thread t3 = new PrintThree(object);
        t3.start();
    }
}