import java.util.ArrayList;
import java.util.List;
public class FindAllPermutationsProblem {
    public static void recurPermute(int index, int []nums, List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> arr = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                arr.add(nums[i]);
            }
            ans.add(arr);
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recurPermute(index+1,nums,ans);
            swap(i,index,nums);
        }
    }
    public static void swap(int i,int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static List<List<Integer>> getAllPermutations(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0,nums,ans);
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> ans;
        ans = getAllPermutations(nums);
        for(List<Integer> arr: ans){
            for(Integer val: arr){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}
