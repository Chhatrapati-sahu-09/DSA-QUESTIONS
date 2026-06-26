import java.util.*;

public class _12_Rotate_Matrix_By_90_Degrees {

    public static int[][] bruteForce(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static void optimal(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] rotated = bruteForce(matrix1);
        System.out.println("Brute Force Result:");
        for (int[] row : rotated) {
            System.out.println(Arrays.toString(row));
        }

        optimal(matrix2);
        System.out.println("Optimal Result:");
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }
    }
}
