package D_BaekJoon.Graph_Traversal;

import java.util.*;

public class 영역_구하기_2583 {
    static int col;
    static int row;
    static int sqr;

    static int[][] coord;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        col = sc.nextInt();
        row = sc.nextInt();
        sqr = sc.nextInt();

        coord = new int[row][col];

        for(int i=0; i<sqr; i++){
            int row_s = sc.nextInt();
            int col_s = sc.nextInt();
            int row_e = sc.nextInt()-1;
            int col_e = sc.nextInt()-1;
            for(int j=row_s; j<=row_e; j++){
                for(int z=col_s; z<=col_e; z++){
                    coord[j][z] = 1;
                }
            }
        }

        int[] point = findUnchecked();
        int lands = 0;
        List<Integer> extents = new ArrayList<>();

        while(point!=null){
            extents.add(checkVoidPlaces(point[0], point[1]));
            lands++;
            point = findUnchecked();
        }

        Collections.sort(extents);

        System.out.println(lands);
        for(int i=0; i<extents.size(); i++){
            System.out.print(extents.get(i));
            if(i+1 != extents.size()) System.out.print(" ");
        }
    }

    public static int checkVoidPlaces(int r, int c){
        coord[r][c] = 1;

        int area = 1;

        if(c+1<col && coord[r][c+1]==0) area += checkVoidPlaces(r, c+1);
        if(r+1<row && coord[r+1][c]==0) area += checkVoidPlaces(r+1, c);
        if(0<=c-1 && coord[r][c-1]==0) area += checkVoidPlaces(r, c-1);
        if(0<=r-1 && coord[r-1][c]==0) area += checkVoidPlaces(r-1, c);

        return area;
    }

    public static int[] findUnchecked(){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(coord[i][j]==0){
                    int[] res = new int[2];
                    res[0] = i; res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }
}
