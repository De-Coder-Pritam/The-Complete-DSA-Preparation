public class LowerBoundProblem {
    /*
    Given a sorted array of nums and an integer x, write a program to find the lower bound of x.
    The lower bound algorithm finds the first and smallest index in a sorted array
    where the value at that index is greater than or equal to a given key i.e. x.
    If no such index is found, return the size of the array.
    Example 1
    Input : nums= [1,2,2,3], x = 2
    Output:1
    Explanation:
    Index 1 is the smallest index such that arr[1] >= x.
    Example 2
    Input : nums= [3,5,8,15,19], x = 9
    Output: 3
    Explanation:
    Index 3 is the smallest index such that arr[3] >= x.
     */
    public static void main(String[] args){
        int[] nums = {1,2,2,3};
        int[] nums2 = {3,5,8,15,19};
        int target1 = 2;
        int target2 = 9;
        System.out.println(lowerBoundOptimal(nums,target1));
        System.out.println(lowerBoundOptimal(nums2,target2));
    }
    public static int lowerBoundBrute(int[] arr, int x) {
        int a = arr.length;
        for(int i=0;i<a;i++){
            if(arr[i]>=x)
                return i;
        }
        return a;
    }
    public static int lowerBoundOptimal(int[] arr, int x){
        int start = 0,end = arr.length-1;
        int ans = arr.length;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]>=x) {
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}
