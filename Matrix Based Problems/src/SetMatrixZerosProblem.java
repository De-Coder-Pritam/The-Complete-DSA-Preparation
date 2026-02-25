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
        setZeroesOptimal(matrix);
        System.out.println("Matrix after Setting Zeros: ");
        MatrixOperations.printMatrix(matrix);
    }
    public static void setZeroesOptimal(int[][] matrix){
        boolean firstRowZero=false,firstColZero=false;
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[0][j] == 0 || matrix[i][0]==0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRowZero){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }
        if(firstColZero){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
    }
    public static void setZeroesBetter(int[][] matrix){
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows[i]=1;
                    cols[j]=1;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(rows[i]==1 || cols[j] == 1){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void setZeroesBrute(int[][] matrix) {
        // Your code goes here
        int count=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){

                if(matrix[i][j]==0){
                    markRows(matrix,i);
                    markColumns(matrix,j);
                    count++;
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
        for(int j=0;j<mat[i].length;j++){
            if(mat[i][j]!=0)
            mat[i][j]=-1;
        }
    }
    public static void markColumns(int[][] mat, int i){
        for(int j=0;j<mat.length;j++){
            if(mat[j][i] != 0)
            mat[j][i]=-1;
        }
    }
}
