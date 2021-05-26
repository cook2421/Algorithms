package D_BaekJoon.Graph_Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 안전_영역_2468 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[][] map = new int[size][size];
        int highest = 0;
        int lowest = 0;

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                int h = sc.nextInt();
                if(h < lowest || lowest == 0) lowest = h;
                if(h > highest) highest = h;
                map[i][j] = h;
            }
        }

        List<Integer> lands = new ArrayList<>();
        for(int wl=lowest-1; wl<=highest+1; wl++){
            int res = 0;
            boolean[][] visited = new boolean[size][size];

            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    if(map[i][j]>wl && !visited[i][j]) {
                        visitSafeArea(i, j, map, visited, wl);
                        res++;
                    }
                }
            }

            lands.add(res);
        }

        Collections.sort(lands, Collections.reverseOrder());

        System.out.println(lands.get(0));
    }

    public static void visitSafeArea(int h, int w, int[][] map, boolean[][] visited, int wl){
        visited[h][w] = true;
        int row = map.length-1;
        int col = map[0].length-1;

        if(w+1<=col && map[h][w+1]>wl && !visited[h][w+1]) visitSafeArea(h, w+1, map, visited, wl);
        if(h+1<=row && map[h+1][w]>wl && !visited[h+1][w]) visitSafeArea(h+1, w, map, visited, wl);
        if(0<=w-1 && map[h][w-1]>wl && !visited[h][w-1]) visitSafeArea(h, w-1, map, visited, wl);
        if(0<=h-1 && map[h-1][w]>wl && !visited[h-1][w]) visitSafeArea(h-1, w, map, visited, wl);
    }
}
