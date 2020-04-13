package SortAlgorithms;

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


        BubbleSort b = new BubbleSort();
        b.bubbleSort(array_b);

        SelectionSort s = new SelectionSort();
        s.selectionSort(array_s);

        InsertionSort i = new InsertionSort();
        i.insertionSort(array_i);
    }
}
