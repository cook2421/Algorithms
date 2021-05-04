package D_BaekJoon.String;

import java.util.Scanner;

public class 열_개씩_끊어_출력하기_11721 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int strIdx = 0;
        int endIdx = str.length() < 10 ? str.length() : 10;

        while(strIdx <= str.length()-1){
            System.out.println(str.substring(strIdx, endIdx));
            strIdx += 10;
            if(endIdx+10 > str.length()-1){
                endIdx = str.length();
            } else {
                endIdx += 10;
            }
        }
    }
}
