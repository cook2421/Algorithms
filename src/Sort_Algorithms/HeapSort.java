package Sort_Algorithms;

import java.util.Arrays;

public class HeapSort {
    public static void heapify(int array[], int n, int i) {
        int p = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        if (l < n && array[p] < array[l]) {
            p = l;
        }

        if (r < n && array[p] < array[r]) {
            p = r;
        }

        if (i != p) {
            swap(array, p, i);
            heapify(array, n, p);
        }
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        // init, max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // for extract max element from heap
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 230, 10, 60, 550, 40, 220, 20 };

        heapSort(array);

        System.out.println("힙 정렬 후: "+ Arrays.toString(array));
    }
}
