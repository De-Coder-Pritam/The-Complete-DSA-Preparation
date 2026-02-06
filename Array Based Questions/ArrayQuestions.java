import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;

public class ArrayQuestions {

    public static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static boolean isArraySorted(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1])
                return false;
        }
        return true;
    }
    public static int removeDuplicatesOptimal(int[] arr){
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        return i+1;
    }
    public static int removeDuplicatesBrute(int[] arr){
        Set<Integer> seen = new LinkedHashSet<>();
        int index=0;
        for(int num: arr){
            if(!seen.contains(num)){
                seen.add(num);
                arr[index]=num;
                index++;
            }
        }
        return index;
    }
    public static void main(String... args){
        int[] nums = {0,0,2,3,3,4,5,5,5};
        int len = removeDuplicatesOptimal(nums);
        for(int i=0;i<len;i++){
            System.out.print(nums[i]+" ");
        }

//        int[] arr1 = {2, 5, 1, 3, 0};
//        int[] arr2 = {2,5,6,7,8,9};
//        System.out.println("Array1 is sorted: "+isArraySorted(arr1));
//        System.out.println("Array2 is sorted: "+isArraySorted(arr2));

//        int[] arr1 = {2, 5, 1, 3, 0};
//        int[] arr2 = {8, 10, 5, 7, 9};
//        // Find and output the largest element in both arrays
//        System.out.println("The Second Largest element in the array is: " + findSecondMaxBrute(arr1));
//        System.out.println("The Second Largest element in the array is: " + findSecondMaxBetter(arr1));
//        System.out.println("The Second Largest element in the array is: " + findSecondMaxOptimal(arr1));
//
//        System.out.println("The Second Largest element in the array is: " + findSecondMaxBrute(arr2));
//        System.out.println("The Second Largest element in the array is: " + findSecondMaxBetter(arr2));
//        System.out.println("The Second Largest element in the array is: " + findSecondMaxOptimal(arr2));


//        // Find and output the largest element in both arrays
//        System.out.println("The Largest element in the array is: " + findMaxBrute(arr1));
//        System.out.println("The Largest element in the array is: " + findMaxBrute(arr2));
//        // Find and output the largest element in both arrays
//        System.out.println("The Largest element in the array is: " + findMaxOptimal(arr1));
//        System.out.println("The Largest element in the array is: " + findMaxOptimal(arr2));


    }
    public static int findSecondMaxBrute(int[] arr){
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int secondMaxIndex=arr.length-2;
        while(arr[secondMaxIndex] == max){
            secondMaxIndex--;
        }
        return arr[secondMaxIndex];
    }
    public static int findSecondMaxBetter(int[] arr){
        int max = findMaxOptimal(arr);
        int secondMax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>secondMax && arr[i] != max){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
    public static int findSecondMaxOptimal(int[] arr){
        int max=Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i]>secondMax){
                secondMax=arr[i];
            }
        }
        return secondMax;
    }
    public static int findMaxBrute(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
    public static int findMaxOptimal(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;

    }
}
