import java.util.HashMap;

public class LongestSubArraySumKProblem {
    public static void main(String[] args){
        int[]  nums = {10, 5, 2, 7, 1, 9};
        int target = 15;
        int[]  nums2 = {-3, 2, 1};
        int target2 = 15;
        System.out.println(longestSubArrayOptimal(nums,target));
        System.out.println(longestSubArrayBetter(nums2,target2));
    }

    //-------Only Applicable if the Array Contains only positive integers.---------
    public static int longestSubArrayOptimal(int[] arr, int target){
        int left=0;
        int right=0;
        int sum=arr[0];
        int max_len=0;
        while(right<arr.length){
            while(sum>target && left<=right){
                sum -= arr[left];
                left++;
            }
            if(sum == target){
                int len = right-left+1;
                if(max_len<len){
                    max_len=len;
                }
            }

            right++;

            if(right<arr.length)
                sum+=arr[right];

        }
        return max_len;
    }
    public static int longestSubArrayBetter(int[] arr, int target){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int sum=0;
        int max_length=0;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
            if(sum == target){
                if(max_length< i+1){
                    max_length=i+1;
                }
            }
            int rem = sum-target;
            if(mp.containsKey(rem)){
                int len = i-mp.get(rem);
                if(max_length<len){
                    max_length=len;
                }

            }
            if(!mp.containsKey(sum)){
                mp.put(sum,i);
            }

        }
        return max_length;
    }
    public static int longestSubArrayBrute2(int[] arr, int target){
        int max_len=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum == target){
                    int len = j-i+1;
                    if(max_len<len){
                        max_len=len;
                    }
                }
            }
        }
        return max_len;
    }
    public static int longestSubArrayBrute(int[] arr, int target){
        int max_len=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int len = 0;
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum += arr[k];

                }
                if(sum == target){
                    len=j-i+1;
                    if(max_len<len){
                        max_len=len;
                    }
                }
            }
        }
        return max_len;
    }
}
