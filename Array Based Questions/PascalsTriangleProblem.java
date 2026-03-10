import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleProblem {
    public static void main(String[] args){
        System.out.println("Hello World!");
    }
    public List<List<Long>> findPascalTriangle(int numRows){
        List<List<Long>> triangle = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Long> row = new ArrayList<>();
            for (int j=0;j<=i;j++){
                if(j == 0|| j== i){
                    row.add(1l);
                }else{
                    row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
    public List<Long> findPascalRow(int row){
        List<Long> elems = new ArrayList<>();
        long val = 1;
        elems.add(val);
        for(int i=1;i<row;i++){
            val = val * (row-i)/i;
            elems.add(val);
        }
        return elems;

    }
    public long findPascalElement(int row, int col){
        long res = 1;
        int r = row-1;
        int c = col-1;
        for(int i=0;i<c;i++){
            res *= (r-i);
            res /= (i+1);
        }
        return res;
    }

}
