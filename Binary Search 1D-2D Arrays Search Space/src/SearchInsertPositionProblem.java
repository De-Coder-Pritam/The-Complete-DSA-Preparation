public class SearchInsertPositionProblem {
    /*
    Given a sorted array of nums consisting of distinct integers and a target value,
    return the index if the target is found. If not, return the index where it
    would be if it were inserted in order.
    Example 1
    Input: nums = [1, 3, 5, 6], target = 5
    Output: 2
    Explanation: The target value 5 is found at index 2 in the sorted array.
    Hence, the function returns 2.
    Example 2
    Input: nums = [1, 3, 5, 6], target = 2
    Output: 1
    Explanation: The target value 2 is not found in the array. However,
    it should be inserted at index 1 to maintain the sorted order of the array.
     */
    public static void main(String[] args){
        int[] nums1 = {1, 3, 5, 6};
        int[] nums2 = {1, 3, 5, 6};
        int target1= 5,target2= 2;
        System.out.println(searchInsertPositionOptimal(nums1,target1));
        System.out.println(searchInsertPositionOptimal(nums2,target2));
    }
    public static int searchInsertPositionOptimal(int[] nums, int x){
        int start=0,end=nums.length-1;
        while(start <= end){
            int mid = start +(end-start)/2;
            if(nums[mid] == x) return mid;
            else if(nums[mid]<x) start = mid+1;
            else end = mid-1;
        }
        return start;
    }
    public static int searchInsertPositionBrute(int[]nums, int x){
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>=x) return i;
        }
        return n;
    }
}
