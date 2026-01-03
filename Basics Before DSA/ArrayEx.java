import java.util.Arrays;
import java.util.Scanner;
public class ArrayEx {
    public static void main(String ... args){
//        Scanner sc = new Scanner(System.in);
//        printInputArray(sc);
//        int[] arr = {12,3,54,23,5,12};
//        System.out.println("Second Largest Element: "+getSecondMaxArray(arr));
//        System.out.println("Second Largest Element: "+getSecondMax(arr));
//        System.out.println("Count of Odd Integers in array: "+countOddArray(arr));
//        System.out.println("Count of Even Integers in array: "+countEvenArray(arr));
//        System.out.println("Sum of array is: "+getSumArray(arr));
//        System.out.println("Min Value from array is: "+getMinArray(arr));
//        System.out.println("Max Value from array is: "+getMaxArray(arr));

    }
    public static int getSecondMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i])
                max = arr[i];
        }
        int secMax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(secMax<arr[i] && arr[i] != max)
                secMax = arr[i];
        }
        return secMax;
    }
    public static int getSecondMaxArray(int[] arr){
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int length = arr.length-1;
        while(max == arr[length]){
            length--;
        }
        return arr[length];
    }
    public static int countOddArray(int[] arr){
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                cnt++;
            }
        }
        return cnt;
    }
    public static int countEvenArray(int[] arr){
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                cnt++;
            }
        }
        return cnt;
    }
    public static int getSumArray(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }
    public static int getMinArray(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
    public static int getMaxArray(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i])
                max=arr[i];
        }
        return max;
    }

    public static void printInputArray(Scanner sc){
        System.out.println("Enter Number of values you want to Enter: ");
        int num = sc.nextInt();
        int[] arr = new int[num];

        for(int i=0;i<num;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Inputted Elements: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
