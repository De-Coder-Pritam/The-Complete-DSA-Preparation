import java.util.*;
import java.util.Map.*;
public class HashingEx {
    public static void main(String ... args){
        int[] arr = {2, 4, 3, 2, 5, 4};
//        System.out.println(countFrequenciesAlternate(arr));
        System.out.println(mostFrequentElement(arr));
        System.out.println(mostFrequentElementAlternate(arr));

    }
    public static int mostFrequentElementAlternate(int[] nums){
        Map<Integer,Integer> frequencies = new HashMap<>();
        for(int i:nums){
            frequencies.put(i,frequencies.getOrDefault(i,0)+1);
        }
        int maxKey = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(Entry<Integer,Integer> entry: frequencies.entrySet()){
            if(maxValue<entry.getValue()){
                maxKey = entry.getKey();
                maxValue=entry.getValue();
            }
        }
        return  maxKey;
    }
    public static int mostFrequentElement(int[] nums) {
        int[] arr = new int[10];
        for(int i:nums){
            arr[i]++;
        }
        int maxIndex = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[maxIndex]<arr[i])
                maxIndex=i;

        }
        return maxIndex;

    }
    public static List<List<Integer>> countFrequenciesAlternate(int[] arr){
        Map<Integer,Integer> frequencies = new HashMap<>();
        for(int a:arr){
            frequencies.put(a,frequencies.getOrDefault(a,0)+1);
        }
        List<List<Integer>> arListOuter = new ArrayList<>();
        for(Map.Entry<Integer,Integer> ent: frequencies.entrySet()){
            List<Integer> arList = new ArrayList<>();
            arList.add(ent.getKey());
            arList.add(ent.getValue());
            arListOuter.add(arList);
        }
        return arListOuter;
    }
    public static List<List<Integer>> countFrequencies(int[] arr){
        int[] arr2 = new int[10];
        for(int a: arr){
            arr2[a]++;
        }
        List<List<Integer>> arlistOuter = new ArrayList<>();
        for(int i=0;i<arr2.length;i++){
            List<Integer> arlist = new ArrayList<>();
            if(arr2[i]>0){
                arlist.add(i);
                arlist.add(arr2[i]);
                arlistOuter.add(arlist);
            }
        }
        return arlistOuter;
    }
}
