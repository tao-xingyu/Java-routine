package package_bookmanager.operation;

import package_bookmanager.book.BoookList;

public class ExitOperation implements IOperation {
    @Override
    public void work(BoookList bookList) {
        System.out.println("goodbye!");
        System.exit(0);//相当于C语言中的return 0;
    }
}
