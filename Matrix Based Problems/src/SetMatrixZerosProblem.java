public class SetMatrixZerosProblem {
    /*
    Set Matrix Zeroes
    Given an m x n integer matrix, if an element is 0,
    set its entire row and column to 0. You must do it in place.
    Example 1
    Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
    Output: [[1,0,1],[0,0,0],[1,0,1]]
    Explanation:
    Element at position (1,1) is 0, so set entire row 1 and column 1 to 0.
    Example 2
    Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    Explanation:
    There are two zeroes: (0,0) and (0,3).
    Row 0 → all elements become 0
    Column 0 and column 3 → all elements become 0
     */
    public static void main(String[] args){
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        MatrixOperations.printMatrix(matrix);
        setZeroesBrute(matrix);
        MatrixOperations.printMatrix(matrix);
    }

    public static void setZeroesBrute(int[][] matrix) {
        // Your code goes here
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    markRows(matrix,i);
                    markColumns(matrix,j);
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
    }
    public static void markRows(int[][] mat, int i){
        for(int j=0;j<mat[0].length;j++){
            mat[j][i]=-1;
        }
    }
    public static void markColumns(int[][] mat, int i){
        for(int j=0;j<mat.length;j++){
            mat[i][j]=-1;
        }
    }
}
