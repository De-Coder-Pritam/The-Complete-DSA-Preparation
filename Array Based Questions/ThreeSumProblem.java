import java.util.*;

public class ThreeSumProblem {
//    Given an integer array nums. Return all triplets such that:
//    i != j, i != k, and j != k
//    nums[i] + nums[j] + nums[k] == 0.
//    Notice that the solution set must not contain duplicate triplets. One element can be a part of multiple triplets. The output and the triplets can be returned in any order.
//    Example 1
//    Input: nums = [2, -2, 0, 3, -3, 5]
//    Output: [[-2, 0, 2], [-3, -2, 5], [-3, 0, 3]]
//    Explanation:
//    nums[1] + nums[2] + nums[0] = 0
//    nums[4] + nums[1] + nums[5] = 0
//    nums[4] + nums[2] + nums[3] = 0
//    Example 2
//    Input: nums = [2, -1, -1, 3, -1]
//    Output: [[-1, -1, 2]]
//    Explanation:
//    nums[1] + nums[2] + nums[0] = 0
//    Note that we have used two -1s as they are separate elements with different indexes
//    But we have not used the -1 at index 4 as that would create a duplicate triplet
    public static void main(String []args){
        int[] nums = {2, -2, 0, 3, -3, 5};
        List<List<Integer>> res = threeSumOptimal(nums,nums.length);
        for(List<Integer> ans: res){
            for(int k: ans){
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSumOptimal(int[] arr, int n){
        Arrays.sort(arr);
        List<List<Integer>> sol = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && arr[i] == arr[i-1]){
                continue;
            }
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = arr[i]+arr[left]+arr[right];
                if(sum == 0){
                    sol.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--;
                    while(left<right && arr[left] == arr[left-1]) left++;
                    while(left<right && arr[right] == arr[right+1]) right--;
                }
                else if(sum<0) left++;
                else right--;
            }


        }
        return sol;

    }
    public static List<List<Integer>> threeSumBetter(int[] arr, int n){
        Set<List<Integer>> sol = new HashSet<>();
        for(int i=0;i<n;i++){
            HashSet<Integer> res = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third = -(arr[i]+arr[j]);
                if(res.contains(third)){
                    List<Integer> ans = Arrays.asList(arr[i],arr[j],third);
                    Collections.sort(ans);
                    sol.add(ans);
                }
                res.add(arr[j]);
            }

        }
        return new ArrayList<>(sol);
    }
    public static List<List<Integer>> threeSumBrute(int[] arr, int n){
        Set<List<Integer>> sol = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k] == 0){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(temp);
                        sol.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(sol);

    }

}
