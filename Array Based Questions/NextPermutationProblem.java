public class NextPermutationProblem {
//    A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
//    For example, for arr = [1,2,3], the following are all the permutations of arr:
//    [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1].
//    The next permutation of an array of integers is the next lexicographically greater permutation of its integers.
//    More formally, if all the permutations of the array are sorted in lexicographical order,
//    then the next permutation of that array is the permutation that follows it in the sorted order.
//    If such arrangement is not possible (i.e., the array is the last permutation),
//    then rearrange it to the lowest possible order (i.e., sorted in ascending order).
//    You must rearrange the numbers in-place and use only constant extra memory.
//    Example 1
//    Input: nums = [1,2,3]
//    Output: [1,3,2]
//    Explanation:
//    The next permutation of [1,2,3] is [1,3,2].
//    Example 2
//    Input: nums = [3,2,1]
//    Output: [1,2,3]
//    Explanation:
//    [3,2,1] is the last permutation. So we return the first: [1,2,3].
    public static void main(String[] args){
        int[] arr = {1,2,3};
        nextPermutation(arr);
        for(int i: arr){
            System.out.print(i+" ");
        }

    }
    public static void nextPermutation(int[] arr){
        int index=-1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                index=i;
                break;
            }
        }
        if(index == -1){
            reverse(arr,0, arr.length-1);
            return;
        }
        for(int i=arr.length-1;i>index;i--){
            if(arr[i]>arr[index]){
                swap(arr,i,index);
                break;
            }
        }
        reverse(arr,index+1,arr.length-1);
    }
    public static void reverse(int[]arr, int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;start++;end--;
        }
    }
    public static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
