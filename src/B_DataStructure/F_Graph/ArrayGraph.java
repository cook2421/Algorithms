package B_DataStructure.F_Graph;

public class ArrayGraph {

    private int[][] arrayGraph;

    public ArrayGraph(int initSize){
        this.arrayGraph = new int[initSize+1][initSize+1];
    }

    public int[][] getGraph() {
        return this.arrayGraph;
    }

    // 그래프 추가
    public void put(int x, int y){
        arrayGraph[x][y] = arrayGraph[y][x] = 1;
    }

    // 그래프 추가 (양방향 가중치)
    public void put(int x, int y, int w){
        arrayGraph[x][y] = arrayGraph[y][x] = w;
    }

    public void putSingle(int x, int y){
        arrayGraph[x][y] = 1;
    }

    public void printGraphToAdjArr(){
        for(int i=0; i<arrayGraph.length; i++){
            for(int j=0; j<arrayGraph[i].length; j++){
                System.out.print(" " + arrayGraph[i][j]);
            }
            System.out.println();
        }
    }
}


class AdjacentArray {
    public static void main(String[] args) {
        int initSize = 6;
        ArrayGraph adjArr = new ArrayGraph(initSize);

        adjArr.put(1, 2);
        adjArr.put(1, 3);
        adjArr.put(2, 3);
        adjArr.put(2, 4);
        adjArr.put(3, 4);
        adjArr.put(3, 5);
        adjArr.put(4, 5);
        adjArr.put(4, 6);

        adjArr.printGraphToAdjArr();
    }
}
