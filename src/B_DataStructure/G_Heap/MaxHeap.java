package B_DataStructure.G_Heap;

import java.util.ArrayList;

public class MaxHeap {

    private ArrayList<Integer> heap;

    // heap init
    public MaxHeap() {
        heap = new ArrayList<>();
        heap.add(0);    // heap의 인덱스는 알기 쉽게 0부터 시작한다는 특성을 따른다.
    }

    // insertion
    public void insert(int data){
        heap.add(data);
        int position = heap.size() - 1;

        // 루트 노드까지 이동했거나, 부모 heap이 자식 heap보다 클 때까지
        while(position>1 && heap.get(position/2)<heap.get(position)){
            // 부모 노드와 자식 노드 간의 swap을 위한 연산
            int temp = heap.get(position/2);
            heap.set(position/2, heap.get(position));
            heap.set(position, temp);

            position /= 2;
        }
    }

    // deletion
    public int delete() {
        // heap 사이즈가 1보다 작으면 즉, 힙에 값이 없으면 return 0;
        if(heap.size() - 1 < 1){
            return 0;
        }

        int deleteData = heap.get(1);             // 루트 노드 삭제
        heap.set(1, heap.get(heap.size() - 1));   // 루트 노드의 자리에 말단 노드의 data를 설정
        heap.remove(heap.size() - 1);       // 말단 노드 삭제

        int position = 1;
        while((position*2) < heap.size()){        // 힙의 크기보다 작을 때까지
            int max = heap.get(position*2);       // 현재 노드의 왼쪽 자식 노드의 값
            int maxPos = position*2;              // 현재 노드의 왼쪽 자식 노드의 인덱스

            // 오른쪽 자식 노드와 왼쪽 자식 노드 중 더 큰 노드의 값과 비교하고
            // 교환하기 때문에 왼쪽 자식 노드와 오른쪽 자식 노드의 값을 비교하는 과정을 거친다.
            if(((position*2 + 1) < heap.size()) && max < heap.get(position*2 + 1)) {    // 오른쪽 자식 노드가 더 크면 바꿔줘야한다.
                max = heap.get(position*2 + 1);     // 오른쪽 자식 노드로 변경
                maxPos = position*2 + 1;            // 위치 또한 오른쪽 자식 노드로 변경
            }

            if(heap.get(position) > max) break;     // 현재 노드보다 자식 노드의 값이 더 크면(힙의 성질 만족) 반복 종료

            // 자식과 부모의 swap 과정
            int temp = heap.get(position);
            heap.set(position, heap.get(maxPos));
            heap.set(maxPos, temp);
            position = maxPos;
        }
        return deleteData;
    }
}
