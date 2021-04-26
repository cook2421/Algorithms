import B_DataStructure.G_Heap.MaxHeap;
import B_DataStructure.G_Heap.MinHeap;

public class Main {
    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap();
        mh.insert(1);
        mh.insert(2);
        mh.insert(3);
        mh.insert(4);
        mh.insert(5);
        mh.insert(6);
        mh.insert(7);
        mh.insert(8);
        mh.insert(9);
        mh.insert(10);

        mh.delete();
        mh.delete();
        mh.delete();
        mh.delete();
        mh.delete();
        mh.delete();
        mh.delete();
        mh.delete();
        mh.delete();
        mh.delete();
    }
}
