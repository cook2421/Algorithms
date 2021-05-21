package D_BaekJoon.Recursion;

import java.util.Scanner;

public class Z_1074_NOT_SOLVED {

    static int r;
    static int c;
    static boolean isFound = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        int size = (int)Math.pow(2, n);

        System.out.println(findOrder(1, size, 1, size, 0, size-1));
    }

    public static int findOrder(int order, int size, int h_from, int h_to, int v_from, int v_to){
        int quadSize = size == 2 ? 1 : (int)Math.pow(2, size/2);
        int nextSize = size/2;

        if(size > 1) {
            if (findQuadrant(h_from, h_to-nextSize, v_from, v_to-nextSize)) {
                order = findOrder(order, nextSize, h_from, h_to-nextSize, v_from, v_to-nextSize);
            } else {
                if(!isFound)order += quadSize;
            }

            if (findQuadrant(h_from+nextSize, h_to, v_from, v_to-nextSize)) {
                order = findOrder(order, nextSize, h_from+nextSize, h_to, v_from, v_to-nextSize);
            } else {
                if(!isFound)order += quadSize;
            }

            if (findQuadrant(h_from,h_to-nextSize, v_from+nextSize, v_to)) {
                order = findOrder(order, nextSize, h_from, h_to-nextSize, v_from+nextSize, v_to);
            } else {
                if(!isFound)order += quadSize;
            }

            if (findQuadrant(h_from+nextSize, h_to, v_from+nextSize, v_to)) {
                order = findOrder(order, nextSize, h_from+nextSize, h_to, v_from+nextSize, v_to);
            } else {
                if(!isFound)order += quadSize;
            }
        }

        isFound = true;
        return order;
    }

    public static boolean findQuadrant(int h_from, int h_to, int v_from, int v_to){
        if(h_from<=c && c<=h_to && v_from<=r && r<=v_to) return true;
        return false;
    }
}
