package D_BaekJoon.String;

import java.util.Scanner;

public class KMP는_왜_KMP일까_2902 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = sc.nextLine().split("-");

        StringBuilder sb = new StringBuilder();

        for(String n : names){
            sb.append(n.substring(0,1));
        }

        System.out.println(sb);
    }
}
