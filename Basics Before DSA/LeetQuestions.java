public class LeetQuestions {

    public static void main(String... args){
//        Example 1:
//
//        Input: arr = [0,1,0]
//
//        Output: 1
//
//        Example 2:
//
//        Input: arr = [0,2,1,0]
//
//        Output: 1
//
//        Example 3:
//
//        Input: arr = [0,10,5,2]
//
//        Output: 1
        int[] arr = {0,1,0};
        int[] arr2 = {0,2,1,0};
        int[] arr3 = {0,10,5,2};
        System.out.println(peakIndexInMountainArray(arr));
        System.out.println(peakIndexInMountainArray(arr2));
        System.out.println(peakIndexInMountainArray(arr3));
    }
    public static int peakIndexInMountain(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int mid=(left+right)/2;
        if(arr[mid]>arr[mid-1]){

        }
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int index=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return i;
            }
        }
        return arr.length-1;
    }
}
