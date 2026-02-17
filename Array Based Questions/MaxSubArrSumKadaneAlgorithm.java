public class MaxSubArrSumKadaneAlgorithm {
//    Example 1:
//
//    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//    Output: 6
//    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//    Example 2:
//
//    Input: nums = [1]
//    Output: 1
//    Explanation: The subarray [1] has the largest sum 1.
//    Example 3:
//
//    Input: nums = [5,4,-1,7,8]
//    Output: 23
//    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArrayOptimalFollowUp(nums));
    }
    public static int maxSubArrayOptimalFollowUp(int[] nums){
        int sum = nums[0];
        int max=nums[0];
        int ansStart=0;
        int ansEnd=0;
        int tempStart=0;
        for(int i=1;i<nums.length;i++){

            if(sum <= 0){
                sum=0;
                tempStart=i;
            }sum+=nums[i];
            if(max<sum){
                max=sum;
                ansEnd=i;
                ansStart=tempStart;
            }
        }
        for(int i=ansStart;i<=ansEnd;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        return max;
    }
    public static int maxSubArrayOptimal(int[] nums){
        int sum = nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){

            if(sum <= 0){
                sum=0;
            }sum+=nums[i];
            if(max<sum){
                max=sum;
            }
        }
        return max;
    }
    public static int maxSubArrayBrute(int[] nums){
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum+=nums[k];
                }
                if(max<sum){
                    max=sum;
                }
            }
        }
        return max;
    }
    public static int maxSubArrayBetter(int[] nums) {
        int maxSum = nums[0];
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum>maxSum){
                    maxSum=sum;
                }
            }

        }
        return  maxSum;
    }
}
