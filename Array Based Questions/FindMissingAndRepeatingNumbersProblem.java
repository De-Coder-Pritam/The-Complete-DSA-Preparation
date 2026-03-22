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
        ArrayOperations.printArray(findMissingRepeatingNumbersBrute(nums),2);
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
