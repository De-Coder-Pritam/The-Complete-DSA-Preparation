public class SearchXinSortedArrayProblem {
    /*
    Given a sorted array of integers nums with 0-based indexing,
    find the index of a specified target integer.
    If the target is found in the array, return its index.
    If the target is not found, return -1.
    Example 1
    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: The target integer 9 exists in nums and its index is 4
    Example 2
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: The target integer 2 does not exist in nums so return -1
     */
    public static void main(String[] args){
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int target2 = 2;
        System.out.println(binarySearchRecursive(nums,0,nums.length-1,target));
        System.out.println(binarySearchRecursive(nums,0,nums.length-1,target2));
    }
    public static int binarySearchRecursive(int[] nums, int start, int end, int target){
        if(start>end) return -1;
        int mid = start + (end-start)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid]<target) start = mid+1;
        else end = mid-1;
        return binarySearchRecursive(nums,start,end,target);
    }
    public static int binarySearchIterative(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid]<target) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }

}
