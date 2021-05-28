package D_BaekJoon.Greedy;

import java.util.Scanner;

public class 설탕_배달_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = -1;

        int temp = n;
        for(int i=n/5; i>=0; i--){
            temp -= (5 * i);
            if(temp%3 != 0) {
                temp = n;
            } else {
                result += ((temp/3) + i + 1);
                break;
            }
        }

        System.out.println(result);
    }
}