public class KthElementOfTwoSortedArrayProblem {
    /*
    Given two sorted arrays a and b of size m and n respectively.
    Find the kth element of the final sorted array.
    Example 1
    Input: a = [2, 3, 6, 7, 9], b = [1, 4, 8, 10], k = 5
    Output: 6
    Explanation: The final sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10].
    The 5th element of this array is 6.
    Example 2
    Input: a = [100, 112, 256, 349, 770], b = [72, 86, 113, 119, 265, 445, 892], k = 7
    Output: 256
    Explanation: Final sorted array is - [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892],
    7th element of this array is 256.
     */
    public static void main(String[] args){
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        System.out.println(kthElementBrute(arr1,arr2,5));
        int[] arr3 = {100, 112, 256, 349, 770};
        int[] arr4 ={72, 86, 113, 119, 265, 445, 892};
        System.out.println(kthElementBrute(arr3,arr4,7));

    }
    public static int kthElementOptimal(int[] a, int[] b, int k){

    }
    public static int kthElementBrute(int[] a, int[] b, int k) {
        int i=0,j=0;
        int cnt=1;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                if(k == cnt) return a[i];
                i++;
                cnt++;
            }else{
                if(k == cnt) return b[j];
                j++;
                cnt++;
            }
        }
        while(i<a.length){
            if(k == cnt) return a[i];
            i++;
            cnt++;
        }
        while(j<b.length){
            if(k == cnt) return b[j];
            j++;
            cnt++;
        }
        return -1;
    }
}
