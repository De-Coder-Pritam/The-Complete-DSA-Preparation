public class FindMinimumInRotatedSortedArrayProblem {
    /*
    Given an integer array nums of size N, sorted in ascending order with distinct values, and then rotated an unknown number of times (between 1 and N), find the minimum element in the array.
    Example 1
    Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
    Output: 0
    Explanation: Here, the element 0 is the minimum element in the array.
    Example 2
    Input : nums = [3, 4, 5, 1, 2]
    Output: 1
    Explanation:Here, the element 1 is the minimum element in the array.
     */
    public static void main(String[] args){
        int[]nums1 = {4, 5, 6, 7, 0, 1, 2, 3};
        int[] nums2 = {3, 4, 5, 1, 2};
        System.out.println(findMinBrute(nums1));
        System.out.println(findMinBrute(nums2));
        System.out.println(findMinOptimal(nums1));
        System.out.println(findMinOptimal(nums2));

    }
    public static int findMinBrute(int[] arr) {
        int min = Integer.MAX_VALUE;
        int len = arr.length;
        for(int i=0;i<len;i++){
            if(min>arr[i]) min = arr[i];
        }
        return min;
    }
    public static int findMinOptimal(int[] arr){
        int low =0,high = arr.length-1,min=Integer.MAX_VALUE;
        while(low<=high){
            if(arr[low]<arr[high]){
                return arr[low];
            }
            int mid = low+(high-low)/2;
            if(arr[low]<=arr[mid]){
                min = Math.min(arr[low],min);
                low = mid+1;
            }else{
                min = Math.min(arr[mid],min);
                high = mid-1;
            }
        }
        return min;
    }
}
