import java.util.*;

public class FourSumProblem {
//    Given an integer array nums and an integer target. Return all quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//    a, b, c, d are all distinct valid indices of nums.
//    nums[a] + nums[b] + nums[c] + nums[d] == target.
//    Notice that the solution set must not contain duplicate quadruplets. One element can be a part of multiple quadruplets. The output and the quadruplets can be returned in any order.
//    Example 1
//    Input: nums = [1, -2, 3, 5, 7, 9], target = 7
//    Output: [[-2, 1, 3, 5]]
//    Explanation:
//    nums[1] + nums[0] + nums[2] + nums[3] = 7
//    Example 2
//    Input: nums = [7, -7, 1, 2, 14, 3], target = 9
//    Output: []
//    Explanation:
//    No quadruplets are present which add upto 9
    public static void main(String[] args){
        int[] nums = {1, -2, 3, 5, 7, 9};
        int target = 7;
        List<List<Integer>> sol = fourSumOptimal(nums,target);
        for(List<Integer> ans: sol){
            for(int val: ans){
                System.out.print(val+" ");
            }
            System.out.println();
        }

    }
    public static List<List<Integer>> fourSumOptimal(int[] arr, int target){
        int n = arr.length;
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && arr[j] == arr[j-1]) continue;
                int left = j+1;
                int right = n-1;
                while(left<right){
                    long sum = (long)arr[i] + arr[j] + arr[left] + arr[right];
                    if(sum == target){
                        sol.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                        left++;
                        right--;
                        while(left<right && arr[left] == arr[left-1]) left++;
                        while(left<right && arr[right] == arr[right+1]) right--;
                    }else if(sum<target) left++;
                    else right--;
                }
            }
        }
        return sol;
    }
    public static List<List<Integer>> fourSumBetter(int[] arr, int target){
        int n = arr.length;
        Set<List<Integer>> sol = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                HashSet<Integer> seen = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long req = (long) target - arr[i] - arr[j] - arr[k];
                    if(seen.contains((int) req)){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],(int)req);
                        Collections.sort(temp);
                        sol.add(temp);
                    }
                    seen.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(sol);
    }
    public static List<List<Integer>> fourSumBrute(int[] arr, int target) {
        Set<List<Integer>> sol = new HashSet<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        long sum = (long) arr[i]+arr[j]+arr[k]+arr[l];
                        if( sum == target){
                            List<Integer> ans = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            Collections.sort(ans);
                            sol.add(ans);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(sol);
    }
}
