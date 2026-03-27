public class FindNumberOfTimesArrayIsRotatedProblem {
    /*
    Given an integer array nums of size n, sorted in ascending order with distinct values.
    The array has been right rotated an unknown number of times, between 0 and n-1 (including).
    Determine the number of rotations performed on the array.
    Example 1
    Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
    Output: 4
    Explanation: The original array should be [0, 1, 2, 3, 4, 5, 6, 7].
    So, we can notice that the array has been rotated 4 times.
    Example 2
    Input: nums = [3, 4, 5, 1, 2]
    Output: 3
    Explanation: The original array should be [1, 2, 3, 4, 5].
    So, we can notice that the array has been rotated 3 times.
     */
    public static void main(String[] args){
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2, 3};
        int[] nums2 = {3, 4, 5, 1, 2};
        System.out.println(findKRotationBrute(nums1));
        System.out.println(findKRotationBrute(nums2));
        System.out.println(findKRotationBetter(nums1));
        System.out.println(findKRotationBetter(nums2));
        System.out.println(findKRotationOptimal(nums1));
        System.out.println(findKRotationOptimal(nums2));

    }
    public static int findKRotationOptimal(int[] nums){
        int low=0,high=nums.length-1,min=Integer.MAX_VALUE,index=0;
        while(low<=high){
            if(nums[low]<nums[high]){
                if(min>nums[low]){
                    return low;
                }
            }
            int mid = low+(high-low)/2;
            if(nums[low]<=nums[mid]){
                if(min>nums[low]){
                    min = nums[low];
                    index = low;

                }
                low = mid+1;
            }else{
                if(min>nums[mid]){
                    min = nums[mid];
                    index = mid;

                }
                high = mid-1;
            }
        }
        return index;
    }
    public static int findKRotationBrute(int[] nums) {
        int smallest = nums[0], index=0,n=nums.length;
        for(int i=1;i<n;i++){
            if(smallest>nums[i]){
                smallest = nums[i];
                index = i;
            }
        }
        return index;
    }
    public static int findKRotationBetter(int[] nums){
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]) return i;
        }
        return 0;
    }
}
