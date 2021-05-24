package D_BaekJoon.Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와_BFS_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        boolean visited[] = new boolean[n+1];

        LinkedList<Integer>[] adjList = new LinkedList[n+1];

        for(int i=0; i<=n; i++){
            adjList[i] = new LinkedList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(adjList[i]);
        }

        dfs_list(v, adjList, visited);
        System.out.println();
        bfs_list(v, adjList, new boolean[n+1]);
    }

    public static void dfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited){
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> iter = adjList[v].listIterator();
        while(iter.hasNext()){
            int w = iter.next();
            if(!visited[w]){
                dfs_list(w, adjList, visited);
            }
        }
    }

    public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while(queue.size() != 0){
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> iter = adjList[v].listIterator();
            while(iter.hasNext()){
                int w = iter.next();
                if(!visited[w]){
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}
