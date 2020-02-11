import java.util.Arrays;

public class SeqList {
    private int[] data = new int[10];
    private int size = 0;

    public void display(){
        //System.out.println(Arrays.toString(data));
        System.out.print("[");
        for(int i = 0;i < size;i++){
            System.out.print(data[i]);
            if(i != size - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    //插入元素    pos:插入下标 elem:插入元素
    public void add(int pos,int elem){
        //空数组情况
        if(pos > data.length || pos < 0){
            return;
        }
        //扩容情况
        if(size > data.length){
            //realloc();
            this.data = Arrays.copyOf(this.data,
                    this.data.length*2);
        }
        //尾插
        if(pos == size){
            data[pos] = elem;
            size++;
            return;
        }
        //中间位置插入
        else{
            for(int i = size;i > pos;i--){
                data[i] = data[i-1];
            }
            data[pos] = elem;
            size++;
            return;
        }
    }
    //扩容方法
    private void realloc(){
        int[] newData = new int[this.data.length*2];
        for(int i = 0;i < this.data.length;i++){
            newData[i] = this.data[i];
        }
        this.data = newData;
    }
//判断某个元素是否存在
    public boolean contains(int toFind){
        for (int i = 0; i < this.size; i++) {
            if(this.data[i] == toFind){
                return true;
            }
        }
        return false;
        //return this.search(toFind) != -1;
    }
//查找某个元素是否存在
    public int search(int toFind){
        for (int i = 0; i < this.size; i++) {
            if(this.data[i] == toFind){
                return i;
            }
        }
        return -1;
    }
//获取某个位置的元素
    public int getPos(int pos){
        if(pos < 0 || pos > this.size){//POS位置不存在
            return -1;
        }
        return this.data[pos];
    }
//修改某个下标的值
    public void setPos(int pos,int elem) {

        this.data[pos] = elem;
    }

    //按值删除
    public void remove(int toRemove){
        int pos = search(toRemove);
        //POS位置不存在
        if(pos < 0 || pos > this.size){
            return;
        }
        //删除尾部的值
        if(pos == this.size - 1){
            this.size--;
            return;
        }
        //删除中间的值
        for (int i = pos; i < this.size - 1; i++) {
            this.data[i] = data[i + 1];
        }
        this.size--;
        return;
    }

    //求长度
    public int size(){
        return this.size;
    }
    //清空
    public void clear(){
        this.size = 0;
        this.data = new int[10];//缩容
    }
}
