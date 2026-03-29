public class MinimumDaysToMakeMBouqetsProblem {
    /*
    Given n roses and an array nums where nums[i] denotes that the 'ith' rose will
    bloom on the nums[i]th day, only adjacent bloomed roses can be picked to make a
    bouquet. Exactly k adjacent bloomed roses are required to make a single bouquet.
    Find the minimum number of days required to make at least m bouquets,
    each containing k roses. Return -1 if it is not possible.
    Example 1
    Input: n = 8, nums = [7, 7, 7, 7, 13, 11, 12, 7], m = 2, k = 3
    Output: 12
    Explanation: On the 12th the first 4 flowers and the last 3 flowers would have
    already bloomed. So, we can easily make 2 bouquets, one with the first 3 and
    another with the last 3 flowers.
    Example 2
    Input: n = 5, nums = [1, 10, 3, 10, 2], m = 3, k = 2
    Output: -1
    Explanation: If we want to make 3 bouquets of 2 flowers each,
    we need at least 6 flowers. But we are given only 5 flowers, so, we
    cannot make the bouquets.
     */
    public static void main(String[] args){
        int[] nums1 = {7, 7, 7, 7, 13, 11, 12, 7};
        System.out.println(roseGardenOptimal(8,nums1,3,2));
    }
    public static int roseGardenOptimal(int n,int[] nums, int k, int m){
        int min = nums[0],max=nums[0];
        if((long)(m*k) > n) return -1;
        for(int i=1;i<n;i++){
            if(min>nums[i]) min=nums[i];
            if(max<nums[i]) max=nums[i];
        }
        int result = -1;
        while(min<=max){
            int mid = min +(max-min)/2;
            int total = totalPossibleBouqets(nums,k,mid);
            if(total >= m){
                result = mid;
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return result;
    }
    public static int roseGardenBrute(int n, int[] nums, int k, int m) {
        int min = nums[0],max=nums[0];
        for(int i=1;i<n;i++){
            if(min>nums[i]) min=nums[i];
            if(max<nums[i]) max=nums[i];
        }

        for(int i=min;i<=max;i++){
            int total = totalPossibleBouqets(nums, k,i);
            if(total >=m) return i;
        }
        return -1;
    }
    public static int totalPossibleBouqets(int[]nums, int k, int day){
        int cnt=0,poss=0;
        for(int val:nums){
            if(val<=day){
                cnt++;
            }else{
                poss += cnt/k;

                cnt = 0;
            }
        }
        poss += cnt/k;
        return poss;
    }
}
