public class MyThreadQueue {
    private int[] array =new int[10];
    private volatile int size = 0;
    private int front = 0;
    private int rear = 0;

    public synchronized void put(int val) throws InterruptedException {
        while(size == array.length){
            wait();
        }
        array[rear] = val;
        rear = (rear + 1) % array.length;
        size++;
        notifyAll();
    }
    public synchronized int take() throws InterruptedException {
        while(size == 0){
            wait();
        }
        int val = array[front];
        front = (front + 1) % array.length;
        size--;
        notifyAll();
        return val;
    }

    public int getSize() {
        return size;
    }

    private static class Producer extends Thread{
        Producer(){
            super("生产者");
        }
        @Override
        public void run() {

        }
    }
    private static class  Customer extends Thread{
        Customer(){
            super("消费者");
        }
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {

    }
}
