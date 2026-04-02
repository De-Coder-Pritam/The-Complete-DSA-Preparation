public class SplitArrayLargestSumProblem {
    /*
    Given an integer array a of size n and an integer k. Split the array a into k
    non-empty subarrays such that the largest sum of any subarray is minimized.
    Return the minimized largest sum of the split.
    Example 1
    Input: a = [1, 2, 3, 4, 5], k = 3
    Output:6
    Explanation: There are many ways to split the array a[] into k consecutive subarrays.
    The best way to do this is to split the array a[] into [1, 2, 3], [4], and [5],
    where the largest sum among the three subarrays is only 6.
    Example 2
    Input: a = [3,5,1], k = 3
    Output: 5
    Explanation: There is only one way to split the array a[] into 3 subarrays,
    i.e., [3], [5], and [1]. The largest sum among these subarrays is 5.
     */
    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {3,5,1};
        System.out.println(splitArrayLargestSumBrute(nums1,3));
        System.out.println(splitArrayLargestSumBrute(nums2,3));
        System.out.println(splitArrayLargestSumOptimal(nums1,3));
        System.out.println(splitArrayLargestSumOptimal(nums2,3));

    }
    public static int splitArrayLargestSumOptimal(int[]nums, int k){
        int low=0,high=0;
        if(k>nums.length) return -1;
        for(int num:nums){
            low=Math.max(num,low);
            high+=num;
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(splitArray(nums,mid)>k){
            low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    public static int splitArray(int[] nums, int split){
        int cnt=1,last=nums[0];
        for(int i=1;i<nums.length;i++){
            if((last+nums[i])<=split){
                last+=nums[i];
            }else{
                cnt++;
                last=nums[i];
            }
        }
        return cnt;

    }
    public static int splitArrayLargestSumBrute(int[]nums, int k){
        int low=0,high=0;
        if(k>nums.length) return -1;
        for(int num:nums){
            low=Math.max(num,low);
            high+=num;
        }
        for(int i=low;i<=high;i++){
            if(splitArray(nums,i) == k){
                return i;
            }
        }
        return -1;
    }
}
