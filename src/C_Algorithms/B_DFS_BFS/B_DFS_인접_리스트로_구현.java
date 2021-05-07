package C_Algorithms.B_DFS_BFS;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class B_DFS_인접_리스트로_구현 {
    public static void main(String[] args) {
        // 그래프 표현
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 정점의 개수
        int m = sc.nextInt();   // 간선의 개수
        int v = sc.nextInt();   // 탐색을 시작할 정점의 번호

        boolean visited[] = new boolean[n+1];   // 방문 여부를 검사할 배열

        LinkedList<Integer>[] adjList = new LinkedList[n+1];

        for(int i=0; i<=n; i++){
            adjList[i] = new LinkedList<>();
        }

        // 두 정점 사이에 여러 개의 간선이 있을 수 있다.
        // 입력으로 주어지는 간선은 양방향이다.
        for(int i=0; i<m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for(int i=1; i<=n; i++){    // 방문 순서를 위해 오름차순 정렬
            Collections.sort(adjList[i]);
        }

        System.out.println("DFS - 인접리스트");
        DFS_인접리스트_재귀로구현(v, adjList, visited);
    }


    // DFS - 인접리스트 - 재귀로 구현
    public static void DFS_인접리스트_재귀로구현(int v, LinkedList<Integer>[] adjList, boolean[] visited){
        visited[v] = true;  // 정점 방문 표시
        System.out.print(v + " ");    // 정점 출력

        Iterator<Integer> iter = adjList[v].listIterator();   // 정점 인접리스트 순회
        while(iter.hasNext()){
            int w = iter.next();
            if(!visited[w]){    // 방문하지 않은 정점이라면
                DFS_인접리스트_재귀로구현(w, adjList, visited);   // 다시 DFS
            }
        }
    }
}