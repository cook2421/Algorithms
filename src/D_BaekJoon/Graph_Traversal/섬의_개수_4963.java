package D_BaekJoon.Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의_개수_4963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        while(w != 0 && h != 0){
            boolean[][] visited = new boolean[h][w];
            int[][] map = new int[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int landCnt = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j] == 1 && !visited[i][j]) {
                        visitLand(i, j, map, visited);
                        landCnt++;
                    }
                }
            }
            System.out.println(landCnt);

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
    }

    public static void visitLand(int h, int w, int[][] map, boolean[][] visited){
        visited[h][w] = true;
        int row = map.length-1;
        int col = map[0].length-1;

        if(w+1<=col && map[h][w+1]==1 && !visited[h][w+1]) visitLand(h, w+1, map, visited);
        if(h+1<=row && map[h+1][w]==1 && !visited[h+1][w]) visitLand(h+1, w, map, visited);
        if(0<=w-1 && map[h][w-1]==1 && !visited[h][w-1]) visitLand(h, w-1, map, visited);
        if(0<=h-1 && map[h-1][w]==1 && !visited[h-1][w]) visitLand(h-1, w, map, visited);

        if(w+1<=col && h+1<=row && map[h+1][w+1]==1 && !visited[h+1][w+1]) visitLand(h+1, w+1, map, visited);
        if(w+1<=col && 0<=h-1 && map[h-1][w+1]==1 && !visited[h-1][w+1]) visitLand(h-1, w+1, map, visited);
        if(0<=w-1 && h+1<=row && map[h+1][w-1]==1 && !visited[h+1][w-1]) visitLand(h+1, w-1, map, visited);
        if(0<=w-1 && 0<=h-1 && map[h-1][w-1]==1 && !visited[h-1][w-1]) visitLand(h-1, w-1, map, visited);
    }
}
