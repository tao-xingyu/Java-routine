package ThreadMy;

public class MyThreadWork{
    //饿汉模式
//    private static MyThreadWork instance = new MyThreadWork();
//    private  MyThreadWork(){
//    }
//    private static MyThreadWork getInstance(){
//        return instance;
//    }
    //懒汉模式
    private static MyThreadWork instance1 = null;
    private MyThreadWork(){

    }
    private static MyThreadWork getInstance1(){
        if(instance1 == null){
            synchronized (MyThreadWork.class){
                if(instance1 == null){
                    instance1 = new MyThreadWork();
                }
            }
        }
        return instance1;
    }
}
