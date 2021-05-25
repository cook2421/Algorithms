package D_BaekJoon.Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농_배추_1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test = Integer.parseInt(st.nextToken());

        int[] result = new int[test];

        for(int t=0; t<test; t++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[n][m];
            int[][] cabPatch = new int[n][m];

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabPatch[y][x] = 1;
            }

            int count = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(cabPatch[j][i] == 1 && !visited[j][i]) {
                        visitCabbageGroup(j, i, cabPatch, visited);
                        count++;
                    }
                }
            }
            result[t] = count;
        }

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static void visitCabbageGroup(int x, int y, int[][] cabPatch, boolean[][] visited){
        visited[x][y] = true;

        int n = cabPatch.length;
        int m = cabPatch[0].length;

        if(0<=y+1 && y+1<m && cabPatch[x][y+1] == 1 && !visited[x][y+1]) visitCabbageGroup(x, y+1, cabPatch, visited);
        if(0<=x+1 && x+1<n && cabPatch[x+1][y] == 1 && !visited[x+1][y]) visitCabbageGroup(x+1, y, cabPatch, visited);
        if(0<=y-1 && y-1<m && cabPatch[x][y-1] == 1 && !visited[x][y-1]) visitCabbageGroup(x, y-1, cabPatch, visited);
        if(0<=x-1 && x-1<n && cabPatch[x-1][y] == 1 && !visited[x-1][y]) visitCabbageGroup(x-1, y, cabPatch, visited);
    }
}
