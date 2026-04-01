public class BookAllocationProblem {
    /*
    Given an array nums of n integers, where nums[i] represents the number of pages in the i-th book,
    and an integer m representing the number of students, allocate all the books to the students
    so that each student gets at least one book, each book is allocated to only one student,
    and the allocation is contiguous.
    Allocate the books to m students in such a way that the maximum number of pages assigned
    to a student is minimized. If the allocation of books is not possible, return -1.
    Example 1
    Input: nums = [12, 34, 67, 90], m=2
    Output: 113
    Explanation: The allocation of books will be 12, 34, 67 | 90. One student will get the
    first 3 books and the other will get the last one.
    Example 2
    Input: nums = [25, 46, 28, 49, 24], m=4
    Output: 71

    Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24.
     */
    public static void main(String[] args){
        int []nums1 = {12, 34, 67, 90};
        int[] nums2 = {25, 46, 28, 49, 24};
        System.out.println(findPagesBrute(nums1,2));
        System.out.println(findPagesBrute(nums2,4));
        System.out.println(findPagesOptimal(nums1,2));
        System.out.println(findPagesOptimal(nums2,4));

    }
    public static int findPagesOptimal(int[]nums, int std){
        int low=0,high=0;
        if(std>nums.length) return -1;
        for(int num:nums){
            low = Math.max(num,low);
            high +=num;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(splitBooks(nums,mid) > std){

                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    public static int splitBooks(int[]nums, int pages){
        int std=1,last=nums[0];
        for(int i=1;i<nums.length;i++){
            if((last+nums[i])<=pages){
                last +=nums[i];
            }else{
                std++;
                last=nums[i];
            }
        }
        return std;
    }
    public static int findPagesBrute(int[]nums, int m){
        int n=nums.length;
        if(m>n) return -1;
        int low=0,high=0;
        for(int num:nums){
            low = Math.max(num,low);
            high +=num;
        }
        for(int i=low;i<=high;i++){
            if(splitBooks(nums,i) == m){
                return i;
            }
        }
        return -1;
    }
}
