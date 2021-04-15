package DFS_BFS;

import java.util.LinkedList;
import java.util.Scanner;

public class B_인접_리스트로_구현 {
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

    }





}
