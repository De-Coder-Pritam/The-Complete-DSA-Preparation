public class MaximumConsequtiveOnesProblem {


//    Given a binary array nums, return the maximum number of consecutive 1s in the array.
//   A binary array is an array that contains only 0s and 1s.

//    Example 1
//    Input: nums = [1, 1, 0, 0, 1, 1, 1, 0]
//    Output: 3
//    Explanation:
//    The maximum consecutive 1s are present from index 4 to index 6, amounting to 3 1s

    public static void main(String[] args){
        int []nums = {1, 1, 0, 0, 1, 1, 1, 0};
        int []nums2 = {0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("Maximum consecutive 1s are "+findMaxConsecutiveOnes(nums));
        System.out.println("Maximum consecutive 1s are "+findMaxConsecutiveOnes(nums2));
    }
    public static int findMaxConsecutiveOnes(int[] arr){
        int max_count = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1)
                count++;
            else{
                if(max_count<count)
                    max_count=count;
                count=0;
            }
        }
        return max_count;
    }
}
