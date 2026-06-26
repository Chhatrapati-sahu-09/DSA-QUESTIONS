import java.util.*;

public class _09_Leaders_In_An_Array {

    public static ArrayList<Integer> bruteForce(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] <= arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                leaders.add(arr[i]);
            }
        }
        return leaders;
    }

    public static ArrayList<Integer> optimal(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        if (n == 0) return leaders;

        int maxElement = arr[n - 1];
        leaders.add(maxElement);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxElement) {
                leaders.add(arr[i]);
                maxElement = arr[i];
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println("Brute Force: " + bruteForce(arr));
        System.out.println("Optimal: " + optimal(arr));
    }
}
