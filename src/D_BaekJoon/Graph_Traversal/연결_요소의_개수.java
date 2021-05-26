package D_BaekJoon.Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 연결_요소의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];
        LinkedList<Integer>[] adjList = new LinkedList[n+1];

        for(int i=1; i<=n; i++){
            adjList[i] = new LinkedList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        int result = 0;
        for(int i=1; i<=n; i++){
            if(!visited[i]) {
                dfs_list(i, adjList, visited);
                result++;
            }
        }

        System.out.println(result);
    }

    public static void dfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited){
        visited[v] = true;

        Iterator<Integer> iter = adjList[v].listIterator();
        while(iter.hasNext()){
            int w = iter.next();
            if(!visited[w]){
                dfs_list(w, adjList, visited);
            }
        }
    }
}
