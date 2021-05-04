package D_BaekJoon.String;

import java.util.Scanner;

public class 더하기_사이클_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int loop = 1;
        int operNum = operation(num);
        while(operNum != num){
            operNum = operation(operNum);
            loop++;
        }
        System.out.println(loop);
    }

    public static int operation(int num){
        int share = num/10;
        int remainder = num%10;

        return remainder*10 + (share+remainder)%10;
    }
}
