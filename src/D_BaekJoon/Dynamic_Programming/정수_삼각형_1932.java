package D_BaekJoon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수_삼각형_1932 {

    static Integer[][] tri;
    static Integer[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        tri = new Integer[size][size];
        DP = new Integer[size][size];

        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DP[0][0] = tri[0][0];

        Integer[] res = new Integer[size];
        for(int i=0; i<size; i++){
            res[i] = recur(size-1, i);
        }
        Arrays.sort(res);

        System.out.println(res[size-1]);
    }

    public static int recur(int row, int idx){
        if(row == 0) return DP[0][0];

        if(DP[row][idx] == null){
            int temp = 0;
            if(idx != 0 && idx != row) {
                temp = Math.max(recur(row-1, idx-1), recur(row-1, idx)) + tri[row][idx];
            } else if(idx == 0){
                temp = recur(row-1, idx) + tri[row][idx];
            } else if(idx == row){
                temp = recur(row-1, idx-1) + tri[row][idx];
            }
            DP[row][idx] = temp;
        }

        return DP[row][idx];
    }
}
