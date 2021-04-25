package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뱀_3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mapSize = Integer.parseInt(st.nextToken());
        DummyMap map = new DummyMap(mapSize);

        st = new StringTokenizer(br.readLine());
        int appleCnt =
    }
}

class DummyMap {

    int[][] map;

    public DummyMap(int n){
        map = new int[n][n];
    }

    public void placeApples() {

    }
}

