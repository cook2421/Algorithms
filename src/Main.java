import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static Deque<Integer> a = new LinkedList<>();
    static Deque<Integer> b = new LinkedList<>();
    static Deque<Integer> c = new LinkedList<>();
    static ArrayList<StringBuilder> trail = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int plates = sc.nextInt();

        for (int i = plates; i >= 1; i--) {
            a.addLast(i);
        }

        movePlates(a, c, b, plates);
        System.out.println(trail.size());
        for(StringBuilder sb : trail){
            System.out.println(sb);
        }
    }


    public static void movePlates(Deque<Integer> from, Deque<Integer> to, Deque<Integer> add, int plates){
        if(plates == 1){
            to.push(from.pollLast());
            printFromTo(from, to);
        } else {
            int btm = from.pollFirst();
            movePlates(from, add, to, plates-1);
            to.push(btm);
            printFromTo(from, to);
            movePlates(add, to, from, plates-1);
        }
    }


    public static void printFromTo(Deque<Integer> from, Deque<Integer> to){
        StringBuilder sb = new StringBuilder();
        sb.append(getPlatNum(from));
        sb.append(" ");
        sb.append(getPlatNum(to));
        trail.add(sb);
    }


    public static int getPlatNum(Deque<Integer> platform){
        if(platform == a){
            return 1;
        } else if(platform == b){
            return 2;
        } else {
            return 3;
        }
    }
}