import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElementProblem {
    public static int majorityElementBrute(int[] arr){
        int element=-1;
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count>arr.length/2){
                element = arr[i];
                break;
            }
        }
        return element;
    }
    public static int majorityElementBetter(int[] arr){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int element=-1;
        for(int i=0;i<arr.length;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        for(int elem: mp.keySet()){
            if(mp.get(elem)>arr.length/2){
                element = elem;
                break;
            }
        }
        return element;
    }public static int majorityElementOptimal(int[] arr){
        int freq=0;
        int candidate=0;
        for(int i=1;i<arr.length;i++){
            if(freq == 0){
                candidate=arr[i];
            }
            if(arr[i]==candidate){
                freq++;
            }else{
                freq--;
            }
        }
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]== candidate)
                cnt++;
        }
        if(cnt> arr.length/2){
            return candidate;
        }
        return -1;
    }
    /*
    Example 1:
    Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
    Output: 7
    Explanation:
     The number 7 appears 5 times in the 9-sized array, making it the most frequent element.

    Example 2:
    Input: nums = [1, 1, 1, 2, 1, 2]
    Output: 1
    Explanation:
     The number 1 appears 4 times in the 6-sized array, making it the most frequent element.
     */
    public static void main(String[] args){
        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        System.out.println(majorityElementOptimal(nums));
    }
}
