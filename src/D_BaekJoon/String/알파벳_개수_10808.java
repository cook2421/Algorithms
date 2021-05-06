package D_BaekJoon.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 알파벳_개수_10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] word = sc.nextLine().toCharArray();

        Map<Character, Integer> freq = new HashMap<>();

        for(int i=0; i<word.length; i++){
            freq.put(word[i], freq.getOrDefault(word[i], 0)+1);
        }

        for(int i=97; i<=122; i++){
            if(freq.get((char)i) != null){
                System.out.print(freq.get((char)i));
            } else {
                System.out.print(0);
            }
            if(i<122) System.out.print(" ");
        }
    }
}

/*
아스키코드
97 = a;
122 = z;
*/