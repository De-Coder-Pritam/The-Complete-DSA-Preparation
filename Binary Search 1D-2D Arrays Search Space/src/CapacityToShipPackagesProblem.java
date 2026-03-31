public class CapacityToShipPackagesProblem {
    /*
    You are given an array weights where weights[i] represents the weight of the i-th package on a
    conveyor belt. All the packages must be shipped in the order given from one port to another within days.

    Each day, the ship can carry a contiguous sequence of packages, as long as the total
    weight does not exceed its maximum capacity.

    Your task is to find the minimum possible capacity of the ship so that all packages
    can be shipped within the given number of days.
    Example 1
    Input: weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], days = 5
    Output: 15
    Explanation:
    Minimum ship capacity = 15. One way to ship in 5 days:
    Day 1: 1 + 2 + 3 + 4 + 5 = 15
    Day 2: 6 + 7 = 13
    Day 3: 8
    Day 4: 9
    Day 5: 10
    No day exceeds capacity 15 and all packages are shipped in order in 5 days.
    Example 2
    Input: weights = [3, 2, 2, 4, 1, 4], days = 3
    Output: 6
    Explanation:
    One possible division with capacity 6:
    Day 1: 3 + 2 = 5
    Day 2: 2 + 4 = 6
    Day 3: 1 + 4 = 5
    All packages shipped in order within 3 days.
     */
    public static void main(String[] args){
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days1 = 5;
        int[] weights2 = {3, 2, 2, 4, 1, 4};
        int days2 = 3;
        System.out.println(capacityToShipPackageBrute(weights1,days1));
        System.out.println(capacityToShipPackageBrute(weights2,days2));
        System.out.println(capacityToShipPackageOptimal(weights1,days1));
        System.out.println(capacityToShipPackageOptimal(weights2,days2));
    }
    public static int daysNeeded(int[] weights, int cap){
        int days =1, currLoad = 0;
        for(int w: weights){
            if(currLoad + w > cap){
                days++;
                currLoad = w;
            }else{
                currLoad += w;
            }
        }
        return days;
    }
    public static int capacityToShipPackageBrute(int[] nums, int days){
        int max = Integer.MIN_VALUE, sum=0,n=nums.length;
        for(int i=0;i<n;i++){
            if(max<nums[i])max = nums[i];
            sum += nums[i];
        }
        for(int i=max;i<=sum;i++){
            int actualDays = daysNeeded(nums,i);
            if(actualDays<=days){
                return i;
            }
        }
        return sum;
    }
    public static int capacityToShipPackageOptimal(int[] nums, int days){
        int left = Integer.MIN_VALUE, right=0,n=nums.length;
        for(int i=0;i<n;i++){
            if(left<nums[i])left = nums[i];
            right += nums[i];
        }
        while(left <= right){
            int mid = left +(right-left)/2;
            int needed = daysNeeded(nums,mid);
            if(needed <= days){
                right=mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

}
