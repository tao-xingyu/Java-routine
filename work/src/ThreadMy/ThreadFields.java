package ThreadMy;

public class ThreadFields {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getId());
        System.out.println(currentThread.getName());
        System.out.println(currentThread.getState());
        System.out.println(currentThread.isDaemon());
        System.out.println(currentThread.isAlive());
        System.out.println(currentThread.isInterrupted());
    }
}
