package D_BaekJoon.공개_카테고리.쉬운_문제들_총집합;

import java.util.Scanner;

public class 윤년_2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        if(year%4==0 && (year%100!=0 || year%400==0)){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
