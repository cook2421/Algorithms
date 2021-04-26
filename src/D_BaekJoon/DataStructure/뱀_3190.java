package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀_3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mapSize = Integer.parseInt(st.nextToken());
        DummyMap dummyMap = new DummyMap(mapSize);

        st = new StringTokenizer(br.readLine());
        int appleCnt = Integer.parseInt(st.nextToken());
        for(int i=0; i<appleCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken())-1;
            int col = Integer.parseInt(st.nextToken())-1;
            dummyMap.placeApples(row, col);
        }

        st = new StringTokenizer(br.readLine());
        int chgTimingCnt = Integer.parseInt(st.nextToken());
        Queue<String> chgTiming = new LinkedList<>();
        for(int i=0; i<chgTimingCnt; i++){
            st = new StringTokenizer(br.readLine());
            chgTiming.add(st.nextToken());
            chgTiming.add(st.nextToken());
        }

        int time = 0;
        boolean isAlive = true;

        Snake snake = new Snake(dummyMap);
        while (isAlive) {
            if(!chgTiming.isEmpty() && time == Integer.parseInt(chgTiming.peek())){
                chgTiming.poll();
                snake.changeDirection(chgTiming.poll().charAt(0));
            }
            isAlive = snake.move(mapSize, dummyMap);
            time++;
        }
        System.out.println(time);
    }
}

class DummyMap {
    int time;
    int[][] map;

    public DummyMap(int n){
        this.time = 0;
        this.map = new int[n][n];
    }

    public void placeApples(int row, int col) {
        this.map[row][col] = 2;
    }
}


class Snake {
    int bodySize;
    char direction;     // E, W, S, N
    Integer[] lastPosition;
    Queue<Integer[]> body = new LinkedList<>();

    public Snake(DummyMap dummyMap) {
        this.bodySize = 1;
        this.direction = 'E';
        this.lastPosition = new Integer[]{0, 0};
        this.body.add(new Integer[]{0, 0});
        dummyMap.map[0][0] = 1;
    }

    public boolean move(int mapSize, DummyMap dummyMap){
        switch (this.direction){
            case 'E' : this.lastPosition[1] += 1; break;
            case 'W' : this.lastPosition[1] -= 1; break;
            case 'S' : this.lastPosition[0] += 1; break;
            case 'N' : this.lastPosition[0] -= 1; break;
        }

        if(lastPosition[0] == -1 || lastPosition[0] == mapSize ||
        lastPosition[1] == -1 || lastPosition[1] == mapSize) return false;  // 벽에 부딪힌 경우
        if(dummyMap.map[lastPosition[0]][lastPosition[1]] == 1) return false;  // 자기 몸에 부딪힌 경우

        this.body.add(new Integer[]{lastPosition[0], lastPosition[1]});
        if(dummyMap.map[lastPosition[0]][lastPosition[1]] != 2){
            Integer[] tail = body.poll();
            dummyMap.map[tail[0]][tail[1]] = 0;
        }
        dummyMap.map[lastPosition[0]][lastPosition[1]] = 1;

        return true;
    }

    public void changeDirection(char chgDirctn) {
        if(chgDirctn == 'D'){
            switch (this.direction){
                case 'E' : this.direction = 'S'; break;
                case 'W' : this.direction = 'N'; break;
                case 'S' : this.direction = 'W'; break;
                case 'N' : this.direction = 'E'; break;
            }
        } else {
            switch (this.direction){
                case 'E' : this.direction = 'N'; break;
                case 'W' : this.direction = 'S'; break;
                case 'S' : this.direction = 'E'; break;
                case 'N' : this.direction = 'W'; break;
            }
        }
    }
}

