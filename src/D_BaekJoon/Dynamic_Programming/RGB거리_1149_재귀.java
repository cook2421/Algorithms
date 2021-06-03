package D_BaekJoon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RGB거리_1149_재귀 {

    final static int red = 0;
    final static int green = 1;
    final static int blue = 2;

    static int[][] cost;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        cost = new int[n][3];
        DP = new int[n][3];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            cost[i][red] = Integer.parseInt(st.nextToken());
            cost[i][green] = Integer.parseInt(st.nextToken());
            cost[i][blue] = Integer.parseInt(st.nextToken());
        }

        // DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
        DP[0][red] = cost[0][red];
        DP[0][green] = cost[0][green];
        DP[0][blue] = cost[0][blue];

        System.out.println(Math.min(Paint_cost(n-1, red), Math.min(Paint_cost(n-1, green), Paint_cost(n-1, blue))));
    }


    static int Paint_cost(int n, int color){

        // 만약 탐색하지 않은 배열이라면
        if(DP[n][color] == 0){

            // color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최소값과 현재 집의 비용을 더해서 DP에 저장한다.
            if(color == red){
                DP[n][red] = Math.min(Paint_cost(n-1, green), Paint_cost(n-1, blue)) + cost[n][red];
            } else if (color == green) {
                DP[n][green] = Math.min(Paint_cost(n-1, red), Paint_cost(n-1, blue)) + cost[n][green];
            } else {
                DP[n][blue] = Math.min(Paint_cost(n-1, red), Paint_cost(n-1, green)) + cost[n][blue];
            }
        }

        return DP[n][color];
    }
}
