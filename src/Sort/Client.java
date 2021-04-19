package Sort;

import Sort.Simple_Slow.A_SelectionSort;
import Sort.Simple_Slow.B_InsertionSort;
import Sort.Simple_Slow.C_BubbleSort;

public class Client {
    public static void main(String[] args) {

        int[] array_b = new int[1000];
        int[] array_s = new int[1000];
        int[] array_i = new int[1000];
        int[] array_m = new int[1000];
        int[] array_h = new int[1000];
        int[] array_q = new int[1000];

        for(int i=0; i<1000; i++){
            int random = (int)(Math.random() * 1000 + 1);
            array_b[i] = random;
            array_s[i] = random;
            array_i[i] = random;
            array_m[i] = random;
            array_h[i] = random;
            array_q[i] = random;
        }


        C_BubbleSort b = new C_BubbleSort();
        b.bubbleSort(array_b);

        A_SelectionSort s = new A_SelectionSort();
        s.selectionSort(array_s);

        B_InsertionSort i = new B_InsertionSort();
        i.insertionSort(array_i);
    }
}
