import java.util.*;
public class TwoSumQuestionLeetCode {
        public static void main(String... args){
            int []arr = {2,7,11,15};
            int[]arr2 = {3,3};
            int[]arr3 = {3,2,4};
            printArray(twoSum(arr3,6));
//            printArray(twoSumAlternate(arr,9));
        }
        public static void printArray(int[] arr){
            for(int i: arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        public static int[] twoSumAlternate(int[] nums, int target){
            int[] arr = new int[2];
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]+nums[j] == target){
                        arr[0] = i;
                        arr[1] = j;
                        return arr;
                    }
                }
            }
            return arr;
        }
        public static int[] twoSum(int[] nums, int target) {
            int[]arr = new int[2];
            Map<Integer,Integer> vals = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                vals.put(nums[i],i);
            }
            for(int i=0;i<nums.length;i++){
                if(vals.containsKey(target-nums[i]) && i != vals.get(target-nums[i])) {
                    arr[0] = i;
                    arr[1] = vals.get(target - nums[i]);
                    System.out.println(arr[0]);
                    System.out.println(arr[1]);
                    break;
                }
            }
            return arr;

        }

}
