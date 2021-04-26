package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최소_힙_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());
        MinHeap_1927 minHeap = new MinHeap_1927();

        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0){
                if(minHeap.size() <= 1) {
                    System.out.println(0);
                } else {
                    System.out.println(minHeap.delete());
                }
            } else {
                minHeap.insert(n);
            }
        }
    }
}

class MinHeap_1927 {

    private ArrayList<Integer> heap;

    public MinHeap_1927() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void insert(int n) {
        heap.add(n);
        int position = heap.size() - 1;

        while(position > 1 && heap.get(position/2) > heap.get(position)){
            int temp = heap.get(position);
            heap.set(position, heap.get(position/2));
            heap.set(position/2, temp);

            position /= 2;
        }
    }

    public int delete() {
        if(heap.size() - 1 < 1) {
            return 0;
        }

        int deleteData = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int position = 1;
        while((position*2) < heap.size()){
            int min = heap.get(position*2);
            int minPos = position*2;

            if((position*2 + 1) < heap.size() && heap.get(position*2 + 1) < min) {
                min = heap.get(position*2 + 1);
                minPos = position*2 + 1;
            }

            if(heap.get(position) < min) break;

            int temp = heap.get(position);
            heap.set(position, min);
            heap.set(minPos, temp);

            position = minPos;
        }
        return deleteData;
    }

    public int size() {
        return heap.size();
    }
}
