//import org.omg.CORBA.PUBLIC_MEMBER;

//import java.util.Scanner;

//public class Work {
//    public static void main(String[] args) {
//        int n = 55;
//        if(n > 0 && n <= 18){
//            System.out.println("是少年");
//        }
//        if(n >= 19 && n <= 28){
//            System.out.println("是青年");
//        }
//        if(n >= 29 && n <= 55){
//            System.out.println("是中年");
//        }
//        if(n >= 56){
//            System.out.println("是老年");
//        }
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int num = 7;
//        int count =0;
//        for(int i = 2;i < num;i++){
//            if(num % i == 0){
//                count++;
//            }
//        }
//        if(count == 0){
//            System.out.println("是素数");
//        }else{
//            System.out.println("不是素数");
//        }
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int i,j;
//        for(i = 1;i <= 100;i++){
//            for(j = 2;j < i;j++){
//                if(i % j == 0){
//                    break;
//                }
//            }
//            if(i == j){
//                System.out.println(i);
//            }
//        }
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int year;
//        for(year = 1000;year <= 2000;year++){
//            if((year % 4 == 0 && year % 100 != 0)
//                    ||(year % 400 == 0)){
//                System.out.println(year);
//            }
//        }
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int i,j;
//        for (i = 1; i <= 9;i++) {
//            for(j = 1;j <= i;j++){
//                System.out.print(" "+j+"*"+i+"="+i * j);
//            }
//            System.out.println();
//        }
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int a = 3;
//        int b = 6;
//        if(a != b){
//            if(a > b){
//                a = a-b;
//            }
//            else{
//                b = b- a;
//            }
//        }
//        System.out.println("最大公约数为:"+a);
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int i,flag = 1;
//        double ret,sum = 0;
//        for(i = 1;i <= 100;i++){
//            ret = flag * (1.0 / i);
//            sum = sum + ret;
//            flag = flag * (-1);
//        }
//        System.out.println(sum);
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int count = 0;
//        for (int i = 1; i < 100; i++) {
//            if(i % 10 == 9){
//                count++;
//            }
//            if(i / 10 == 9){
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int sum = 0;
//        for(int i = 0;i <= 999;i++){
//           int hundred = i / 100;
//           int ten = i /10 % 10;
//           int bits = i % 10;
//           sum = hundred*hundred*hundred+ten*ten*ten
//                   +bits*bits*bits;
//            if (sum == i) {
//                System.out.println(i);
//            }
//        }
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            System.out.println("请输入密码");
//            Scanner s = new Scanner(System.in);
//            String password = s.next();
//            if(password.equals("123456")){
//                System.out.println("输入正确!");
//                break;
//            } else if(i < 2){
//                System.out.println("密码错误,请重新输入!");
//            }else if(i == 2){
//                System.out.println("三次机会已用完!");
//            }
//
//        }
//
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int n = 1;
//        int count = 0;
//        while(n != 0 ){
//            count++;
//            n = n & (n - 1);
//        }
//        System.out.println(count);
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int num = 1;
//        odd(num);
//        System.out.println();
//        even(num);
//    }
//    public static void odd(int num){
//        for (int i = 30; i >= 0 ; i = i -2) {
//            if((num & (1 << i)) != 0){
//                System.out.print("1");
//            }else{
//                System.out.print("0");
//            }
//        }
//    }
//    public static void even(int num){
//        for (int i = 31; i >= 0 ; i = i - 2) {
//            if((num & (1 << i)) != 0){
//                System.out.print("1");
//            }else{
//                System.out.print("0");
//            }
//        }
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int num = 1234;
//        Print(num);
//    }
//    public static void Print(int num){
//        if(num > 9){
//            Print(num / 10);
//        }
//        System.out.print(num % 10+" ");
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        menu();
//    }
//    public static void Game(){
//        Scanner s = new Scanner(System.in);
//        int r = (int)(Math.random()*100+1);
//        while (true){
//            System.out.println("请输入一个数字:");
//            int n = s.nextInt();
//            if(r == n){
//                System.out.println("恭喜你,猜对了!");
//                break;
//            }else if(n < r){
//                System.out.println("猜小了!");
//            }else{
//                System.out.println("猜大了!");
//            }
//        }
//    }
//    public static void menu(){
//        System.out.println("**************");
//        System.out.println("****1.play****");
//        System.out.println("****0.exit****");
//        System.out.println("**************");
//       Scanner choice = new Scanner(System.in);
//           int input = choice.nextInt();
//           if(input == 0){
//               System.out.println("游戏退出");
//               return;
//            }else if(input == 1){
//               System.out.println("游戏开始");
//               Game();
//           }else{
//               System.out.println("您的输入有误!");
//           }
//    }
//}


//public class Work{
//    public static void main(String[] args) {
//        int k = 4;
//        int ret = Fun(k);
//        System.out.println(ret);
//    }
//    public static int Fun(int n){
//        if(n == 1){
//            return 1;
//        }
//        return n * Fun(n - 1);
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int m = 10;
//        int ret = Add(m);
//        System.out.println(ret);
//    }
//    public static int Add(int n){
//        if(n == 1){
//            return 1;
//        }
//        return n + Add(n - 1);
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int n = 1234;
//        Print(n);
//    }
//    public static void Print(int num){
//        if(num > 9){
//            Print(num / 10);
//        }
//        System.out.print(" "+num % 10);
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int n = 1234;
//        int ret = Add(n);
//        System.out.println(ret);
//    }
//    public static int Add(int num){
//        if(num == 0){
//            return 0;
//        }
//        return num % 10+Add(num / 10);
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int k = 6;
//        int ret = Fab(k);
//        System.out.println(ret);
//    }
//    public static int Fab(int n){
//        if(n == 1 || n == 2){
//            return 1;
//        }
//        return Fab(n - 1) + Fab(n - 2);
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        hanNuoTa(3,'A','B','C');
//    }
//    public static void hanNuoTa(int n,char from,char in,char to){
//        if(n == 1){
//            System.out.println("把第一个从"+from+"移动到"+to);
//        }else{
//            hanNuoTa(n - 1,from,in,to);
//            System.out.println("把第"+n+"个从"+from+"移动到"+to);
//            hanNuoTa(n - 1,in,from,to);
//        }
//    }
//}
//public class Work{
//    public static void main(String[] args) {
//        int k = 4;
//        int ret = Jump(k);
//        System.out.println(ret);
//    }
//    public static int Jump(int n){
//        if(n == 1){
//            return 1;
//        }if(n == 2){
//            return 2;
//        }
//        return Jump(n- 1)+Jump(n- 2);
//    }
//}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Work {
//    public static void main1(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.next
// Int();
//        int sum = 1;
//        for (int i = 1; i <= n; i++) {
//            sum *= i;
//        }
//        int count = 0;
//        while (sum % 10 == 0) {
//            count++;
//            sum = sum / 10;
//        }
//        System.out.println(count);
//    }
    public static List<Integer> find(int[] array) {
        if (array == null || array.length <= 1) {
            return null;
        }
        if (array.length % 2 == 1) {
            return null;
        }
        List<Integer> result = new ArrayList<>(2);
        if (array.length == 2) {
            for (int i : array) {
                result.add(i);
            }
            return result;
        }
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            x ^= array[i];
        }
        int bitIndex = findFirstBitIs1(x);
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (is1OfBitIndex(array[i], bitIndex)) {
                n1 ^= array[i];
            } else {
                n2 ^= array[i];
            }
        }
        result.add(n1);
        result.add(n2);
        return result;
    }
    private static int findFirstBitIs1(int n) {
        int bitIndex = 0;
        while ((n & 1) == 0) {
            // 如果当前位不是1，则右移一位
            n = n >> 1;
            bitIndex++;
        }
        return bitIndex;
    }
    private static boolean is1OfBitIndex(int n, int index) {
        n = n >> index;
        return (n & 1) == 0;
    }

}