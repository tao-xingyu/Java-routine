package package_bookmanager.operation;

import package_bookmanager.book.BoookList;

public class PrintAllOperation implements IOperation {
    @Override
    public void work(BoookList bookList) {
        System.out.println("打印所有书籍信息");
        for (int i = 0; i < bookList.getSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
        System.out.println("共计" + bookList.getSize()+"本书!");
    }
}
