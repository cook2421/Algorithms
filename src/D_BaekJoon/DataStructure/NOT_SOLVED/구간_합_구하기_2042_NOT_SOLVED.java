package D_BaekJoon.DataStructure.NOT_SOLVED;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기_2042_NOT_SOLVED {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCnt = Integer.parseInt(st.nextToken());
        int chgCnt = Integer.parseInt(st.nextToken());
        int sumCnt = Integer.parseInt(st.nextToken());

        int[] numArr = new int[numCnt+1];

        for(int i=1; i<=numCnt; i++){
            st = new StringTokenizer(br.readLine());
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<chgCnt+sumCnt; i++){
            st = new StringTokenizer(br.readLine());
            int chgOrSum = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(chgOrSum == 1){
                numArr[b] = c;
            } else {
                int sum = sum(b, c, numArr);
                System.out.println(sum);
            }
        }
    }

    public static int sum(int str, int end, int[] numArr){
        int sum = 0;

        for(int i=str; i<=end; i++){
            sum += numArr[i];
        }

        return sum;
    }
}
