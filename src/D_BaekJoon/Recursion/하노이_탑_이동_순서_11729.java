package D_BaekJoon.Recursion;

import java.util.*;

public class 하노이_탑_이동_순서_11729 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int plates = sc.nextInt();

        System.out.println((int)Math.pow(2, plates)-1);
        movePlates("1", "3", "2", plates);
        System.out.println(sb);
    }


    public static void movePlates(String from, String to, String add, int plates){
        if(plates == 1){
            sb.append(from + " " + to + "\n");
        } else {
            movePlates(from, add, to, plates-1);
            sb.append(from + " " + to + "\n");
            movePlates(add, to, from, plates-1);
        }
    }
}
