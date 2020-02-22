package package_bookmanager.user;

import package_bookmanager.book.BoookList;
import package_bookmanager.operation.IOperation;

abstract public class User {//抽象类
   protected String name;

    //持有当前用户支持的操作对象
    protected IOperation[] operations;

    public User(String name) {
        this.name = name;
    }

    //打印一个操作菜单,不同用户,支持的操作不同
   abstract public int  menu();
   //根据用户输入的选项,调用对应的操作对象
    //注意多态的体现
    public void doOperation(int choice, BoookList booklist){
        operations[choice].work(booklist);
    }
}
