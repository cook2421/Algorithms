package D_BaekJoon.String;

import java.util.ArrayList;
import java.util.Scanner;

public class 알파벳_찾기_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArr = sc.nextLine().toCharArray();
        ArrayList<Character> charList = new ArrayList<>();
        for(Character c : charArr){
            charList.add(c);
        }

        for(int i=97; i<=122; i++){
            System.out.print(charList.indexOf((char)i));
            if(i<122) System.out.print(" ");
        }
    }
}

/*
아스키코드
97 = a;
122 = z;
*/
