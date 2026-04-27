public class CountInversionsProblem {
    /*
    Given an integer array nums. Return the number of inversions in the array.
    Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
    It indicates how close an array is to being sorted.
    A sorted array has an inversion count of 0.
    An array sorted in descending order has maximum inversion.
    Example 1
    Input: nums = [2, 3, 7, 1, 3, 5]
    Output: 5
    Explanation:
    The responsible indexes are:
    nums[0], nums[3], values: 2 > 1 & indexes: 0 < 3
    nums[1], nums[3], values: 3 > 1 & indexes: 1 < 3
    nums[2], nums[3], values: 7 > 1 & indexes: 2 < 3
    nums[2], nums[4], values: 7 > 3 & indexes: 2 < 4
    nums[2], nums[5], values: 7 > 5 & indexes: 2 < 5
    Example 2
    Input: nums = [-10, -5, 6, 11, 15, 17]
    Output: 0
    Explanation:
    nums is sorted, hence no inversions present.
     */
    public static void main(String[] args){
        int[] nums = {2, 3, 7, 1, 3, 5};
        int[] nums2 = {-10, -5, 6, 11, 15, 17};
        System.out.println(numberOfInversionsOptimal(nums));
    }
    public static int merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int left = start;
        int right = mid+1;
        int k = 0;
        int cnt = 0;
        while(left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                temp[k++]=arr[left++];
            }else{
                temp[k++] = arr[right++];
                cnt += (mid - left +1);
            }
        }
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements of right half
        while (right <= end) {
            temp[k++] = arr[right++];
        }

        // Copy back to original array
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }

        return cnt;
    }
    public static int mergeSort(int[] arr, int start, int end){
        int cnt = 0;
        if(start<end){
            int mid = (start+end)/2;
            cnt += mergeSort(arr,start,mid);
            cnt+= mergeSort(arr,mid+1,end);
            cnt += merge(arr,start,mid,end);
        }
        return cnt;
    }
    public static long numberOfInversionsOptimal(int[] nums){
        int cnt = mergeSort(nums,0,nums.length-1);
        return (long)cnt;
    }
    public static long numberOfInversionsBrute(int[] nums) {
        long cnt = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]) cnt++;
            }
        }
        return cnt;
    }
}
