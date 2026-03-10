import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2Problem {

    public static void main(String[] args){
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = majorityElementTwoOptimal(arr);

        System.out.print("The majority elements are: ");
        for (int it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
    public static List<Integer> majorityElementTwoOptimal(int[] nums){
        int cnt1=0,cnt2=0;
        int n = nums.length;
        int elem1 = Integer.MIN_VALUE,elem2 = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(cnt1 == 0 && elem2 != nums[i]){
                cnt1 = 1;
                elem1 = nums[i];
            }else if(cnt2 == 0 && elem1 != nums[i]){
                cnt2 = 1;
                elem2 = nums[i];
            }else if(elem1 == nums[i]){
                cnt1++;
            }else if(elem2 == nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;

        for(int i=0;i<n;i++){
            if(nums[i] == elem1){
                cnt1++;
            }else if(nums[i] == elem2){
                cnt2++;
            }
        }
        if(cnt1 > n/3){
            result.add(elem1);
        }
        if(cnt2 > n/3){
            result.add(elem2);
        }
        return result;
    }
    public static List<Integer> majorityElementTwoBetter(int[] nums){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            if(mp.get(nums[i])>n/3 && !result.contains(nums[i])){
                result.add(nums[i]);
            }
        }

        return result;
    }
    public static List<Integer> majorityElementTwoBrute(int[] nums){
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(result.size() == 0 || result.get(0)!= nums[i] && (result.size() < 2 || result.get(1) != nums[i])){
                int count = 0;
                for(int j=0;j<n;j++){
                    if(nums[i] == nums[j])
                        count++;
                }
                if(count > n/3){
                    result.add(nums[i]);
                }
            }
            if(result.size() == 2){
                break;
            }
        }
        return result;
    }
}
