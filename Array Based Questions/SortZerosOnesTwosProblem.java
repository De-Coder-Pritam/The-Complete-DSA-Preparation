import java.util.Arrays;
public class SortZerosOnesTwosProblem {
    public static void main(String[] args){
        int[] nums = {1, 0, 2, 1, 0};
        sortZerosOnesTwosOptimal(nums);
        ArrayOperations.printArray(nums,nums.length);
    }
    public static void sortZerosOnesTwosBrute(int[] arr){
        Arrays.sort(arr);
    }
    //------Dutch National Flag Algorithm----------
    public static void sortZerosOnesTwosOptimal(int[] arr){
        int low=0;
        int mid=0;
        int high=arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                int temp = arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                int temp = arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
            }
        }
    }
    public static void sortZerosOnesTwosBetter(int[] arr){
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                zeros++;
            }else if(arr[i] == 1){
                ones++;
            }else{
                twos++;
            }
        }
        int index=0;
        while(zeros-->0){
            arr[index++]=0;
        }while(ones-->0){
            arr[index++]=1;
        }while(twos-->0){
            arr[index++]=2;
        }
    }
}
