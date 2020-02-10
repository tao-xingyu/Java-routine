import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.nio.file.NotDirectoryException;

//节点
class LinkedNode{
  public int data = 0;
    public LinkedNode next = null;
    public LinkedNode(int data){
        this.data = data;
    }
}

public class LinkedList {
    public LinkedNode head = null;//链表的头节点


    //头插法o(1)
    public void addFirst(int elem){
        LinkedNode node = new LinkedNode(elem);
        if(this.head == null){
            this.head = node;
            return;
        }
       node.next = this.head;
        this.head = node;
    }

    //尾插法o(n)
    public void addLast(int elem){
       LinkedNode node = new LinkedNode(elem);
       if(this.head == null){
           this.head = node;
           return;
       }
       LinkedNode cur = this.head;
       while(cur.next != null){
           cur = cur.next;
        }
        cur.next = node;
       return;
    }

    //任意位置插入,第一个数据节点为0号下标o(n)
    public void addIndex(int index,int elem) {
        LinkedNode node =new LinkedNode(elem);
        int len = size();
        if(index < 0 || index > len){
            return;
        }
        if(index == 0){
            addFirst(elem);
            return;
        }
        if(index == len){
            addLast(elem);
            return;
        }
        LinkedNode prev = getIndex(index -1);
        node.next = prev.next;
        prev.next = node;
    }
    private LinkedNode getIndex(int index){
        LinkedNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int toFind){
    for(LinkedNode cur = this.head;cur !=null;cur = cur.next){
        if(cur.data == toFind){
            return true;
        }
    }
    return false;
    }
    //删除第一次出现关键字为key的节点o(n)
    public void remove(int toRemove){
        int len = size();
        //空链表
        if (head == null){
            return;
        }
        if(toRemove < 0||toRemove > len){
            return;
        }
        //头节点
        if(head.data == toRemove) {
            this.head = this.head.next;
            return;
        }
        //删除中间节点
        LinkedNode prev = searchPrev(toRemove);
        if(prev == null){
            return;
        }
        //prev.next = prev.next.next
        LinkedNode nodeToRemove = prev.next;//要删除的节点
        prev.next = nodeToRemove.next;
    }
    private LinkedNode searchPrev(int toRemove) {//找到要删除节点的前一个值
        LinkedNode prev = this.head;
        if (head == null) {//空链表
            return null;
        }
        while (prev.next != null) {
            if (prev.next.data == toRemove) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
//删除所有关键词为toRemove的节点
    public void removeAllKey(int toRemove){
        if(head == null){
            return;
        }
        //先处理后续节点，再处理头节点
        LinkedNode prev = head;
        LinkedNode cur = head.next;
        while(cur != null){
            if(cur.data == toRemove){//cur对应的节点就应该删除

                prev.next = cur.next;
                cur = prev.next;
            }
            else{//cur对应的节点不用删除
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == toRemove){
            this.head = this.head.next;
        }
    }


//需要检测的部分:空链表,头部元素,普通节点,不存在的元素,重复的元素
//求链表长度
    public int size(){
        int size = 0;
        for(LinkedNode cur = this.head;
            cur != null;cur = cur.next){
            size++;
        }
        return size;
    }
//清空链表
    public void clear(){

        this.head = null;
    }
    public void display() {
        System.out.print("[");
        for (LinkedNode node = this.head; node != null; node = node.next) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}

