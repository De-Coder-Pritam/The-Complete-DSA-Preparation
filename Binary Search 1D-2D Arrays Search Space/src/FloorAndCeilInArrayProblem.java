public class FloorAndCeilInArrayProblem {
    /*
    Given a sorted array nums and an integer x. Find the floor and ceil of x in nums.
    The floor of x is the largest element in the array which is smaller than or equal to x.
    The ceiling of x is the smallest element in the array greater than or equal to x.
    If no floor or ceil exists, output -1.
    Example 1
    Input : nums =[3, 4, 4, 7, 8, 10], x= 5
    Output: 4 7
    Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.
    Example 2
    Input : nums =[3, 4, 4, 7, 8, 10], x= 8
    Output: 8 8
    Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.
     */
    public static void main(String[] args){
        int[] nums = {3, 4, 4, 7, 8, 10};
        int target1 = 5;
        int target2 = 8;
        for(int i: getFloorAndCeil(nums,target1)){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i: getFloorAndCeil(nums,target2)){
            System.out.print(i+" ");
        }
        System.out.println();

    }
    public static int getFloorValue(int[]nums, int x){
        int low = 0, high=nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<=x){
                ans = nums[mid];
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static int getCeilValue(int[]nums, int x){
        int low = 0, high=nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>=x){
                ans = nums[mid];
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int[] getFloorAndCeil(int[] nums, int x) {
        int floor = getFloorValue(nums,x);
        int ceil = getCeilValue(nums,x);
        return new int[]{floor,ceil};
    }
}
