import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Test {
    public static void main(String[] args){
        TestAdd();
        TestContains();
        TestSearch();
        TestgetPos();
        TestsetPos();
        TestRemove();
    }
    public static void TestAdd(){
        System.out.println("测试add方法:");
        SeqList seqList = new SeqList();

        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        seqList.add(2,5);
        seqList.display();
        seqList.add(3,2);
        seqList.display();
    }
    public static void TestContains(){
        System.out.println("测试contains方法:");
        SeqList seqList = new SeqList();

        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        boolean result = seqList.contains(3);
        boolean result1 = seqList.contains(5);
        System.out.println("result预期值为true,实际值为:"+result);
        System.out.println("result预期值为false,实际值为:"+result1);
    }
    public static void TestSearch(){
        System.out.println("测试search方法:");
        SeqList seqList = new SeqList();

        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        int result = seqList.search(2);
        int result1 = seqList.search(5);
        System.out.println("result预期值是1,实际值是:"+result);
        System.out.println("result预期值是-1,实际值是:"+result1);
    }
    public static void TestgetPos(){
        System.out.println("测试getPos方法:");
        SeqList seqList = new SeqList();

        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        int result = seqList.getPos(3);
        System.out.println("result预期值是4,实际值是:"+result);
    }
    public static void TestsetPos(){
        System.out.println("测试setPos方法:");
        SeqList seqList = new SeqList();

        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        seqList.setPos(2,5);
        seqList.display();
    }
    public static void TestRemove(){
        System.out.println("测试remove方法:");
        SeqList seqList = new SeqList();

        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        seqList.remove(4);
        seqList.display();
    }
}
