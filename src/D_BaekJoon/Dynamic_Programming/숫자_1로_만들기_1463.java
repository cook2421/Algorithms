package D_BaekJoon.Dynamic_Programming;

import java.util.Scanner;

public class 숫자_1로_만들기_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;

        while(n > 3){
            while(n%3 != 0 && n%2 != 0){
                n -= 1;
                cnt++;
            }
            if(n%3 == 0){
                n /= 3;
            } else {
                n /= 2;
            }
            cnt++;
        }

        if(n == 3){
            cnt++;
        } else if(n == 2){
            cnt++;
        }

        System.out.println(cnt);
    }
}
