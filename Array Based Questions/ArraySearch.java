import java.util.ArrayList;

public class ArraySearch {

//    Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
//    Output: 6
//    Explanation: All the numbers from 1 to 8 are present except 6.
//
//    Input: arr[] = [1, 2, 3, 5]
//    Output: 4
//    Explanation: Here the size of the array is 4, so the range will be [1, 5]. The missing number between 1 to 5 is 4
    public static void main(String... args){
        int[] ar = {1,2,3,4};
        int target = 3;
        System.out.println("Element is at :"+getIndexOfElementLinearSearch(ar,target));
    }
    public static int getIndexOfElementLinearSearch(int[] arr, int num ){

        for(int i=0;i<arr.length;i++){
            if(arr[i]==num)
                return i;
        }
        return -1;

    }
    public static int getIndexLinear(ArrayList<Integer> arr, int target){
        for(int i=0;i<arr.size();i++){
            if(arr.get(i) == target)
                return i;

        }
        return -1;
    }
}
