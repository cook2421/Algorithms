package D_BaekJoon.Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐색_2178_NOT_SOLVED {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n][m];
        int[][] adjArray = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            adjArray[i] = Arrays.asList(st.nextToken().split("")).stream().mapToInt(Integer::parseInt).toArray();
        }

    }

    public static void getMoveCountInMaze(int[][] adjArray, boolean[][] visited){
        Queue<Integer> que = new LinkedList<>();
        int v = adjArray[0][0];
        que.add(v);
        visited[0][0] = true;

        int moveCnt = 0;

        while(!que.isEmpty()){
            v = que.poll();


        }
    }
}
