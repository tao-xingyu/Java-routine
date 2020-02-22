package package_bookmanager.operation;

import package_bookmanager.book.Book;
import package_bookmanager.book.BoookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BoookList bookList) {
        System.out.println("借阅书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借阅的序号:");
        String id = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if(book.getId().equals(id)){
                continue;
            }
            //执行具体的借书操作
            if(book.isBorrowed()){
                System.out.println("这本书已经被借走了!");
                break;
            }
            book.setBorrowed(true);
        }
    }
}
