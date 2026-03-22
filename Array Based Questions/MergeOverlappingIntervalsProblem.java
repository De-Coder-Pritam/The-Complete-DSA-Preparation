import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervalsProblem {

//    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.
//    You can return the intervals in any order.
//    Example 1
//    Input: intervals = [[1,5],[3,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Intervals [1,5] and [3,6] overlap, so they are merged into [1,6].
//    Example 2
//    Input: intervals = [[5,7],[1,3],[4,6],[8,10]]
//    Output: [[1,3],[4,7],[8,10]]
//    Explanation: Intervals [4,6] and [5,7] overlap and are merged into [4,7].

    public static void main(String[] args){
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        List<List<Integer>> ans = mergeOptimal(intervals);
        for(List<Integer> result : ans){
            for(Integer val: result){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> mergeOptimal(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        for(int[] interval: intervals){
            if(ans.isEmpty() || ans.get(ans.size()-1).get(1) < interval[0]){
                ans.add(Arrays.asList(interval[0],interval[1]));
            }else{
                int last = ans.size()-1;
                int max = Math.max(ans.get(last).get(1),interval[1]);
                ans.get(last).set(1,max);
            }
        }
        return ans;
    }
    public static List<List<Integer>> mergeBrute(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(intervals,
                (a,b)-> a[0] - b[0]
        );
        int n = intervals.length,i=0;
        while(i<n){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i+1;
            while(j<n && intervals[j][0] <= end){
                end = Math.max(end,intervals[j][1]);
                j++;
            }
            ans.add(Arrays.asList(start,end));
            i=j;

        }
        return ans;


    }
}
