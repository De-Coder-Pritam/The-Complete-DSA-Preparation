public class FirstAndLastOccurenceProblem {
    /*
    Given an array of integers nums sorted in non-decreasing order,
    find the starting and ending position of a given target value.
    If the target is not found in the array, return [-1, -1].
    Example 1
    Input: nums = [5, 7, 7, 8, 8, 10], target = 8
    Output: [3, 4]
    Explanation:The target is 8, and it appears in the array at indices 3 and 4,
    so the output is [3,4]
    Example 2
    Input: nums = [5, 7, 7, 8, 8, 10], target = 6
    Output: [-1, -1]
    Expalantion: The target is 6, which is not present in the array.
    Therefore, the output is [-1, -1].
     */
    public static void main(String[] args){
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target1 = 8,target2 = 6;
        for(int i: findFirstAndLastOccurenceBrute(nums,target1)){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i: findFirstAndLastOccurenceBrute(nums,target2)){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static int findLastOccurenceOptimal(int[] nums, int n){
        int low=0,high=nums.length-1,res=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == n){
                res = mid;
                low=mid+1;
            }else if(nums[mid]>n){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
    public static int findFirstOccurenceOptimal(int[] nums, int n){
        int low=0,high=nums.length-1,res=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == n){
                res = mid;
                high=mid-1;
            }else if(nums[mid]>n){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
    public static int[] findFirstAndLastOccurenceOptimal(int[] nums, int target) {
        int first = findFirstOccurenceOptimal(nums,target);
        int last = findLastOccurenceOptimal(nums,target);
        return new int[]{first,last};
    }
    public static int findFirstOccurenceBrute(int[] nums, int n){
        int sze=nums.length;
        for(int i=0;i<sze;i++){
            if(nums[i] == n) return i;
        }
        return -1;
    }
    public static int findLastOccurenceBrute(int[] nums, int n){
        int sze=nums.length-1;
        for(int i=sze;i>=0;i--){
            if(nums[i] == n) return i;
        }
        return -1;
    }
    public static int[] findFirstAndLastOccurenceBrute(int[] nums, int target) {
        int first = findFirstOccurenceBrute(nums,target);
        int last = findLastOccurenceBrute(nums,target);
        return new int[]{first,last};
    }
}
