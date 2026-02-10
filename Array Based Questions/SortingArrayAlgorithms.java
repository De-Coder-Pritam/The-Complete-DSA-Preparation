import java.util.*;
public class SortingArrayAlgorithms {
    public static void main(String... args){
//        System.out.println("Hello World!");
        int[] arr = {7,6,5,4,3,2,1};

        printArray(arr);
////        selection_sort(arr);
////        bubble_sort(arr);
////        insertion_sort(arr);
//        merge_sort(arr,0,arr.length-1);
//        printArray(arr);
//        printPattern(4);
//        bubble_sort_recursive(arr,arr.length);
//        insertion_sort_recursive(arr,1);
        quick_sort(arr,0, arr.length-1);
        printArray(arr);

    }
    public static int partition(int[]arr, int low, int high){
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=pivot && i<high){
                i++;
            }
            while(arr[j]>pivot && j>low){
                j--;
            }
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[j];
        arr[j]=arr[low];
        arr[low]=temp;
        return j;
    }
    public static void quick_sort(int[] arr, int low, int high){
        if(low<high){
            int pIndex = partition(arr,low,high);
            quick_sort(arr,low,pIndex-1);
            quick_sort(arr,pIndex+1,high);
        }
    }
    public static void insertion_sort_recursive(int[]arr, int n){
        if(n==arr.length){
            return;
        }
        int j=n;
        while(j>0 && arr[j-1]>arr[j]){
            int temp = arr[j];
            arr[j]=arr[j-1];
            arr[j-1]=temp;
            j--;
        }
        insertion_sort_recursive(arr, n+1);
    }
    public static void bubble_sort_recursive(int[] num,int n){
        if(n==1){
            return;
        }
        for(int i=0;i<n-1;i++){
            if(num[i]>num[i+1]){
                int temp=num[i];
                num[i]=num[i+1];
                num[i+1]=temp;
            }
        }
        bubble_sort_recursive(num,n-1);
    }

    public static void printPattern(int num){
        for(int i=1;i<=(num*2)-1;i++){
            for(int j=1;j<=(num*2)-1;j++){
                int top=i;
                int left=j;
                int bottom=(2*num)-i;
                int right=(2*num)-j;
                int min = Math.min(Math.min(top,bottom),Math.min(left,right));
                System.out.print(num-min+1);
            }
            System.out.println();
        }
    }
    public static void merge(int[]arr,int low, int mid, int high ){
        List<Integer> lst = new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<arr[right]){
                lst.add(arr[left++]);
            }else{
                lst.add(arr[right++]);
            }
        }
        while(left<=mid){
            lst.add(arr[left++]);
        }while(right<=high){
            lst.add(arr[right++]);
        }
        for(int i=low;i<=high;i++){
            arr[i] = lst.get(i-low);
        }

    }
    public static void merge_sort(int[]arr, int low, int high){
        if(low>=high){
            return;
        }
        int mid = (low+high)/2;
        merge_sort(arr,low,mid);
        merge_sort(arr,mid+1,high);
        merge(arr,low,mid,high);

    }
    public static void printArray(int[] arr){
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
    public static void insertion_sort(int[] arr){
        for(int i=1;i<arr.length;i++){

           int j=i;
                while(j>0 && arr[j-1]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    j--;
                }

        }
    }
    public static void bubble_sort(int[] arr){

        for(int i=arr.length-2;i>=0;i--){
            boolean swap = false;
            for(int j=0;j<=i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap = true;
                }
            }
            if(!swap)
                return;
            }
        }

    public static void selection_sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

}