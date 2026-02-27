public class RotateMatrixBy90DegreeProblem {
    public static void main(String[] args){
        System.out.println("Hello World!");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        MatrixOperations.printMatrix(matrix);
        MatrixOperations.printMatrix(rotateMatrixBy90Brute(matrix));
        rotateMatrixBy90Optimal(matrix);
        MatrixOperations.printMatrix(matrix);
    }
    public static void rotateMatrixBy90Optimal(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[i].length;j++){
                matrix[i][j]=matrix[j][i];
            }
        }
        for(int i=0;i<matrix.length;i++){
            int left = 0, right=matrix.length-1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    public static int[][] rotateMatrixBy90Brute(int[][] matrix){
        int[][] rotate = new int[matrix.length][matrix.length];
        int n=matrix.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rotate[j][n-i-1]=matrix[i][j];
            }
        }
        return rotate;
    }

}

