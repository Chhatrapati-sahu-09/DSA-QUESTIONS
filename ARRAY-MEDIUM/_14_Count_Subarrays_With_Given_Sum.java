import java.util.*;

public class _14_Count_Subarrays_With_Given_Sum {

    public static int bruteForce(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int optimal(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);

        for (int num : nums) {
            sum += num;
            int remove = sum - k;
            if (preSumMap.containsKey(remove)) {
                count += preSumMap.get(remove);
            }
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("Brute Force: " + bruteForce(nums, k));
        System.out.println("Optimal:     " + optimal(nums, k));
    }
}
