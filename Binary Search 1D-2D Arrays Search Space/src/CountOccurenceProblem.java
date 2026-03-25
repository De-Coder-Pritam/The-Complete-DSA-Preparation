public class CountOccurenceProblem {
    /*
    You are given a sorted array of integers arr and an integer target.
    Your task is to determine how many times target appears in arr.
    Return the count of occurrences of target in the array.
    Example 1
    Input: arr = [0, 0, 1, 1, 1, 2, 3], target = 1
    Output: 3
    Explanation: The number 1 appears 3 times in the array.
    Example 2
    Input: arr = [5, 5, 5, 5, 5, 5], target = 5
    Output: 6
    Explanation: All elements in the array are 5, so the target appears 6 times.
     */
    public static void main(String[] args){
        int[] nums1 = {0, 0, 1, 1, 1, 2, 3};
        int[] nums2 = {5, 5, 5, 5, 5, 5};
        int target= 1,target2= 5;
        System.out.println(countOccurenceOptimal(nums1,target));
        System.out.println(countOccurenceOptimal(nums2,target2));

    }
    public static int countOccurenceOptimal(int[]nums, int n){
        int[] ans = FirstAndLastOccurenceProblem.findFirstAndLastOccurenceOptimal(nums,n);
        if(ans[0] == -1) return 0;
        return ans[1]-ans[0]+1;
    }
    public static int countOccurenceBrute(int[]nums, int n){
        int s=nums.length;
        int cnt=0;
        for(int i=0;i<s;i++){
            if(nums[i] == n) cnt++;
        }
        return cnt;
    }
}
