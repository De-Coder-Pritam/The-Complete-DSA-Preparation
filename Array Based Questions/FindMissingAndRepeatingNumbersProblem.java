public class FindMissingAndRepeatingNumbersProblem {

//    Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
//    Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.
//    Note: You are not allowed to modify the original array.
//    Example 1
//    Input: nums = [3, 5, 4, 1, 1]
//    Output: [1, 2]
//    Explanation:
//    1 appears two times in the array and 2 is missing from nums
//    Example 2
//    Input: nums = [1, 2, 3, 6, 7, 5, 7]
//    Output: [7, 4]
//    Explanation:
//    7 appears two times in the array and 4 is missing from nums.

    public static void main(String[] args){
        int[] nums = {3, 5, 4, 1, 1};
        ArrayOperations.printArray(findMissingRepeatingNumberOptimalTwo(nums),2);
    }
    public static int[] findMissingRepeatingNumberOptimalTwo(int[] nums){
        int n = nums.length;
        int xr = 0;
        for(int i=0;i<n;i++){
            xr ^= nums[i];
            xr ^= (i+1);
        }
        int number = (xr  & (xr-1));
        int zero = 0,one = 0;
        for(int i=0;i<n;i++){
            if((nums[i] & number)!= 0){
                one ^= nums[i];
            }else{
                zero ^= nums[i];
            }
        }
        for(int i=1;i<=n;i++){
            if((i & number) != 0){
                one ^= i;
            }else{
                zero ^= i;
            }
        }
        int cnt = 0;
        for(int val: nums){
            if(val == zero) cnt++;
        }
        if(cnt == 2){
            return new int[]{zero,one};
        }
        return new int[]{one, zero};
    }
    public static int[] findMissingRepeatingNumberOptimalOne(int[] nums){
        int n = nums.length;
        int sm = n * (n+1) / 2;
        int smsq = n * (n+1) * (2*n+1) / 6;
        int gsm = 0;
        int gsmsq = 0;
        for(int i=0;i<n;i++){
            gsm += nums[i];
            gsmsq += nums[i] * nums[i];
        }
        int val1 = sm - gsm;
        int val2 = smsq - gsmsq;
        val2 = val2 / val1;
        int missing = (val1+val2)/2;
        int repeating = val2-missing;
        return new int[]{repeating,missing};
    }
    public static int[] findMissingRepeatingNumberBetter(int[] nums){
        int[] hash = new int[nums.length+1];
        int missing = -1, repeating = -1;
        int[] ans = {missing, repeating};
        for(int i=0;i<nums.length;i++){
            hash[nums[i]]++;
        }
        for(int i=1;i<hash.length;i++){
            int cnt = hash[i];
            if(cnt == 0) missing = i;
            else if(cnt == 2) repeating = i;
            if(missing != -1 &&  repeating != -1) break;
        }
        ans[0] = repeating;
        ans[1] = missing;
        return ans;
    }
    public static int[] findMissingRepeatingNumbersBrute(int[] nums) {
        int n = nums.length;
        int repeating = -1, missing = -1;
        for(int i=1;i<=n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(nums[j] == i) cnt++;
            }
            if(cnt == 2) repeating = i;
            else if(cnt == 0) missing = i;
        }
        return new int[]{repeating,missing};
    }
}
