package D_BaekJoon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_1_2_3_더하기_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        int[] DP = new int[12];
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(recur(n, DP));
        }
    }

    public static int recur(int n, int[] DP){
        if(DP[n] > 0) return DP[n];

        DP[n] = recur(n-1, DP) + recur(n-2, DP) + recur(n-3, DP);

        return DP[n];
    }
}
