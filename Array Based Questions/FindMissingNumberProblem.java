public class FindMissingNumberProblem {
    public static void main(String... args){
        int[] nums = {0, 1, 2, 4, 5, 6};
        System.out.println("Difference is: "+missingNumberBrute(nums));
    }
    public static int missingNumberBrute(int[] arr){
        int arrSum = 0;
        int actualSum = 0;
        for(int i=0;i<arr.length;i++){
            arrSum += arr[i];
            actualSum += i+1;
        }
        return actualSum-arrSum;
    }
}
