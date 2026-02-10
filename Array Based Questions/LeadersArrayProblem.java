import java.util.ArrayList;

public class LeadersArrayProblem {
    public static void main(String... args){
        int[] arr = {16,17,4,3,5,2};
        ArrayList<Integer> arList = arrayLeaders(arr);
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
    public static ArrayList<Integer> arrayLeaders(int[] arr){
        ArrayList<Integer> arList = new ArrayList<>();
        int leader = -1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>leader){
                leader=arr[i];
                arList.add(0,leader);
            }
        }
        return arList;
    }
}
