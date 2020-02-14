package Question;

import jdk.nashorn.internal.runtime.FindProperty;

public class OneQuestion {
    public static void main2(String[] args) {
       int[][] arr = {
               {1,2,8,9},
               {2,4,9,12},
               {4,7,10,13},
               {6,8,11,15}
       };
       int[] p = Find_val(arr,4,4,4);
        System.out.println(p[0]+" , "+p[1]);
    }


    public static int[] Find_val(int[][] str,int row,int col,int num){
        int[] array = new int[2];
        int i = 0;
        int j = col -1;
        while(i < row && j >= 0){
            if(str[i][j] > num){
                j--;
            } else if (str[i][j] < num) {
                i++;
            }else {
                array[0] = i;
                array[1] = j;
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {//杀人游戏,数到3就die
        int k = 5;
        int ret = function(k);
        System.out.println(ret);
    }
    public static int function(int n){
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        int count = 0;
        while(n >1){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == 1){
                    count++;
                    if(count == 3){
                        arr[i] = 0;
                        count = 0;
                        n--;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main3(String[] args) {
        int str[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},};
        int num = 0;
        boolean x = FindNnm(str,3,4,0);
        System.out.println(x);
    }
    public static boolean FindNnm(int[][]arr,int row,int col,int num){
        int i = 0;
        int j = col - 1;
        while(i < row && j >= 0){
            if(arr[i][j] > num){
                j--;
            }else if(arr[i][j] < num){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}