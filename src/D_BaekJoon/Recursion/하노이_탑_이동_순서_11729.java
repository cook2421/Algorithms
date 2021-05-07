package D_BaekJoon.Recursion;

import java.util.Scanner;
import java.util.Stack;

public class 하노이_탑_이동_순서_11729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int plates = sc.nextInt();

        Stack<Integer> plat_a = new Stack<>();
        Stack<Integer> plat_b = new Stack<>();
        Stack<Integer> plat_c = new Stack<>();

        for(int i=plates; i>=1; i--){
            plat_a.push(i);
        }
    }

    public static void moveOddNumPlate(Stack<Integer> from, Stack<Integer> to, Stack<Integer> additional){
        if(from.peek() == 1){
            to.push(from.pop());
        }

    }

    public static void moveEvenNumPlate(Stack<Integer> from, Stack<Integer> to, Stack<Integer> additional){
        if (from.peek() == 2) {
            to.push(from.pop());
            to.push(additional.pop());
        } else {

        }
    }
}
