import java.util.Arrays;
import java.util.HashSet;

public class LongestConsequetiveSequenceArrayProblem {
    /*
    Given an array nums of n integers.
    Return the length of the longest sequence of consecutive integers.
    The integers in this sequence can appear in any order.
    Example 1
    Input: nums = [100, 4, 200, 1, 3, 2]
    Output: 4
    Explanation:
    The longest sequence of consecutive elements in the array is [1, 2, 3, 4],
    which has a length of 4. This sequence can be formed regardless of the
    initial order of the elements in the array.
    Example 2
    Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
    Output: 9
    Explanation:
    The longest sequence of consecutive elements in the array is [0, 1, 2, 3, 4, 5, 6, 7, 8],
    which has a length of 9.
     */
    public static int longestConsequetiveSequenceBetter(int[] arr){
        int longest=0;
        Arrays.sort(arr);
        int start=0;
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(cnt==0){
                start=arr[i];
                cnt++;
            }else if(arr[i] == start+1){
                cnt++;
                start++;
            }else if(arr[i] == start){
                continue;
            }else{
                cnt=1;
                start=arr[i];
            }
            longest = Math.max(longest,cnt);
        }
        return longest;
    }
    public static int longestConsequetiveSequenceOptimal(int[] arr){
        HashSet<Integer> st = new HashSet<>();
        for(int val: arr){
            st.add(val);
        }
        int longest=0;
        for(int i=0;i<arr.length;i++){
            if(!st.contains(arr[i]-1)){
                int start=arr[i];
                int count=0;
                while(st.contains(start)){
                    start++;
                    count++;
                }
                longest = Math.max(count,longest);
            }
        }
        return longest;
    }
    public static int longestConsequetiveSequenceBrute(int[] arr){
        int longest=0;
        for(int i=0;i<arr.length;i++){
            int cnt=0;
            int start=arr[i];
            while(linearSearch(arr,start++)==true){
                cnt++;
            }
            longest = Math.max(cnt,longest);
        }
        return longest;
    }
    public static void main(String[] args){
        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsequetiveSequenceBetter(arr));
    }
    public static boolean linearSearch(int []nums, int target){
        for(int val: nums){
            if(val == target){
                return true;
            }
        }
        return false;
    }
}
