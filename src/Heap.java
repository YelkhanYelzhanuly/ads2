public class Heap {
    public void heapify(int[] arr, int n, int i) {
        int larg = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && arr[left] > arr[larg]) {
            larg = left;
        }

        if (right < n && arr[right] > arr[larg]) {
            larg = right;
        }

        if (larg != i) {
            int temp = arr[i];
            arr[i] = arr[larg];
            arr[larg] = temp;
            heapify(arr, n, larg);
        }
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}