package D_BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙산_2573 {

    static boolean[][] visited;
    static int[][] iceberg;
    static int[][] iceLoss;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        visited = new boolean[row][col];
        iceberg = new int[row][col];
        iceLoss = new int[row][col];

        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++){
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int age = 0;
        int group = 1;

        while(group < 2 && group > 0) {
            visited = new boolean[row][col];
            iceLoss = new int[row][col];
            group = 0;

            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    if (iceberg[i][j] > 0) getLossSize(i, j);
                }
            }

            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    if (iceLoss[i][j] > 0) iceberg[i][j] -= iceLoss[i][j];
                }
            }

            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    if (iceberg[i][j] > 0 && !visited[i][j]) {
                        dfs(i, j);
                        group++;
                    }
                }
            }

            age++;
        }

        age = group == 0 ? 0 : age;
        System.out.println(age);
    }

    public static void getLossSize(int x, int y){
        if(iceberg[x-1][y] <= 0) iceLoss[x][y]++;
        if(iceberg[x+1][y] <= 0) iceLoss[x][y]++;
        if(iceberg[x][y-1] <= 0) iceLoss[x][y]++;
        if(iceberg[x][y+1] <= 0) iceLoss[x][y]++;
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        if(!visited[x-1][y] && iceberg[x-1][y] > 0) dfs(x-1, y);
        if(!visited[x+1][y] && iceberg[x+1][y] > 0) dfs(x+1, y);
        if(!visited[x][y-1] && iceberg[x][y-1] > 0) dfs(x, y-1);
        if(!visited[x][y+1] && iceberg[x][y+1] > 0) dfs(x, y+1);
    }
}
