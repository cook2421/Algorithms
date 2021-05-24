
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        boolean[] visited = new boolean[n+1];

        LinkedList<Integer>[] adjList = new LinkedList[n+1];

        for(int i=0; i<=n; i++){
            adjList[i] = new LinkedList<>();
        }

        for(int i=0; i<m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(adjList[i]);
        }

        dfs_list(v, adjList, visited);
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

    }
}