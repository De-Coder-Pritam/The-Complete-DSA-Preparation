public class SearchInSortedRotatedArrayProblem {
    /*
    Given an integer array nums, sorted in ascending order (with distinct values) and a target value k.
    The array is rotated at some pivot point that is unknown.
    Find the index at which k is present and if k is not present return -1.
    Example 1
    Input : nums = [4, 5, 6, 7, 0, 1, 2], k = 0
    Output: 4
    Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums.
    Thus, we get output as 4, which is the index at which 0 is present in the array.
    Example 2
    Input: nums = [4, 5, 6, 7, 0, 1, 2], k = 3
    Output: -1
    Explanation: Here, the target is 3.
    Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.
 */
    public static void main(String[] args){
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0,target2 = 3;
        System.out.println(searchOptimal(nums1,target1));
        System.out.println(searchOptimal(nums2,target2));
    }
    public static int searchBrute(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == k)
                return i;
        }
        return -1;
    }
    public static int searchOptimal(int[] nums, int k){
        int low = 0,high=nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == k) return mid;

            if(nums[low]<=nums[mid]){
                if(k < nums[mid] && nums[low]<= k){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(k>nums[mid] && k<=nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
