package D_BaekJoon.Greedy;

import java.util.Scanner;

public class 설탕_배달_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int f = n/5;
        int t = n%5/3;

        int r = n%5%3;

        int f_r = n%5;
        int t_r = n%3;

        if(r == 0){
            System.out.println(f+t);
        } else if(f_r == 0){
            System.out.println(n/5);
        } else if(t_r == 0){
            System.out.println(n/3);
        } else {
            System.out.println(-1);
        }

    }
}

/* 반례: 11 (정답: 3) */
