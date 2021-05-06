package D_BaekJoon.공개_카테고리.쉬운_문제들_총집합;

import java.util.Scanner;

public class 초콜릿_자르기_2163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println((m-1)*n + (n-1));
    }
}
