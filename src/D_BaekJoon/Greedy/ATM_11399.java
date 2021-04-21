package D_BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int timeCount = Integer.parseInt(st.nextToken());
        int[] times = new int[timeCount];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<times.length; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        int sum = 0;
        int result = 0;
        for(int i=0; i<times.length; i++){
            sum += times[i];
            result += sum;
        }

        System.out.println(result);
    }
}
