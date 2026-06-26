import java.util.*;

public class _13_Print_Matrix_In_Spiral_Order {

    public static List<Integer> bruteForce(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        int r = 0, c = 0, di = 0;
        
        for (int i = 0; i < m * n; i++) {
            result.add(matrix[r][c]);
            visited[r][c] = true;
            
            int nextR = r + dr[di];
            int nextC = c + dc[di];
            
            if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !visited[nextR][nextC]) {
                r = nextR;
                c = nextC;
            } else {
                di = (di + 1) % 4;
                r = r + dr[di];
                c = c + dc[di];
            }
        }
        return result;
    }

    public static List<Integer> optimal(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        System.out.println("Brute Force: " + bruteForce(matrix));
        System.out.println("Optimal:     " + optimal(matrix));
    }
}
