package E_Programmers.J_Graph;

import java.util.*;

public class A_가장_먼_노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};

        System.out.println(solution(n, edge));
    }

    public static int solution(int n, int[][] edge){

        boolean visited[] = new boolean[n+1];
        LinkedList<Integer>[] adjList = new LinkedList[n+1];
        List depthList = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adjList[i] = new LinkedList<>();
        }

        for(int i=0; i<edge.length; i++){
            int v1 = edge[i][0];
            int v2 = edge[i][1];

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(adjList[i]);
        }

        dfs_list(1, adjList, visited, depthList,1);

        Collections.sort(depthList);
        int idx = depthList.indexOf(Collections.max(depthList));

        return depthList.size() - idx;
    }

    public static void dfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited, List depthList, int depth){
        visited[v] = true;
        depthList.add(++depth);

        Iterator<Integer> itr = adjList[v].listIterator();
        while(itr.hasNext()){
            int w = itr.next();
            if(!visited[w]){
                dfs_list(w, adjList, visited, depthList, depth);
            }
        }
    }
}
