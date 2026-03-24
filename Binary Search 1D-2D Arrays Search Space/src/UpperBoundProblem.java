public class UpperBoundProblem {
    /*
    Given a sorted array of nums and an integer x, write a program to find the upper bound of x.
    The upper bound of x is defined as the smallest index i such that nums[i] > x.
    If no such index is found, return the size of the array.
    Example 1
    Input : n= 4, nums = [1,2,2,3], x = 2
    Output:3
    Explanation:
    Index 3 is the smallest index such that arr[3] > x.
    Example 2
    Input : n = 5, nums = [3,5,8,15,19], x = 9
    Output: 3
    Explanation:
    Index 3 is the smallest index such that arr[3] > x.
     */
    public static void main(String[]args){
        int[] nums1 = {1,2,2,3};
        int[] nums2 = {3,5,8,15,19};
        int target1 = 2,target2 = 9;
        System.out.println(upperBoundOptimal(nums1,target1));
        System.out.println(upperBoundOptimal(nums2,target2));
    }
    public static int upperBoundBrute(int[] nums, int x){
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] > x) return i;
        }
        return n;
    }
    public static int upperBoundOptimal(int[] nums, int x){
        int start = 0,end = nums.length-1, ans = nums.length;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] > x){
                ans = mid;
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
}
