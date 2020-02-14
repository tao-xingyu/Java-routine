package Question;

import java.util.Scanner;

public class Application {
    //先输出字符串;再判断首字母是否为大写;输出大写字母;
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);
        char x = str.charAt(0);//判断第一个字母是不是大写
        if (x >= 'A' && x <= 'Z') {
            int n = 0;
            char[] arr = str.toCharArray();//把字符串变成字符数组

            for (int i = 0; i <= str.length() - 1; i++) {
                if (arr[i] >= 'A' && arr[i] <= 'Z') {
                    System.out.println("输出大写字母:" + arr[i]);
                    n++;
                }
            }
            System.out.println("输出大写字母个数:" + n);
        } else {
            System.out.println("第一个字母不是大写字母!");
        }
    }
//统计字符串个数,然后逆序输出
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        int i;
        int count = 0;
        System.out.print("逆置字符串为:");
        for (i = str.length() - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            count++;
        }
        System.out.println();
        System.out.println("字符个数有:" + count + "个");
    }
//玩游戏,从1到3数数字,凡是数到3的退出游戏,求最后剩下的玩家下标
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;//全部标记为1,数组初始化
        }
        int count = 0;
        while (n > 1) {//人数大于1进入循环
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    count++;//开始数数
                    if (count == 3) {
                        arr[i] = 0;//数到3的标记为0
                        count = 0;//重新开始数数
                        n--;//人数少一个
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {//最后剩下的1,就是唯一留下的
                System.out.println(i);
            }
        }
    }
    //3*3矩阵的对角线元素之和
    public static void main(String[] args) {
        int[][]arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++){
                if(i==j){
                    sum1 += arr[i][j];//对角线1
                }
                if(j==arr.length-i-1) {
                    sum2 += arr[i][j];//对角线2
                }
            }
        System.out.println("矩阵对角线之和分别是："+sum1+"和"+sum2);
    }
}
