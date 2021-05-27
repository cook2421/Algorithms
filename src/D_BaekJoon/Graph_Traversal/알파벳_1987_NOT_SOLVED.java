package D_BaekJoon.Graph_Traversal;

import java.util.*;

/*

메모리 초과

DFS로 변경하고 백트래킹 적용할 것
 
*/
public class 알파벳_1987_NOT_SOLVED {
    static int r;
    static int c;
    static String[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        board = new String[r][c];

        for(int i=0; i<r; i++){
            board[i] = sc.next().split("");
        }
        System.out.println(getDistance(0,0,1));
    }

    public static int getDistance(int h, int w, int d){
        Queue<Coord> que = new LinkedList<>();
        String s = board[h][w];
        que.add(new Coord(h, w, d, s));
        int curRow;
        int curCol;
        int curDist;
        String curSt;

        int finalDist = 0;

        while(!que.isEmpty()){
            Coord cd = que.poll();
            curRow = cd.row;
            curCol = cd.col;
            curDist = cd.dist;
            curSt = cd.st;

            if(finalDist < curDist) finalDist = curDist;

            if(curRow+1<r && curSt.indexOf(board[curRow+1][curCol])==-1){
                String str = curSt + board[curRow+1][curCol];
                que.add(new Coord(curRow+1, curCol, curDist+1, str));
            }
            if(curCol+1<r && curSt.indexOf(board[curRow][curCol+1])==-1){
                String str = curSt + board[curRow][curCol+1];
                que.add(new Coord(curRow, curCol+1, curDist+1, str));
            }
            if(0<=curRow-1 && curSt.indexOf(board[curRow-1][curCol])==-1){
                String str = curSt + board[curRow-1][curCol];
                que.add(new Coord(curRow-1, curCol, curDist+1, str));
            }
            if(0<=curCol-1 && curSt.indexOf(board[curRow][curCol-1])==-1){
                String str = curSt + board[curRow][curCol-1];
                que.add(new Coord(curRow, curCol-1, curDist+1, str));
            }
        }

        return finalDist;
    }

    public static class Coord {
        int row;
        int col;
        int dist;
        String st;

        public Coord(int h, int w, int d, String s){
            this.row = h;
            this.col = w;
            this.dist = d;
            this.st = s;
        }
    }
}
