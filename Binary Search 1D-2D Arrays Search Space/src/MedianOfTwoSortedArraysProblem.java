import java.util.Arrays;

public class MedianOfTwoSortedArraysProblem {
    /*
    Given two sorted arrays arr1 and arr2 of size m and n respectively,
    return the median of the two sorted arrays.
    The median is defined as the middle value of a sorted list of numbers.
    In case the length of the list is even, the median is the average of the two middle elements.
    Example 1
    Input: arr1 = [2, 4, 6], arr2 = [1, 3, 5]
    Output: 3.5
    Explanation: The array after merging arr1 and arr2 will be [ 1, 2, 3, 4, 5, 6 ].
    As the length of the merged list is even, the median is the average of the two middle elements.
    Here two medians are 3 and 4. So the median will be the average of 3 and 4, which is 3.5.
    Example 2
    Input: arr1 = [2, 4, 6], arr2 = [1, 3]
    Output: 3.0
    Explanation: The array after merging arr1 and arr2 will be [ 1, 2, 3, 4, 6 ].
    The median is simply 3.
     */
    public static void main(String[] args){
        int[] arr1 = {2, 4, 6};
        int[] arr2 = {1, 3, 5};
        System.out.println(getMedianOptimal(arr1,arr2));
        int[] arr3 = {1,3};
        System.out.println(getMedianOptimal(arr1,arr3));

    }
    public static double getMedianOptimal(int[] arr1, int[] arr2){
        if(arr2.length<arr1.length) return getMedianOptimal(arr2,arr1);
        int n1=arr1.length,n2=arr2.length;
        int low=0,high=n1;
        while(low<=high){
            int cut1 = (low+high)/2;
            int cut2 = (n1+n2+1)/2 - cut1;
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2-1];
            int right1 = cut1 == n1 ? Integer.MAX_VALUE:arr1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE:arr2[cut2];

            if(left1 <= right2 && left2 <= right1){
                if((n1+n2)%2 == 0){
                    return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                }else
                    return Math.max(left1,left2);
            }
            else if(left1 > right2) high = cut1-1;
            else low = cut1+1;
        }
        return 0.0;
    }
    public static double getMedianBetter(int[] arr1, int[] arr2){
        int len = arr1.length+arr2.length;
        int i=0,j=0;
        int mid1 = (len-1)/2;
        int mid2 = len/2;
        int prev=0,curr=0;
        int k=0;
        while(i<arr1.length && j<arr2.length){
            prev = curr;
            if(arr1[i] <= arr2[j]) curr = arr1[i++];
            else curr = arr2[j++];
            if(k == mid2) break;
            k++;
        }
        if(k != mid2){
            while(i<arr1.length){
                prev = curr;
                curr = arr1[i++];
                if(k == mid2) break;
                k++;
            }
            while(j<arr2.length){
                prev = curr;
                curr = arr2[j++];
                if(k == mid2) break;
                k++;
            }
        }

        if(len%2 == 0){
            return (prev+curr)/2.0;
        }else{
            return curr;
        }
    }
    public static double getMedianBrute(int[] arr1, int[] arr2){
        int i=0,j=0;
        int[] arr3 = new int[arr1.length+arr2.length];
        int k=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                arr3[k++]=arr1[i++];
            }else{
                arr3[k++]=arr2[j++];
            }
        }
        while(i<arr1.length){
            arr3[k++]=arr1[i++];
        }
        while(j<arr2.length){
            arr3[k++]=arr2[j++];
        }

        int len = arr3.length;
        if(len%2 != 0) return arr3[len/2];
        else{
            double mid = (arr3[len/2] + arr3[len/2 -1])/2.0;
            return mid;
        }
    }
}
