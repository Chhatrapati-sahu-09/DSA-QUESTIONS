class _02_Second_Largest_Element {
    public static void main(String[] args) {

        int[] arr = { 10, 45, 23, 89, 67 };

        if (arr.length < 2) {
            System.out.println("Second largest element not possible");
            return;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > largest) {

                secondLargest = largest;

                largest = arr[i];
            }

            else if (arr[i] > secondLargest && arr[i] != largest) {

                secondLargest = arr[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element (all elements same)");
        } else {
            System.out.println("Second largest element is: " + secondLargest);
        }
    }
}