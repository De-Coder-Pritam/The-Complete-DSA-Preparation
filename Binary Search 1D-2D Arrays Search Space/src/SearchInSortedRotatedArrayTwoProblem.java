public class SearchInSortedRotatedArrayTwoProblem {
    /*
    Given an integer array nums, sorted in ascending order (may contain duplicate values)
    and a target value k. Now the array is rotated at some pivot point unknown to you.
    Return True if k is present and otherwise, return False.
    Example 1
    Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3
    Output: True
    Explanation: The element 3 is present in the array. So, the answer is True.
    Example 2
    Input : nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 10
    Output: False
    Explanation:The element 10 is not present in the array. So, the answer is False.
     */
    public static void main(String[] args){
        int[] nums = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int target1 = 3, target2 = 10;
        System.out.println(searchInARotatedSortedArrayIIOptimal(nums,target1));
        System.out.println(searchInARotatedSortedArrayIIOptimal(nums,target2));
    }
    public static boolean searchInARotatedSortedArrayIIOptimal(int[] nums, int k){
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == k) return true;
            if(nums[mid] == nums[low] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }
            if(nums[low]<=nums[mid]){
                if(nums[low]<=k && nums[mid]>k){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(nums[high]>=k && nums[mid]<k){
                    low = mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
    public static boolean searchInARotatedSortedArrayIIBrute(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == k) return true;
        }
        return false;
    }
}
