import java.util.HashMap;

public class LargestSubArraySumZeroProblem {
//    You are given an integer array arr of size n which contains both positive and negative integers. Your task is to find the length of the longest contiguous subarray with sum equal to 0.
//    Return the length of such a subarray. If no such subarray exists, return 0.
//    Example 1
//    Input: arr = [15, -2, 2, -8, 1, 7, 10, 23]
//    Output: 5
//    Explanation:
//    The subarray [-2, 2, -8, 1, 7] sums up to 0 and has the maximum length among all such subarrays.
//    Example 2
//    Input: arr = [2, 10, 4]
//    Output: 0
//    Explanation:
//    There is no subarray whose elements sum to 0.
    public static int largestSubArraySumZeroOptimal(int[] arr){
        int max = 0;
        int n = arr.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int sum = 0;

        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum == 0){
                max = i+1;
            }else if(mpp.containsKey(sum)){
                max = Math.max(max, i-mpp.get(sum));
            }else{
                mpp.put(sum,i);
            }
        }
        return max;
    }
    public static int largestSubArraySumZeroBrute(int []nums){
        int max=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+= nums[j];
                if(sum == 0){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums1 = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] nums2 = {2, 10, 4};
        System.out.println(largestSubArraySumZeroOptimal(nums1));
        System.out.println(largestSubArraySumZeroOptimal(nums2));
    }
}
