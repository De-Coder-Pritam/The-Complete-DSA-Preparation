import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class MovingZerosProblem {
    public static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }


    public static void main(String... args){

        int[] arr = { 0, 1, 4, 0, 5, 2};
        movingZerosAtEndBrute(arr);
        movingZerosAtEndOptimal(arr);
        printArray(arr);

    }
    public static void movingZerosAtEndBrute(int[] arr){
        int []temp = new int[arr.length];
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                temp[j]=arr[i];
                j++;
            }
        }
        for(int i=0;i<j;i++){
            arr[i]=temp[i];
        }
        for(int i=j;i<arr.length;i++){
            arr[i]=0;
        }

    }
    public static void movingZerosAtEndOptimal(int[] arr){
        int i=0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=0){
                arr[i]=arr[j];
                i++;
            }
        }
        for(int j=i;j<arr.length;j++){
            arr[j]=0;
        }
    }
}
