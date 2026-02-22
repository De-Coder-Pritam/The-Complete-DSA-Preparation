import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArrayProblem {
//    A leader in an array is an element whose value is strictly greater than all elements to its right in the given array.
//    The rightmost element is always a leader.
//    The elements in the leader array must appear in the order they appear in the nums array.
//    Example 1
//    Input: nums = [1, 2, 5, 3, 1, 2]
//    Output: [5, 3, 2]
//    Explanation:
//    2 is the rightmost element, 3 is the largest element in the index range [3, 5],
//    5 is the largest element in the index range [2, 5]
//
//    Example 2
//    Input: nums = [-3, 4, 5, 1, -4, -5]
//    Output: [5, 1, -4, -5]
//    Explanation:
//   -5 is the rightmost element, -4 is the largest element in the index range [4, 5],
//   1 is the largest element in the index range [3, 5] and 5 is the largest element in the range [2, 5]
    public static void main(String... args){
        int[] arr = {16,17,4,3,5,2};
        ArrayList<Integer> arList = arrayLeadersBrute(arr);
        for(Integer val: arList){
            System.out.print(val+" ");
        }
    }
    public static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void reverse(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static ArrayList<Integer> arrayLeadersBrute(int[] arr){
        ArrayList<Integer> arList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            boolean isLeader=true;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>=arr[i]){
                    isLeader=false;
                    break;
                }
            }
            if(isLeader){
                arList.add(arr[i]);
            }
        }
        return arList;
    }
    public static ArrayList<Integer> arrayLeadersOptimal(int[] arr){
        ArrayList<Integer> arList = new ArrayList<>();
        int leader = -1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>leader){
                leader=arr[i];
                arList.add(leader);
            }
        }
        Collections.reverse(arList);
        return arList;
    }
}
