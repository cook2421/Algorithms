package D_BaekJoon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열_11053 {

    static List<Integer> DP;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int leng = Integer.parseInt(st.nextToken());

        nums = new int[leng];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<leng; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        DP = new ArrayList<>();
        DP.add(nums[0]);

        for(int i=1; i<leng; i++){
            int n = DP.size();
            while(n-1 >= 0 && DP.get(n-1) >= nums[i]) {
                n--;
            }
            if(DP.size() > n){
                DP.set(n, Math.min(DP.get(n), nums[i]));
            } else {
                DP.add(nums[i]);
            }
        }

        System.out.println(DP.size());
    }
}
