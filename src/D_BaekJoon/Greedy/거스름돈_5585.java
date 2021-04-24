package D_BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거스름돈_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int change = 1000 - Integer.parseInt(st.nextToken());
        int[] coins = {500, 100, 50, 10, 5, 1};

        int result = 0;

        for(int i=0; i<coins.length; i++){
            result += change/coins[i];
            change %= coins[i];
        }

        System.out.println(result);
    }
}
