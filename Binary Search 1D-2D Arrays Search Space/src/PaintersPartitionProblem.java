public class PaintersPartitionProblem {
    /*
    You are given A painters and an array C of N integers where C[i] denotes the length
    of the ith board. Each painter takes B units of time to paint 1 unit of board.
    You must assign boards to painters such that:

    Each painter paints only contiguous segments of boards.
    No board can be split between painters.
    The goal is to minimize the time to paint all boards.


    Return the minimum time required to paint all boards modulo 10000003.
    Example 1
    Input: A = 2, B = 5, C = [1, 10]
    Output: 50
    Explanation:
    Painter 1 paints board 0 (length = 1), time = 5
    Painter 2 paints board 1 (length = 10), time = 50
    Max time = 50
    Return 50 % 10000003 = 50
    Example 2
    Input: A = 10, B = 1, C = [1, 8, 11, 3]
    Output: 11
    Explanation:
    Assign each board to a different painter
    Max time = max(1, 8, 11, 3) = 11
    Return 11 % 10000003 = 11
     */
    public static void main(String[] args){
        int[] nums = {1, 10};
        System.out.println(getPaintBrute(nums,2,5));
        System.out.println(getPaintOptimal(nums,2,5));
        int[] nums2 = {1, 8, 11, 3};
        System.out.println(getPaintBrute(nums2,10,1));
        System.out.println(getPaintOptimal(nums2,10,1));
    }
    public static int getRequiredPainters(int[]nums, int cap){
        int cnt = 1,last = nums[0];
        for(int num:nums){
            if((last+num)<=cap){
                last +=num;
            }else{
                cnt++;
                last=num;
            }
        }
        return cnt;
    }
    public static int getPaintOptimal(int[]nums, int painters, int unit){
        int low=0,high=0;
        for(int num:nums){
            low = Math.max(num,low);
            high+=num;
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            if(getRequiredPainters(nums,mid)<= painters){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low*unit;
    }
    public static int getPaintBrute(int[] nums, int painters, int unit){
        int low=0;
        int high=0;
        for(int num:nums){
            low = Math.max(low,num);
            high += num;
        }

        for(int i=low;i<=high;i++){
            if(getRequiredPainters(nums,i) <= painters){
                return i*unit;
            }
        }
        return -1;
    }
}
