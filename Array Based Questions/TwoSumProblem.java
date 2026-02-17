import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSumProblem {
    public static void main(String[] args){
        int[] nums = {1, 6, 2, 10, 3};
        System.out.println(twoSumOptimal(nums,56));
    }
    public static boolean twoSumOptimal(int[] arr, int target){
        Arrays.sort(arr);
        int left=0,right=arr.length-1;
        while(left<=right){
            if(arr[left]+arr[right] == target){
                return true;
            }
            else if(arr[left]+arr[right] > target){
                right--;
            }
            else if(arr[left]+arr[right] < target){
                left++;
            }
        }
        return false;
    }
    public static int[] twoSumBetter(int[] arr, int target){
        int[] result = {-1,-1};
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int rem =  target - arr[i] ;
            if(mp.containsKey(rem)){
                result[0]=mp.get(rem);
                result[1]=i;
            }
            mp.put(arr[i],i);
        }

        return result;
    }
    public static int[] twoSumBrute(int[] arr, int target){
        int[] result = {-1,-1};
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }
}
