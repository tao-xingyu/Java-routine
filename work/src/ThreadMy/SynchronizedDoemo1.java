package ThreadMy;

import java.util.Random;

public class SynchronizedDoemo1{
   private static int index = 0;

   private static class method extends Thread{
       int[] array;
       int start;
       int end;
       method(int[] array,int start,int end){
           this.array = array;
           this.start = start;
           this.end = end;
       }

       @Override
       public void run() {
           while (index < array.length) {
               synchronized (method.class) {//存在下标越界问题
                   //线程之间存在跨度和变化
                   if(index <array.length) {//二次判断
                       array[index] = array[index] * 3;
                       index++;
                   }
               }
           }
       }
   }

    public synchronized void method() {

    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(20191215);
        int[] array = new int[10_0000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        method m1 = new method(array,0,30000);
        method m2 = new method(array,30000,60000);
        method m3 = new method(array,60000,array.length);
        m1.start();
        m2.start();
        m3.start();
        m1.join();
        m2.join();
        m3.join();
        System.out.println(array[0]);
        System.out.println(array[88888]);
        System.out.println(array[93192]);

    }
}
