package D_BaekJoon.DataStructure.NOT_SOLVED;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//todo 시간 초과!!!
public class 탑_2493_NOT_SOLVED {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int towerCnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        LinkedList_2493 towers = new LinkedList_2493();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<towerCnt; i++){
            towers.add(Integer.parseInt(st.nextToken()));
            sb.append(towers.getReceiver());
            if(i!=towerCnt-1) sb.append(" ");
        }

        System.out.println(sb);
    }
}

class CellTower {
    Integer height;
    Integer idx;
    CellTower preTower;
}

class LinkedList_2493 {
    CellTower rear;
    int size;

    public LinkedList_2493() {
        rear = new CellTower();
        size = 0;
    }

    public void add(int num){
        CellTower newTower = new CellTower();
        newTower.height = num;

        if(size == 0){
            newTower.idx = 1;
        } else {
            newTower.idx = rear.idx + 1;
            newTower.preTower = rear;
        }
        rear = newTower;

        size++;
    }

    public int getReceiver() {
        if(size == 0 || size == 1) return 0;

        CellTower preTower = rear.preTower;
        while(preTower != null && preTower.height < rear.height) {
            preTower = preTower.preTower;
        }

        return preTower == null ? 0 : preTower.idx;
    }
}