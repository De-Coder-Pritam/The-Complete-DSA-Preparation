public class FindTheSmallestDivisorProblem {
    /*
    Given an array of integers nums and an integer limit as the threshold value,
    find the smallest positive integer divisor such that upon dividing all the
    elements of the array by this divisor, the sum of the division results
    is less than or equal to the threshold value.

    After dividing each element by the chosen divisor, take the ceiling
    of the result (i.e., round up to the next whole number).
    Example 1
    Input: nums = [1, 2, 3, 4, 5], limit = 8
    Output: 3
    Explanation: We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor.
    The sum is 9(1 + 1 + 2 + 2 + 3) if we choose 2 as a divisor.
    Upon dividing all the elements of the array by 3, we get 1,1,1,2,2 respectively.
    Now, their sum is equal to 7 <= 8 i.e. the threshold value. So, 3 is the minimum possible answer.
    Example 2
    Input: nums = [8,4,2,3], limit = 10
    Output: 2
    Explanation: If we choose 1, we get 17 as the sum. If we choose 2,
    we get 9 (4+2+1+2) <= 10 as the answer. So, 2 is the answer.
     */
    public static void main(String[] args){
        int []nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {8,4,2,3};
//        System.out.println(findSmallestDivisorBrute(nums1,8));
//        System.out.println(findSmallestDivisorBrute(nums2,10));
        System.out.println(findSmallestDivisorOptimal(nums1,8));
        System.out.println(findSmallestDivisorOptimal(nums2,10));

    }
    public static int findSmallestDivisorOptimal(int[]nums, int threshold){
        int n=nums.length;
        if(n>threshold) return -1;
        int max = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>max) max = nums[i];
        }
        int low=1,high=max;
        while(low<=high){
            int mid = low+(high-low)/2;
            int digSum = 0;
            for(int j=0;j<n;j++){
                int div = (int)Math.ceil((double)nums[j]/mid);
                digSum += div;
            }
            if(digSum<=threshold){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return low;
    }
    public static int findSmallestDivisorBrute(int[] nums, int threshold){
        int n=nums.length;
        if(n>threshold) return -1;
        int max = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>max) max = nums[i];
        }
        for(int i=1;i<max;i++){
            int digSum = 0;
            for(int j=0;j<n;j++){
                int div = (int)Math.ceil((double)nums[j]/i);
                digSum += div;
            }

            if(digSum <= threshold) return i;
        }
        return -1;
    }
}
