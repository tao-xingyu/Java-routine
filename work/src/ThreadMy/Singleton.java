package ThreadMy;

public class Singleton {
//    //懒汉模式
//    private static volatile ThreadMy.Singleton instance = null;
//    private ThreadMy.Singleton() {
//
//    }
//    public static ThreadMy.Singleton getInstance(){
//        if(instance == null){
//            synchronized(ThreadMy.Singleton.class) {
//                if (instance == null) {//二次判断
//                    instance = new ThreadMy.Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    //饿汉模式
    private static Singleton instance = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }
}
