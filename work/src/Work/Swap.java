package Work;

public class Swap {
    private int a;
    private int b;

    public Swap(int a,int b){
        this.a = a;
        this.b = b;
    }
    public void Fun(){
        int tmp = this.a;
        this.a = this.b;
        this.b = tmp;
        System.out.println("a = "+ this.a+" b = "+this.b);
    }
}
