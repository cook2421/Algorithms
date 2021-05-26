package D_BaekJoon.Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미로_탐색_2178 {
    static int h;
    static int w;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[h][w];

        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            map[i] = Arrays.asList(st.nextToken().split("")).stream().mapToInt(Integer::parseInt).toArray();
        }

        int res = getMoveCountInMaze();

        System.out.println(res);
    }



    public static int getMoveCountInMaze(){
        int moveCnt = 0;

        int curRow = 0;
        int curCol = 0;
        int curDist = 1;

        Queue<Coord> que = new LinkedList<>();
        que.add(new Coord(curRow, curCol, curDist));

        while(!que.isEmpty()){
            Coord c = que.poll();
            curRow = c.row;
            curCol = c.col;
            curDist = c.dist;
            moveCnt = curDist;

            if(curRow==h-1 && curCol==w-1) break;

            if(0<=curRow-1 && map[curRow-1][curCol]==1){
                map[curRow-1][curCol] = 0;
                que.add(new Coord(curRow-1, curCol, curDist+1));
            }
            if(curRow+1<h && map[curRow+1][curCol]==1){
                map[curRow+1][curCol] = 0;
                que.add(new Coord(curRow+1, curCol, curDist+1));
            }
            if(0<=curCol-1 && map[curRow][curCol-1]==1){
                map[curRow][curCol-1] = 0;
                que.add(new Coord(curRow, curCol-1, curDist+1));
            }
            if(curCol+1<w && map[curRow][curCol+1]==1){
                map[curRow][curCol+1] = 0;
                que.add(new Coord(curRow, curCol+1, curDist+1));
            }
        }

        return moveCnt;
    }



    public static class Coord {
        int row, col, dist;

        public Coord(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}

