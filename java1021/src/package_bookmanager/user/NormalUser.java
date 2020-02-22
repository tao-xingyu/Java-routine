package package_bookmanager.user;

import package_bookmanager.operation.*;

import java.util.Scanner;

public class NormalUser extends User {
    public NormalUser(String name) {
        super(name);
        //在这里构造operation数组
        //让数组中operation中对象的顺序相匹配
        operations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }

    @Override
  public int menu() {
        System.out.println("=============");
        System.out.println("hello"+ name);
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出");
        System.out.println("=============");
        System.out.println("请输入您的选择:");
        Scanner scanner = new Scanner( System.in);
        int choice = scanner.nextInt();

        //scanner.close();此处不可盲目关闭
        return choice;
    }
}
