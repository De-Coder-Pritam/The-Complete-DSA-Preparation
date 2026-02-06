public class ArrayRotation {
    public static void printArray(int[] arr, int len){
        System.out.print("Array Elements are: ");
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String... args){
        int arr[] = {1, 2, 3, 4, 5,6,7};
        int k=2;
        System.out.printf("Before Rotation (%d Positions): ",k);
        printArray(arr, arr.length);
        rightRotateByKOptimal(arr,k);
        System.out.printf("After Rotation (%d Positions): ",k);
        printArray(arr, arr.length);
//        ------Rotation By One Problem---------
//        System.out.println("Before Rotation: ");
//        printArray(arr,arr.length);
//        leftRotateByOneOptimal(arr);
//        System.out.println("After Rotation: ");
//        printArray(arr, arr.length);
//        System.out.println("After Rotation: ");
//        leftRotateByOneBrute(arr);


    }
    public static void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void rightRotateByKOptimal(int[] arr, int k){
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
    }
    public static void leftRotateByKOptimal(int[] arr, int k){
        reverse(arr, 0, k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    public static void rightRotateByKBrute(int[] arr, int k){
        int[] temp = new int[k];
        for(int i=arr.length-k,j=0;i<arr.length;i++,j++){
            temp[j]=arr[i];
        }
        for(int i=arr.length-k-1;i>=0;i--){
            arr[i+k]=arr[i];
        }
        for(int i=0;i<k;i++){
            arr[i]=temp[i];
        }
    }
    public static void leftRotateByKBrute(int[] arr, int k){
        int[] temp = new int[k];
        for(int i=0;i<k;i++){
            temp[i]=arr[i];
        }
        for(int i=k;i<arr.length;i++)
            arr[i-k]=arr[i];
        for(int i=0;i<temp.length;i++)
            arr[arr.length-k+i]=temp[i];
    }
    public static void leftRotateByOneBrute(int[] arr){
        int [] temp = new int[arr.length];
        for(int i=1;i<arr.length;i++){
            temp[i-1]=arr[i];
        }
        temp[temp.length-1]=arr[0];
        printArray(temp,temp.length);
    }
    public static void leftRotateByOneOptimal(int[] arr){
        int temp = arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=temp;
    }
}
