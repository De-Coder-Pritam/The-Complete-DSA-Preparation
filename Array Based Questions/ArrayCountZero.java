public class ArrayCountZero {
    public static void main(String[] args){
        int[] arr = {1,1,1,1,1,1,1,0,0,0};
        System.out.println(countZerosBrute(arr));
        countZerosOptimal(arr);
    }
    public static int countZerosOptimal(int[] arr){
        int start = 0;
        int end=arr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid == 0){
                end=mid;
            }else{
                start=mid;
            }
        }

        return start;
    }
    public static int countZerosBrute(int[] arr){
         int count=0;
         for(int i=0;i<arr.length;i++){
             if(arr[i] == 0)
             count++;
         }
         return count;
    }
}
