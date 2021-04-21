package B_DataStructure.F_Graph;

import java.util.ArrayList;

public class ListGraph {

    private ArrayList<ArrayList<Integer>> listGraph;

    public ListGraph(int initSize){
        this.listGraph = new ArrayList<>();

        for(int i=0; i<initSize+1; i++){
            listGraph.add(new ArrayList<>());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph() {
        return this.listGraph;
    }

    public ArrayList<Integer> getNode(int i){
        return this.listGraph.get(i);
    }

    public void put(int x, int y){
        listGraph.get(x).add(y);
        listGraph.get(y).add(x);
    }

    public void putSingle(int x, int y){
        listGraph.get(x).add(y);
    }

    public void printGraphToAdjList(){
        for(int i=1; i<listGraph.size(); i++){
            System.out.print("정점 " + i + "의 인접리스트");

            for(int j=0; j<listGraph.get(i).size(); j++) {
                System.out.print(" -> " + listGraph.get(i).get(j));
            }
            System.out.println();
        }
    }
}

class AdjacentList {
    public static void main(String[] args) {
        int initSize = 6;
        ListGraph adjList = new ListGraph(initSize);

        adjList.put(1,2);
        adjList.put(1,3);
        adjList.put(2,3);
        adjList.put(2,4);
        adjList.put(3,4);
        adjList.put(3,5);
        adjList.put(4,5);
        adjList.put(4,6);

        adjList.printGraphToAdjList();
    }
}
