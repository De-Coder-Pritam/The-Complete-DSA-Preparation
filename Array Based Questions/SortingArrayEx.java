
public class SortingArrayEx {
    public static void main(String... args){
        System.out.println("Hello World!");
        int[] arr = {7,6,5,4,3,2,1};

        printArray(arr);
//        selection_sort(arr);
//        bubble_sort(arr);
        insertion_sort(arr);
        printArray(arr);

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