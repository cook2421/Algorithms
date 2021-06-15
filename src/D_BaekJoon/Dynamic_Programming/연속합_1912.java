package D_BaekJoon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int max = 0;
        int tempSum = 0;
        int temp = Integer.parseInt(st.nextToken());
        max = tempSum = temp;

        for(int i=1; i<cnt; i++){
            temp = Integer.parseInt(st.nextToken());

            if(tempSum+temp < 0){
                if(tempSum >= 0) {
                    tempSum = 0;
                    continue;
                }
                if(temp >= max) {
                    tempSum = 0;
                }
            }
            if(tempSum+temp >= 0 || temp >= max){
                tempSum += temp;
            }
            if(tempSum > max){
                max = tempSum;
            }
        }

        System.out.println(max);
    }
}
