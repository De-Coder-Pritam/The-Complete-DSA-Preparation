public class SingleElementInSortedArrayProblem {
    /*
    Given an array nums sorted in non-decreasing order. Every number in
    the array except one appears twice. Find the single number in the array.
    Example 1
    Input :nums = [1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6]
    Output:4
    Explanation: Only the number 4 appears once in the array.
    Example 2
    Input : nums = [1, 1, 3, 5, 5]
    Output:3
    Explanation: Only the number 3 appears once in the array.
     */
    public static void main(String[] args){
        int[] nums1 = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        int[] nums2 = {1, 1, 3, 5, 5};
        System.out.println(singleNonDuplicateBruteOne(nums1));
        System.out.println(singleNonDuplicateBruteOne(nums2));
        System.out.println(singleNonDuplicateBruteTwo(nums1));
        System.out.println(singleNonDuplicateBruteTwo(nums2));
        System.out.println(singleNonDuplicateOptimal(nums1));
        System.out.println(singleNonDuplicateOptimal(nums2));
    }
    public static int singleNonDuplicateOptimal(int[] nums){
        int n=nums.length;
        if(n==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        int low=0,high = n-2;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }else if((mid %2 == 1 &&  nums[mid]==nums[mid-1] ) || (mid%2==0 && nums[mid]==nums[mid+1])){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    public static int singleNonDuplicateBruteTwo(int[] nums){
        int xor = 0,n = nums.length;
        for(int i=0;i<n;i++){
            xor ^= nums[i];
        }
        return xor;
    }
    public static int singleNonDuplicateBruteOne(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        for(int i=0;i<n;i++){
            if(i==0){
                if(nums[i]!= nums[i+1]){
                    return nums[i];
                }
            }
            else if(i == n-1){
                if(nums[i-1] != nums[i]){
                    return nums[i];
                }
            }
            else{
                if(nums[i-1] != nums[i] && nums[i] != nums[i+1]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
