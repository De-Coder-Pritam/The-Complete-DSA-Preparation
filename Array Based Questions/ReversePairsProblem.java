import java.util.ArrayList;

public class ReversePairsProblem {
    /*
    Given an integer array nums. Return the number of reverse pairs in the array.
    An index pair (i, j) is called a reverse pair if:
    0 <= i < j < nums.length
    nums[i] > 2 * nums[j]
    Example 1
    Input: nums = [6, 4, 1, 2, 7]
    Output: 3
    Explanation:
    The reverse pairs are:
    (0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1
    (0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2
    (1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1
    Example 2
    Input: nums = [5, 4, 4, 3, 3]
    Output: 0
    Explanation:
    No pairs satisfy both the conditons.
     */
    public static void main(String[] args){
        int[] nums = {6, 4, 1, 2, 7};
        int [] nums2 = {5, 4, 4, 3, 3};
        System.out.println(reversePairsOptimal(nums));
        System.out.println(reversePairsOptimal(nums2));
    }
    public static void merge(int[] arr, int start,int mid, int end){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = start;
        int right = mid+1;

        while(left <= mid && right <= end){
            if(arr[left] <= arr[right])temp.add(arr[left++]);
            else temp.add(arr[right++]);
        }
        while(left<=mid) temp.add(arr[left++]);
        while(right<=end) temp.add(arr[right++]);

        for(int val: temp){
            arr[start++] = val;
        }
    }
    public static int countPairs(int[] arr, int start, int mid, int end){
        int right = mid+1;
        int cnt = 0;
        for(int i=start;i<=mid;i++){
            while(right <= end && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid+1));
        }
        return cnt;
    }
    public static int mergeSort(int[] arr, int start, int end){
        int cnt = 0;
        if(start<end){
            int mid = (start+end)/2;
            cnt +=  mergeSort(arr,start,mid);
            cnt += mergeSort(arr,mid+1,end);
            cnt += countPairs(arr, start, mid, end);
            merge(arr,start,mid,end);
        }
        return cnt;
    }
    public static int reversePairsOptimal(int[] nums){
        return mergeSort(nums,0,nums.length-1);
    }
    public static int reversePairsBrute(int[] nums) {
        int n=nums.length,cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] > (2*nums[j])) cnt++;
            }
        }
        return cnt;
    }
}
