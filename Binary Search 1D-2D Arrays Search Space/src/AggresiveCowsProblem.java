import java.util.Arrays;

public class AggresiveCowsProblem {
    /*
    Given an array nums of size n, which denotes the positions of stalls, and an integer k,
    which denotes the number of aggressive cows, assign stalls to k cows such that the
    minimum distance between any two cows is the maximum possible.
    Find the maximum possible minimum distance.
    Example 1
    Input: n = 6, k = 4, nums = [0, 3, 4, 7, 10, 9]
    Output: 3
    Explanation:
    The maximum possible minimum distance between any two cows will be 3 when 4 cows are
    placed at positions [0, 3, 7, 10]. Here the distances between cows are 3, 4, and 3 respectively.
    In no manner can we increase the minimum distance beyond 3.
    Example 2
    Input : n = 5, k = 2, nums = [4, 2, 1, 3, 6]
    Output: 5
    Explanation: The maximum possible minimum distance between any two cows will
    be 5 when 2 cows are placed at positions [1, 6].
     */
    public static void main(String[] args){
        int[] stalls1 = {0, 3, 4, 7, 10, 9};
        int[] stalls2 = {4, 2, 1, 3, 6};
        System.out.println(aggresiveCowsBrute(stalls1,4));
        System.out.println(aggresiveCowsBrute(stalls2,2));
        System.out.println(aggresiveCowsOptimal(stalls1,4));
        System.out.println(aggresiveCowsOptimal(stalls2,2));

    }
    public static int aggresiveCowsOptimal(int[] nums, int k){
        Arrays.sort(nums);
        int low=1;
        int high=nums[nums.length-1]-nums[0];
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canPlace(nums,mid,k)){
                low=mid+1;
                ans=mid;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static boolean canPlace(int[] nums, int d, int k){
        int currCow = 1, lastPlace = nums[0];
        for(int i=1;i<nums.length;i++){
            if((nums[i]-lastPlace) >= d){
                currCow++;
                lastPlace = nums[i];
            }
            if(currCow>=k){
                return true;
            }
        }
        return false;
    }
    public static int aggresiveCowsBrute(int[] nums, int k){
        Arrays.sort(nums);
        int maxDist = nums[nums.length-1] - nums[0],ans=0;
        for(int i=1;i<=maxDist;i++){
            if(canPlace(nums,i,k)){
                ans = i;
            }
        }
        return ans;
    }
}
