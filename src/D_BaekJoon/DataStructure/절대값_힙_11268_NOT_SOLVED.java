package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 절대값_힙_11268_NOT_SOLVED {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        AbsMinHeap heap = new AbsMinHeap();

        int loop = Integer.parseInt(st.nextToken());
        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            int next = Integer.parseInt(st.nextToken());
            if(next != 0) {
                heap.add(next);
            } else {
                System.out.println(heap.poll());
            }
        }
    }
}

class AbsMinHeap {

    ArrayList<Integer> heap;

    public AbsMinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void add(int num){

        heap.add(num);
        int position = heap.size() - 1;

        while(position/2 > 0 && doesNeedToSwap(heap.get(position), heap.get(position/2))){
            int temp = heap.get(position/2);
            heap.set(position/2, heap.get(position));
            heap.set(position, temp);
            position /= 2;
        }

        // todo 반례 찾아야 함!!!
        while(position-1 > 0 && doesNeedToSwap(heap.get(position), heap.get(position-1))){
            int temp = heap.get(position-1);
            heap.set(position-1, heap.get(position));
            heap.set(position, temp);
            position -= 1;
        }
    }

    public int poll(){
        if(heap.size() <= 1) return 0;

        int result = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int position = 1;
        while(position*2 < heap.size() && doesNeedToSwap(heap.get(position*2), heap.get(position))){
            int min = heap.get(position*2);
            int minPos = position*2;

            if(position*2+1 < heap.size() && doesNeedToSwap(heap.get(position*2+1), min)){
                min = heap.get(position*2+1);
                minPos = position*2+1;
            }

            heap.set(minPos, heap.get(position));
            heap.set(position, min);

            position = minPos;
        }
        return result;
    }

    public boolean doesNeedToSwap(int desc, int asc){
        if(getAbsValue(desc) < getAbsValue(asc)){
            return true;
        } else if(getAbsValue(desc) == getAbsValue(asc) && desc < asc){
            return true;
        }
        return false;
    }

    public int getAbsValue(int n){
        if(n > 0) return n;
        else return n*-1;
    }
}
