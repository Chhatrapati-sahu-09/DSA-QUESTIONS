class _04_Remove_Duplicates {
    public static void main(String[] args) {

        int[] arr = { 1, 1, 2, 2, 2, 3, 3 };

        int n = arr.length;

        if (n == 0) {
            System.out.println("Unique count: 0");
            return;
        }

        int i = 0;

        for (int j = 1; j < n; j++) {

            if (arr[j] != arr[i]) {

                i++;
                arr[i] = arr[j];
            }
        }

        int uniqueCount = i + 1;

        System.out.print("Output: [");
        for (int k = 0; k < n; k++) {
            if (k < uniqueCount) {
                System.out.print(arr[k]);
            } else {
                System.out.print("_");
            }
            if (k != n - 1)
                System.out.print(",");
        }
        System.out.println("]");

        System.out.println("Unique count: " + uniqueCount);
    }
}
