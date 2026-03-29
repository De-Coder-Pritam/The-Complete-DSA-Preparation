public class KokoEatingBananasProblem {
    /*
    A monkey is given n piles of bananas, where the 'ith' pile has nums[i] bananas.
    An integer h represents the total time in hours to eat all the bananas.
    Each hour, the monkey chooses a non-empty pile of bananas and eats k bananas.
    If the pile contains fewer than k bananas, the monkey eats all the bananas
    in that pile and does not consume any more bananas in that hour.
    Determine the minimum number of bananas the monkey must eat per hour
    to finish all the bananas within h hours.
    Example 1
    Input: n = 4, nums = [7, 15, 6, 3], h = 8
    Output: 5
    Explanation: If Koko eats 5 bananas/hr, he will take 2, 3, 2, and 1 hour
    to eat the piles accordingly. So, he will take 8 hours to complete all the piles.
    Example 2
    Input: n = 5, nums = [25, 12, 8, 14, 19], h = 5
    Output: 25
    Explanation: If Koko eats 25 bananas/hr, he will take 1, 1, 1, 1, and 1 hour
    to eat the piles accordingly. So, he will take 5 hours to complete all the piles.
     */
    public static void main(String[] args){
        int[] nums1 = {7, 15, 6, 3};
        int[] nums2 = {25, 12, 8, 14, 19};
        System.out.println(minimumRateToEatBananasOptimal(nums1,8));
        System.out.println(minimumRateToEatBananasOptimal(nums2,5));
    }
    public static int calculateTotalHours(int[] nums, int i){
        int total = 0;
        for(int val:nums){
            total += (int)Math.ceil((double)val/i);
        }
        return total;
    }
    public static int minimumRateToEatBananasOptimal(int[] nums, int h){
        int max = nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]>max) max = nums[i];
        }
        int start = 1, end=max,ans=max;
        while(start<=end){
            int mid = start + (end-start)/2;
            int hours = calculateTotalHours(nums,mid);
            if(hours <= h){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    public static int minimumRateToEatBananasBrute(int[] nums, int h) {
        int max =nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(max<nums[i]) max = nums[i];
        }

        for(int i=1;i<=max;i++){
            int total = calculateTotalHours(nums,i);
            if(total<=h){
                return i;
            }
        }
        return max;
    }
}
