package package_bookmanager.book;

public class BoookList {
    private Book[] books = new Book[100];
    private int size;

    public BoookList() {
        books[0] = new Book("甄嬛传","001",
                "小花",100,"古典名著",
                false);
        books[1] = new Book("水浒传","002","施耐庵",
                100,"古典名著",false);
        books[2] = new Book("西游记","003","吴承恩",
                100,"古典名著",false);
        size = 3;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public Book getBook(int index){
        return books[index];
    }
    public void setBook(int index,Book book){
        books[index] = book;
    }
}
