package B_DataStructure.E_Tree;

public class SegmentTree {
    int arr[];      // 구간 합을 만들 요소들
    int tree[];     // 구간 합 트리

    public SegmentTree(int[] numArr) {
        arr = numArr;
        tree = new int[arr.length*4];
    }

    public int init(int start, int end, int node) {
        if(start == end) {      // 리프노드이거나 자식노드들이 구간 합이 모두 구해졌을 경우
            return tree[node] = arr[start];     // 구간 합 트리에 넣어준다
        }
        // 반씩 나눠서 재귀적으로 자신노드들의 구간 합을 구해준다
        int mid = (start+end)/2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    public int sum(int start, int end, int node, int left, int right) {
        if(left>end || right<start) {
            return 0;
        }
        if(left<=start && end<=right) {
            return tree[node];
        }
        // 필요한 구간마다 밑에서부터 구간 합을 가지고 올라온다
        int mid = (start+end)/2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }

    public void update(int start, int end, int node, int index, int dif){
        if(index<start || index>end) {
            return;
        }
        tree[node] += dif;      // 변경된 값만큼 더해주고
        if(start == end) {
            return;
        }
        // 변경된 값이 속해있는 구간의 구간 합을 모두 바꿔준다
        int mid = (start+end)/2;
        update(start, mid, node*2, index, dif);
        update(mid+1, end, node*2+1, index, dif);
    }

    public void print() {
        for(int i=1; i<this.tree.length; i++){
            System.out.println(i + "번째 인덱스 : " + this.tree[i]);
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[] numArr = {1,2,3,4,5,6,7,8,9,10};

        SegmentTree st = new SegmentTree(numArr);

        st.init(0, st.arr.length-1, 1);
    }
}
