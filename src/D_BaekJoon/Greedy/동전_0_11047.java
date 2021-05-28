package D_BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_0_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());

        int[] arr = new int[cnt];
        for(int i=0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i=cnt-1; i>=0; i--){
            if(value >= arr[i]){
                result += value/arr[i];
                value = value%arr[i];
            }
        }

        System.out.println(result);
    }
}
