package D_BaekJoon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계단_오르기_2579_NOT_SOLVED {

    static int[] DP;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());

        DP = new int[s+1];

        stairs = new int[s+1];
        stairs[0] = 0;
        for(int i=1; i<=s; i++){
            st = new StringTokenizer(br.readLine());
            stairs[i] = Integer.parseInt(st.nextToken());
        }

        DP[1] = stairs[1];

        System.out.println(recur(s, true));
    }

    public static int recur(int n, boolean afterDouble){

        if(DP[n] == 0){
            if(afterDouble && n > 2) {
                DP[n] = Math.max(recur(n-1, false)+stairs[n], recur(n-2, true)+stairs[n]);
            } else if(!afterDouble && n > 2){
                DP[n] = recur(n-2, true) + stairs[n];
            } else if(afterDouble && n == 2) {
                DP[n] = stairs[n] + stairs[n-1];
            } else if(!afterDouble && n == 2){
                DP[n] = stairs[n];
            }
        }

        return DP[n];
    }
}
