import java.util.ArrayList;

public class RearrangeArrayElementsBySignProblem {
    public static int[]  rearrangeArrayExtended(int[] nums){
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                positives.add(nums[i]);
            }else{
                negatives.add(nums[i]);
            }
        }
        if(positives.size()>negatives.size()){

            for(int i=0;i<negatives.size();i++){
                nums[2*i] = positives.get(i);
                nums[2*i+1] = negatives.get(i);
            }
            int index = negatives.size()*2;
            for(int i=negatives.size();i<positives.size();i++){
                nums[index]=positives.get(i);
            }
        }else{
            for(int i=0;i<positives.size();i++){
                nums[i*2] = positives.get(i);
                nums[i*2+1]=negatives.get(i);
            }
            int index=positives.size()*2;
            for(int i=positives.size();i<negatives.size();i++){
                nums[index] = negatives.get(i);
            }
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums = {1, -1, -3, -4, 2, 3,6,8};

        ArrayOperations.printArray(rearrangeArrayExtended(nums),nums.length);
    }public static int[]  rearrangeArrayOptimal(int[] nums){
        int posIndex=0;
        int negIndex=1;
        int[] num = new int[nums.length];
        for(int i=0;i<nums.length;i++){

            if(nums[i]>=0){
                num[posIndex] = nums[i];
                posIndex+=2;
            }else{
                num[negIndex] = nums[i];
                negIndex+=2;
            }

        }
        return num;
    }
    public static void  rearrangeArrayBrute(int[] nums) {
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                positives.add(nums[i]);
            }else{
                negatives.add(nums[i]);
            }
        }
        int posIndex=0;
        int negIndex=1;
        for(Integer val: positives){
            nums[posIndex] = val;
            posIndex+=2;
        }
        for(Integer val: negatives){
            nums[negIndex] = val;
            negIndex+=2;
        }
    }
//    Rearrange array elements by sign

//    Given an integer array nums of even length consisting of an equal number
//    of positive and negative integers.Return the answer array in such a way
//    that the given conditions are met:
//
//    Every consecutive pair of integers have opposite signs.
//    For all integers with the same sign, the order in which they were present in nums is preserved.
//    The rearranged array begins with a positive integer.
//    Example 1
//    Input : nums = [2, 4, 5, -1, -3, -4]
//    Output : [2, -1, 4, -3, 5, -4]
//    Explanation:
//    The positive number 2, 4, 5 maintain their relative positions
//    and -1, -3, -4 maintain their relative positions
//
//    Example 2
//    Input : nums = [1, -1, -3, -4, 2, 3]
//    Output : [1, -1, 2, -3, 3, -4]
//    Explanation:The positive number 1, 2, 3 maintain their relative positions
//    and -1, -3, -4 maintain their relative positions
}
