package Work;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Test4 {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            if (n!=0){
                int count = 0;
                while(n >= 3){
                    if(n % 3 == 0){
                        count += n / 3;
                        n = n / 3;
                    }else{
                        count += n / 3;
                        int t = n % 3;
                        n = t + n / 3;
                    }
                }
                if(n == 2){
                    count += 1;
                }
                System.out.println(count);
            }
        }
    }


    public static int count(int[] A, int n) {
        int count = 0;
            for (int i = 0; i <n; i++) {
                for (int j = i + 1; j <n; j++) {
                    if (A[i] > A[j]) {
                        count++;
                    }
                }
            }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,4,5,6,7,0};
        int len = 8;
        int k = count(arr,8);
        System.out.println(k);
    }

    public static void main2(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.next();
        char[] array = str.toCharArray();
        int len = 0;
        int r = 0;
        int maxL = len,maxR = r;
        int max = 0;
        while(r != array.length){
            if(len == r){
                if(array[len] >= 'a' && array[len] <= 'z'){
                    len++;
                    r++;
                }else{
                    r++;
                }
            }else{
                if(array[r] >= 'a' && array[r] <= 'z'){
                    if(r -len > max){
                        max = r -len;
                        maxL = len;
                        maxR = r;
                    }
                    len = r;
                }else{
                    r++;
                    if(r == array.length){
                        if(r -len >max){
                            max = r - len;
                            maxL = len;
                            maxR = r;
                        }
                    }
                }
            }
        }
        for(int i = maxL; i < maxR;i++){
            System.out.print(array[i]);
        }
    }
}