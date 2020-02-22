package package_bookmanager.operation;

import package_bookmanager.book.Book;
import package_bookmanager.book.BoookList;

import java.util.Scanner;

public class DelOperation implements IOperation {
    @Override
    public void work(BoookList bookList) {
        System.out.println("删除书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的序号:");
        String id = scanner.next();
        //先查找
        int i = 0;
        for(;i < bookList.getSize();i++){
            Book book = bookList.getBook(i);
            if(book.getId().equals(id)){
                break;//找到了
            }
        }
        if(i >= bookList.getSize()){
            System.out.println("未找到要删除的书籍!");
            return;//没找到
        }
        //处理找到的情况
        //直接用最后一个元素覆盖
        //再进行尾删
        Book lastBook = bookList.getBook(bookList.getSize() - 1);
        bookList.setBook(i,lastBook);
        bookList.setSize(bookList.getSize() - 1);
        System.out.println("删除成功!");
    }
}
