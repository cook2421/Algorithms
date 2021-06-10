package D_BaekJoon.Dynamic_Programming;

import java.util.Scanner;

public class 숫자_1로_만들기_1463_재귀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] DP = new int[n+1];
        DP[0] = DP[1] = 0;

        for(int i=2; i<=n; i++){
            DP[i] = DP[i-1]+1;
            if(i%2 == 0) DP[i] = Math.min(DP[i], DP[i/2]+1);
            if(i%3 == 0) DP[i] = Math.min(DP[i], DP[i/3]+1);
        }
        System.out.println(DP[n]);
    }
}
