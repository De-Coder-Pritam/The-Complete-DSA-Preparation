import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class UnionAndIntersectionProblems {

    public static void main(String... args){
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {3,4,5,6,7};
        int[] union = unionArrayOptimal(arr1,arr2);
//        ArrayOperations.printArray(union,union.length);
//        intersectionArrayBrute(arr1,arr2).forEach((i)-> System.out.print(i+ " "));
        intersectionArrayOptimal(arr1,arr2).forEach((i)->System.out.print(i+" "));

    }
    public static ArrayList<Integer> intersectionArrayOptimal(int[] arr1, int[] arr2){
        int i=0;
        int j=0;
        ArrayList<Integer> arList = new ArrayList<>();
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                i++;
            }else if(arr1[i]>arr2[j]){
                j++;
            }else{
                arList.add(arr1[i]);
                i++;
                j++;
            }
        }
        return arList;
    }
    public static ArrayList<Integer> intersectionArrayBrute(int[] arr1, int[] arr2){
        int[] visited = new int[arr2.length];
        ArrayList<Integer> arList = new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            int j=0;
            while(j < arr2.length && arr2[j]<=arr1[i]){
                if(arr1[i] == arr2[j] && visited[j] == 0){
                    arList.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }
                j++;
            }
        }
        return arList;
    }
    public static int[] unionArrayBrute(int[] arr1, int[] arr2){
        TreeSet<Integer> st = new TreeSet<>();
        for(int val: arr1){
            st.add(val);
        }
        for(int val: arr2){
            st.add(val);
        }
        int[] arReturn = new int[st.size()];
        int index=0;
        for(int val : st){
            arReturn[index]=val;
            index++;
        }
        return arReturn;
    }

    public static int[] unionArrayOptimal(int[] arr1, int[] arr2){

        int i=0;
        int j=0;
        ArrayList<Integer> lst = new ArrayList<>();
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j] ){
                if(lst.size() == 0 || lst.get(lst.size()-1) != arr1[i]){
                    lst.add(arr1[i]);
                }
                i++;
            }else if(arr1[i]>arr2[j]){
                if(lst.size() == 0 || lst.get(lst.size()-1)!=arr2[j]){
                    lst.add(arr2[j]);
                }
                j++;
            }else{
                if (lst.size() == 0 || lst.get(lst.size() - 1) != arr1[i]) {
                    lst.add(arr1[i]);
                }
                i++;
                j++;
            }

        }
        while(i<arr1.length){
            if(lst.size() == 0 || lst.get(lst.size()-1) != arr1[i]){
                lst.add(arr1[i]);
            }
            i++;
        }
        while(j<arr2.length){
            if(lst.size() == 0 || lst.get(lst.size()-1)!=arr2[j]){
                lst.add(arr2[j]);
            }
            j++;
        }
        int ind=0;
        int []arr = new int[lst.size()];
        for(Integer val: lst){
            arr[ind] = val;
            ind++;
        }

        return arr;
    }
    public static int[] unionArrayBruteMap(int[] arr1, int[] arr2){
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int val:arr1){
            mp.put(val,mp.getOrDefault(val,0)+1);
        }
        for(int val:arr2){
            mp.put(val,mp.getOrDefault(val,0)+1);
        }
        int[] retArr = new int[mp.size()];
        int index=0;
        for(Integer val: mp.keySet()){
            retArr[index]=val;
            index++;
        }
        return retArr;
    }
}
