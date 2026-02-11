import java.awt.*;
import java.util.HashMap;

public class SingleNumberAppearanceProblem {
//    Given an array of nums of n integers. Every integer in the array appears twice except one integer. Find the number that appeared once in the array.
//    Example 1
//    Input : nums = [1, 2, 2, 4, 3, 1, 4]
//    Output : 3
//    Explanation : The integer 3 has appeared only once.
    public static void main(String[] args){
        int[] nums = {1, 2, 2, 4, 3, 1, 4};
        System.out.println("The number that appears one time is "+getSingleNumberOptimal(nums));
    }
    public static int getSingleNumberBrute(int[] arr){
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr.length;j++){
                if(arr[i] == arr[j])
                    count++;
            }
            if(count == 1){
                return arr[i];
            }
        }
        return -1;
    }
    public static int getSingleNumberBetter(int[] arr){
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int val: arr){
            mp.put(val,mp.getOrDefault(val,0)+1);
        }

        for(Integer key: mp.keySet()){
            if(mp.get(key) == 1){
                return key;
            }
        }
        return -1;
    }
    public static int getSingleNumberOptimal(int[] arr){
        int xor=0;
        for(int i=0;i<arr.length;i++){
            xor ^=arr[i];
        }
        return xor;
    }
}
