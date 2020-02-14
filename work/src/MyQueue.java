class Node{
     int val;
     Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
    Node(int val){
        this.val = val;
    }
}
public class MyQueue {
    private Node head = null;
    private Node Tail = null;
    private int size = 0;

    public void offer(int v){
        Node node = new Node(v);
        if(Tail == null){
            head = node;
        }else{
            Tail.next = node;
        }
        Tail = node;
        size++;

    }
    public void poll(){

    }
}
