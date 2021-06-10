package D_BaekJoon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열_11053 {

    static List<Integer> DP;
    static boolean[] visited;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int leng = Integer.parseInt(st.nextToken());

        nums = new int[leng];
        for(int i=0; i<leng; i++){
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }
        DP = new ArrayList<>();
        visited = new boolean[leng+1];
        DP.add(0);
        DP.add(1);
        visited[0] = visited[1] = true;

    }

    public static int recur(int idx){

        if(!visited[idx]){
            int i = DP.size()-1;
            while(DP.get(i) >= nums[idx]){

            }
        }

        return DP.get(0);
    }
}
