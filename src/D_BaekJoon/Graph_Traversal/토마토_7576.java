package D_BaekJoon.Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 토마토_7576 {
    static int row;
    static int col;
    static int[][] tomato;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        tomato = new int[row][col];

        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Coord> que = new LinkedList<>();
        List<Integer[]> pointsArr = findStartPoint();
        for(int i=0; i<pointsArr.size(); i++){
            Integer[] point = pointsArr.get(i);
            que.add(new Coord(point[0], point[1], 0));
        }
        int result = getDays(que);

        if(!checkRemainTomato()){
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    public static int getDays(Queue<Coord> que){
        int curRow;
        int curCol;
        int curDays;
        int finalDays = 0;

        while(!que.isEmpty()){
            Coord c = que.poll();
            curRow = c.row;
            curCol = c.col;
            curDays = c.days;

            if(curDays > finalDays) finalDays = curDays;

            if(curRow+1<row && tomato[curRow+1][curCol]==0) {
                tomato[curRow+1][curCol] = 1;
                que.add(new Coord(curRow+1, curCol, curDays+1));
            }
            if(curCol+1<col && tomato[curRow][curCol+1]==0) {
                tomato[curRow][curCol+1] = 1;
                que.add(new Coord(curRow, curCol+1, curDays+1));
            }
            if(0<=curRow-1 && tomato[curRow-1][curCol]==0) {
                tomato[curRow-1][curCol] = 1;
                que.add(new Coord(curRow-1, curCol, curDays+1));
            }
            if(0<=curCol-1 && tomato[curRow][curCol-1]==0) {
                tomato[curRow][curCol-1] = 1;
                que.add(new Coord(curRow, curCol-1, curDays+1));
            }
        }

        return finalDays;
    }

    public static List<Integer[]> findStartPoint(){
        List<Integer[]> pointsArr = new ArrayList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(tomato[i][j]==1){
                    Integer[] point = {i, j};
                    pointsArr.add(point);
                }
            }
        }
        return pointsArr;
    }

    public static boolean checkRemainTomato(){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(tomato[i][j]==0) return true;
            }
        }
        return false;
    }

    public static class Coord {
        int row;
        int col;
        int days;

        public Coord(int row, int col, int days){
            this.row = row;
            this.col = col;
            this.days = days;
        }
    }
}