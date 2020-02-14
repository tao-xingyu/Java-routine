package Work;

import java.util.Scanner;

public class work1128 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            if(str.length()>8 && Con(str) >= 3 && Ischongfu(str)){
                System.out.println("OK");
            }else{
                System.out.println("INVALID");
            }
        }
    }

    //包括至少三种符号
    public static int Con(String str){
        int count = 0;
        if(str.length()-str.replaceAll("[A-Z]","").length()>0){
            count++;
        }
        if(str.length()-str.replaceAll("[a-z]","").length()>0){
            count++;
        }
        if(str.length()-str.replaceAll("[0-9]","").length()>0){
            count++;
        }
        if(str.length()-str.replaceAll("[A-Z,0-9,a-z]","").length()>0){
            count++;
        }
        return count;
    }

    //判断是否有长度超过2的连续字符串重复
    public static boolean Ischongfu(String str){
        int[][] dp=new int[str.length()+1][str.length()+1];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <str.length() ; j++) {
                if(str.charAt(i)==str.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }
            }
        }
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(i) != str.charAt(j)){
                    arr[dp[i][j]]++;
                }
            }
        }
        for (int i = 3; i <arr.length ; i++) {
            if(arr[i]>1){
                return false;
            }
        }
        return true;
    }
}
