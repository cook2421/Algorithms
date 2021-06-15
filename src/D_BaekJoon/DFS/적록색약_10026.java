package D_BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적록색약_10026 {

    static boolean[][] visited;
    static char[][] colorGrid;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        visited = new boolean[t][t];
        colorGrid = new char[t][t];
        size = t;
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            colorGrid[i] = st.nextToken().toCharArray();
        }

        int color = 0;
        for(int i=0; i<t; i++){
            for(int j=0; j<t; j++){
                if(visited[i][j] == false){
                    dfs_color(i, j);
                    color++;
                }
            }
        }

        visited = new boolean[t][t];

        int blind = 0;
        for(int i=0; i<t; i++){
            for(int j=0; j<t; j++){
                if(visited[i][j] == false){
                    dfs_color_blind(i, j);
                    blind++;
                }
            }
        }

        System.out.print(color);
        System.out.print(" ");
        System.out.print(blind);
    }

    public static void dfs_color_blind(int x, int y){
        visited[x][y] = true;

        if(x<size-1) {
            int pre = colorGrid[x][y]%66;
            int post = colorGrid[x+1][y]%66;
            if (visited[x + 1][y] == false && !(pre*post==0 && pre+post>0)) dfs_color_blind(x+1, y);
        }

        if(y<size-1){
            int pre = colorGrid[x][y]%66;
            int post = colorGrid[x][y+1]%66;
            if (visited[x][y+1] == false && !(pre*post==0 && pre+post>0)) dfs_color_blind(x, y+1);
        }

        if(y-1>=0){
            int pre = colorGrid[x][y]%66;
            int post = colorGrid[x][y-1]%66;
            if (visited[x][y-1] == false && !(pre*post==0 && pre+post>0)) dfs_color_blind(x, y-1);
        }

        if(x-1>=0) {
            int pre = colorGrid[x][y]%66;
            int post = colorGrid[x-1][y]%66;
            if (visited[x-1][y] == false && !(pre*post==0 && pre+post>0)) dfs_color_blind(x-1, y);
        }
    }

    public static void dfs_color(int x, int y){
        visited[x][y] = true;

        if(x<size-1) {
            int pre = colorGrid[x][y];
            int post = colorGrid[x+1][y];
            if (visited[x + 1][y] == false && pre == post) dfs_color(x+1, y);
        }

        if(y<size-1){
            int pre = colorGrid[x][y];
            int post = colorGrid[x][y+1];
            if (visited[x][y+1] == false && pre == post) dfs_color(x, y+1);
        }

        if(y-1>=0){
            int pre = colorGrid[x][y];
            int post = colorGrid[x][y-1];
            if (visited[x][y-1] == false && pre == post) dfs_color(x, y-1);
        }

        if(x-1>=0) {
            int pre = colorGrid[x][y];
            int post = colorGrid[x-1][y];
            if (visited[x-1][y] == false && pre == post) dfs_color(x-1, y);
        }
    }
}
