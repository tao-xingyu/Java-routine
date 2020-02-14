package ThreadMy;

public class ArrayQueue {
    private int[] array = new int[10];
    private int size = 0;
    private int front = 0;
    private int rear = 0;
    private int val;

    public ArrayQueue(int val) {
        this.val = val;
    }

    public void put(int val){
        if(size == array.length){
            throw new RuntimeException("满了");
        }
        array[rear++] = val;
        if(rear == array.length){
            rear = 0;
        }
        size++;
    }
    public void take(){
        if(size == 0){
            throw new RuntimeException("空了");
        }

    }
}
