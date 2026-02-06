public class ArrayRotation {
    public static void printArray(int[] arr, int len){
        System.out.print("Array Elements are: ");
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String... args){
        int arr[] = {1, 2, 3, 4, 5,6};
        int k=3;
        System.out.printf("Before Rotation (%d Positions): ",k);
        printArray(arr, arr.length);
        leftRotateByKBrute(arr,3);
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
    public static void rightRotateByKBrute(int[] arr, int k){
        
    }
    public static void leftRotateByKBrute(int[] arr, int k){
        int[] temp = new int[k];
        for(int i=0;i<k;i++){
            temp[i]=arr[i];
        }
        for(int i=k;i<arr.length;i++)
            arr[i-k]=arr[i];
        for(int i=0;i<temp.length;i++)
            arr[i+k]=temp[i];
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
