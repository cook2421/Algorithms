package D_BaekJoon.Dynamic_Programming;

import java.util.Scanner;

public class 피보나치_수_5_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n > 1) {
            int[] DP = new int[n + 1];
            DP[1] = 1;
            if (n > 0) DP[2] = 1;

            for (int i = 2; i<=n; i++){
                DP[i] = DP[i-1] + DP[i-2];
            }

            System.out.println(DP[n]);
        } else {
            if(n == 0) System.out.println(0);
            if(n == 1) System.out.println(1);
        }
    }
}
