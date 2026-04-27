import java.util.GregorianCalendar;
import java.util.HashMap;

public class MaximumProductSubArrayProblem {
    /*
    Given an integer array nums. Find the subarray with the largest product,
    and return the product of the elements present in that subarray.
    A subarray is a contiguous non-empty sequence of elements within an array.
    Example 1
    Input: nums = [4, 5, 3, 7, 1, 2]
    Output: 840
    Explanation:
    The largest product is given by the whole array itself
    Example 2
    Input: nums = [-5, 0, -2]
    Output: 0
    Explanation:
    The largest product is achieved with the following subarrays [0], [-5, 0], [0, -2], [-5, 0, -2].
     */
    public static void main(String[] args){
        int[] nums = {4, 5, 3, 7, 1, 2};
        int[] nums2 = {-5, 0, -2};
        System.out.println(maxProductOptimalTwo(nums));
        System.out.println(maxProductOptimalTwo(nums2));
    }
    public static int maxProductOptimalTwo(int[] nums){
        int res = nums[0];
        int minProd = nums[0];
        int maxProd = nums[0];
        for(int i=1;i<nums.length;i++){
            int curr = nums[i];
            if(curr<0){
                int temp = minProd;
                minProd = maxProd;
                maxProd = temp;
            }
            maxProd = Math.max(curr,maxProd*curr);
            minProd = Math.min(curr,minProd*curr);
            res = Math.max(maxProd,res);
        }
        return res;
    }
    public static int maxProductOptimalOne(int[] nums){
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int pre = 1, suff = 1;
        for(int i=0;i<n;i++){
            if(pre == 0) pre = 1;
            if(suff == 0) suff = 1;
            pre *= nums[i];
            suff *= nums[n-i-1];
            ans = Math.max(ans,Math.max(pre,suff));
        }
        return ans;
    }
    public static int maxProductBetter(int[] nums){
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int prod = 1;
            for(int j=i;j<n;j++){
                prod *= nums[j];
                maxProduct = Math.max(prod,maxProduct);
            }
        }
        return maxProduct;
    }
    public static int maxProductBrute(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int prod = 1;
                for(int k=i;k<=j;k++){
                    prod *= nums[k];
                }
                if(prod>maxProduct){
                    maxProduct = prod;
                }
            }
        }
        return maxProduct;
    }
}
