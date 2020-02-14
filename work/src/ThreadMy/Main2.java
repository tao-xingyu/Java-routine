package ThreadMy;

import java.util.Scanner;

public class Main2 {
    private static Object object = new Object();

    public static class AThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("A 正在扫地");
            }
            try {
                synchronized (object) {
                    object.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("A 正在擦桌子");
            }
        }
    }

        public static void main(String[] args) {
            Thread athread = new AThread();
            athread.start();
            Scanner scanner = new Scanner(System.in);
            System.out.println("随便输入什么,A就会去扫地");
            scanner.nextLine();
            synchronized (object){
                object.notify();
            }
        }

    }
