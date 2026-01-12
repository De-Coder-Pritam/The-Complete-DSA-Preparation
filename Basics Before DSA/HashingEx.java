import java.util.*;
public class HashingEx {
    public static void main(String ... args){
        int[] arr = {1, 2, 2, 1, 3,534};
        System.out.println(countFrequenciesAlternate(arr));
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
