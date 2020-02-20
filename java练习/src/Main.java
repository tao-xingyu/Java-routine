public class Main {


    public static void quick(int[] arr,int low,int high){
        int p = partion(arr,low,high);
        if(p > low + 1){
            quick(arr,low,p - 1);
        }
        if(p < high - 1){
            quick(arr,p + 1,high);
        }
    }
    public static int partion(int[] arr,int low,int high){
        int i = low;
        int j = high;
        int p = arr[low];
        while(i < j){
            while(i < j && arr[j] >= p){
                j--;
            }
            while(i < j && arr[i] <= p){
                i++;
            }
            Swap(arr,i,j);
        }
        Swap(arr,i,low);
        return i;
    }
    public static int  Swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return tmp;
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] > arr[j+1]){
                    Swap(arr,j,j+1);
                }
            }
        }
    }


    public static void adjustDown(int[] arr,int root,int len){
        int parent = root;
        int child = parent * 2 + 1;
        while(child < len){
            if(child < len && arr[child] < arr[child+1]){
                child = child + 1;
            }
            if(arr[child] > arr[parent]){
                Swap(arr,child,parent);
                parent = child;
                child = parent * 2 + 1;
            }else{
                break;
            }
        }
    }
    public static void heapSort(int[] arr){
        for (int i =(arr.length - 1-1)/2; i >=0 ; i--) {
            adjustDown(arr,i,arr.length);
        }
        int high = arr.length - 1;
        while(high > 0){
            Swap(arr,0,high);
            high--;
        }
    }
}
