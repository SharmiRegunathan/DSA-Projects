import java.util.Arrays;

public class two_D_Arrays {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6}};

        int[][] ans = transpose(mat);

        for(int[] arr: mat){
            for(int elem: arr){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int n = matrix[0].length;

        for(int i = 0 ; i <= n-2; i++){
            for(int j = i+1; j < n; j++){
                swapElems(matrix,i,j);
            }
        }

        return matrix;
    }

    public static void swapElems(int[][] mat, int i, int j){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }
}
