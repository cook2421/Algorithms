package D_BaekJoon.Dynamic_Programming;

import java.util.Scanner;

public class 숫자_2xn_타일링_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] DP = new int[n+1];
        DP[0] = 0;
        DP[1] = 1;
        if(n > 1) DP[2] = 2;

        System.out.println(recur(n, DP));
    }

    public static int recur(int n, int[] DP){
        if(DP[n] > 0) return DP[n];

        DP[n] = (recur(n-1, DP) + recur(n-2, DP))%10007;

        return DP[n];
    }
}
