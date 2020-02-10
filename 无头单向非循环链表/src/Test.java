public class Test {
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testAddIndex();
        testContains();
        testRemove();
        testClear();
        testRemoveAlkey();
    }
        public static void testAddFirst () {
            System.out.println("测试addFirst方法:");
            LinkedList s = new LinkedList();
            s.addFirst(1);
            s.addFirst(2);
            s.addFirst(3);
            s.addFirst(4);
            s.addFirst(3);
            s.display();
        }
        public static void testAddLast () {
            System.out.println("测试addLast方法:");
            LinkedList s = new LinkedList();
            s.addLast(1);
            s.addLast(2);
            s.addLast(3);
            s.addLast(4);
            s.display();
        }
        public static void testAddIndex(){
            System.out.println("测试addIndex方法:");
            LinkedList s = new LinkedList();
            s.addLast(1);
            s.addLast(2);
            s.addLast(3);
            s.addLast(4);
            s.display();
            s.addIndex(2,5);
            s.display();
        }
        public static void testContains(){
            System.out.println("测试contains方法:");
            LinkedList s = new LinkedList();
            s.addLast(1);
            s.addLast(2);
            s.addLast(3);
            s.addLast(4);
            boolean result = s.contains(5);
            System.out.println(result);
        }
        public static void testRemove(){
            System.out.println("测试remove方法:");
            LinkedList s = new LinkedList();
            s.addLast(1);
            s.addLast(2);
            s.addLast(3);
            s.addLast(2);
            s.remove(2);
            s.display();
        }
    public static void testClear() {
        System.out.println("测试clear方法:");
        LinkedList s = new LinkedList();
        s.addLast(1);
        s.addLast(2);
        s.addLast(3);
        s.addLast(4);
        s.clear();
        s.display();
    }
    public static void testRemoveAlkey() {
        System.out.println("测试removeAllkey方法:");
        LinkedList s = new LinkedList();
        s.addLast(1);
        s.addLast(2);
        s.addLast(2);
        s.addLast(4);
        s.removeAllKey(2);
        s.display();
    }
}
