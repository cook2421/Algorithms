package D_BaekJoon.String;

import java.util.Scanner;

public class 별_찍기_1_2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        for(int i=1; i<=loop; i++){
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
