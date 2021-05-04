package D_BaekJoon.String;

import java.util.Scanner;

public class 단어의_개수_1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();
        int words = 0;

        if(!str.equals("")){
            String[] strArr = str.split(" ");
            words = strArr.length;
        }

        System.out.println(words);
    }
}
