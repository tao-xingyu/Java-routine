package package_bookmanager.operation;

import package_bookmanager.book.Book;
import package_bookmanager.book.BoookList;

import java.util.Scanner;

public class FindOperation implements IOperation {
    @Override
    public void work(BoookList bookList) {
        System.out.println("查找书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的书名:");
        String name = scanner.next();
        int count = 0;
        for(int i = 0;i < bookList.getSize();i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                System.out.println(book);//打印这本书的信息
                count++;
            }
        }
        if(count == 0){
            System.out.println("未找到此书");
        }else{
            System.out.println("共找到" + count + "本书!");
        }
    }
}
