
import java.util.*;
public class Test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length;i++){
            arr[i] = 1;
        }
        int count = 0;
        while(n > 1){
            for(int i = 0;i <arr.length ;i++){
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
        for(int i = 0; i <arr.length;i++){
            if(arr[i] == 1){
                System.out.println(i);
            }
        }
    }
}
