package D_BaekJoon.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 소트인사이드_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strArr = sc.nextLine().split("");

        Arrays.sort(strArr, Collections.reverseOrder());

        for(String s : strArr){
            System.out.print(s);
        }
    }
}
