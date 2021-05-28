package D_BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실_배정_1931_NOT_SOLVED {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] conf = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                conf[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(conf, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]){
                    return -1;
                } else if(o1[1] == o2[1]){
                    if(o1[0] < o2[0]){
                        return -1;
                    }
                }
                return 0;
            }
        });

        int result = 0;
        int finalIdx = 0;
        int endTime = 0;
        boolean finish = false;

        while(!finish) {
            for (int i = finalIdx; i < n; i++) {
                if(i == n-1) finish = true;
                if (endTime <= conf[i][0]) {
                    finalIdx = i+1;
                    endTime = conf[i][1];
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
