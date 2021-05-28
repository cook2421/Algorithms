package D_BaekJoon.Dynamic_Programming;

import java.util.Scanner;

public class 피보나치_함수_1003 {

    static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            memo = new int[n+1][2];
            fibonacci(n);
            sb.append(memo[n][0]);
            sb.append(" ");
            sb.append(memo[n][1]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int[] fibonacci(int n){
        if(n == 0) {
            memo[n][0] = 1;
            return memo[n];
        } else if(n == 1){
            memo[n][0] = 0;
            memo[n][1] = 1;
            return memo[n];
        } else {
            if(memo[n][0] > 0) return memo[n];
            memo[n][0] = fibonacci(n-2)[0] + fibonacci(n-1)[0];
            memo[n][1] = fibonacci(n-2)[1] + fibonacci(n-1)[1];
        }
        return memo[n];
    }
}
