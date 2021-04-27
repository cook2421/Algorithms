package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최대_힙_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());

        MaxHeap_11279 heap = new MaxHeap_11279();
        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order == 0){
                System.out.println(heap.delete());
            } else {
                heap.insert(order);
            }
        }
    }
}

class MaxHeap_11279 {

    private ArrayList<Integer> heap;

    public MaxHeap_11279(){
        this.heap = new ArrayList<>();
        heap.add(0);
    }

    public void insert(int n){
        heap.add(n);
        int position = heap.size()-1;

        while(position > 1 && heap.get(position/2) < heap.get(position)){

            int temp = heap.get(position);
            heap.set(position, heap.get(position/2));
            heap.set(position/2, temp);

            position /= 2;
        }
    }

    public int delete(){
        if(heap.size() <= 1) return 0;

        int deleteData = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int position = 1;
        while(position*2 < heap.size()){
            int max = heap.get(position*2);
            int maxPos = position*2;

            if((position*2+1) < heap.size() && heap.get(position*2+1) > max){
                max = heap.get(position*2+1);
                maxPos = position*2+1;
            }

            if(heap.get(position) > max) break;

            int temp = heap.get(position);
            heap.set(position, heap.get(maxPos));
            heap.set(maxPos, temp);

            position = maxPos;
        }
        return deleteData;
    }
}
