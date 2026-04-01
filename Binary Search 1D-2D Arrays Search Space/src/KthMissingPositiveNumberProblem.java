public class KthMissingPositiveNumberProblem {
    /*
    Given a sorted array of unique positive integers arr, your task is to return the kᵗʰ
    missing positive number that is not present in arr.

    The array is guaranteed to be strictly increasing, and the missing numbers are those
    positive integers that do not appear in arr but would appear in a full sequence starting from 1.
    Example 1
    Input: arr = [3, 5, 7, 10], k = 6
    Output: 9
    Explanation:
    The missing numbers are [1, 2, 4, 6, 8, 9, 11, ...]. The 6ᵗʰ missing number is 9.
    Example 2
    Input: arr = [1, 4, 6, 8, 9], k = 3
    Output: 5
    Explanation:
    The missing numbers are [2, 3, 5, 7, 10, ...]. The 3ʳᵈ missing number is 5.
     */
    public static void main(String[] args){
        int []nums = {3, 5, 7, 10};
        int []nums2 = {1, 4, 6, 8, 9};
        System.out.println(KthMissingPositiveNumberBrute(nums,6));
        System.out.println(KthMissingPositiveNumberBrute(nums2,3));
        System.out.println(KthMissingPositiveNumberOptimal(nums,6));
        System.out.println(KthMissingPositiveNumberOptimal(nums2,3));
    }
    public static int KthMissingPositiveNumberOptimal(int[]nums, int k){
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            int missing = nums[mid]-(mid+1);
            if(missing<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low+k;
    }
    public static int KthMissingPositiveNumberBrute(int[]nums, int k){
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }
}
