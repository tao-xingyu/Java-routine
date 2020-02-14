package ThreadMy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ArrayQueue1 {
    private int[] array = new int[10];
    private volatile int size = 0;   // 有效元素个数
    private int front = 0;//队首元素
    private int rear = 0;//下一个要插入元素的下标

    public synchronized void put(int val) throws InterruptedException {
        while (size == array.length) {
            wait();
        }
        array[rear] = val;
        rear = (rear + 1) % array.length;
        size++;
        notifyAll();
    }

    public  synchronized int take() throws InterruptedException {
        while (size == 0) {
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

    private static ArrayQueue1 queue = new ArrayQueue1();

    private static class Producer extends Thread {
        Producer() {
            super("生产者");
        }

        @Override
        public void run() {
            Random random = new Random(20191216);
            while(true) {
                int val = random.nextInt(100);
                try {
                    queue.put(val);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Customer extends Thread {
        Customer() {
            super("消费者");
        }

        @Override
        public void run() {
            try {
                int val = queue.take();
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        producer.start();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.start();
        }

        while (true) {
            System.out.println(queue.getSize());
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
