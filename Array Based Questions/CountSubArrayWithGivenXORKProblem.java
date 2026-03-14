import java.util.HashMap;

public class CountSubArrayWithGivenXORKProblem {
//    Given an array of integers nums and an integer k,
//    return the total number of subarrays whose XOR equals to k.
//    Example 1
//    Input : nums = [4, 2, 2, 6, 4], k = 6
//    Output : 4
//    Explanation : The subarrays having XOR of their elements as 6 are
//    [4, 2],  [4, 2, 2, 6, 4], [2, 2, 6], and [6]
//    Example 2
//    Input :nums = [5, 6, 7, 8, 9], k = 5
//    Output : 2
//    Explanation : The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
    public static void main(String[] args){
        int[] nums = {5, 6, 7, 8, 9};
        int k = 5;
        System.out.println(subarraysWithXorKOptimal(nums,k));
    }
    public static int subarraysWithXorKOptimal(int[] nums, int k) {
        HashMap<Integer,Integer> prefix = new HashMap<>();
        int xor = 0;
        int count = 0;
        prefix.put(0,1);
        for(int i=0;i<nums.length;i++){
            xor ^= nums[i];
            int target = xor ^ k;
            if(prefix.containsKey(target)){
                count += prefix.get(target);
            }
            prefix.put(xor,prefix.getOrDefault(xor,0)+1);
        }
        return count;
    }
    public static int subarraysWithXorKBrute(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int xor = 0;
            for(int j=i;j<nums.length;j++){
                xor ^= nums[j];
                if(xor == k){
                    count++;
                }
            }
        }
        return count;
    }
}
