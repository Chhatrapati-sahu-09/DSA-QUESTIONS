import java.util.HashMap;

class _14_Longest_Subarray_K {

    public static int maxLen(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum == 0) {

                maxLen = i + 1;
            }

            if (map.containsKey(sum)) {

                int len = i - map.get(sum);

                maxLen = Math.max(maxLen, len);
            }

            else {

                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };

        int ans = maxLen(arr);

        System.out.println("Longest Length = " + ans);
    }
}