package D_BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OX퀴즈_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());

        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            String[] ansArr = st.nextToken().split("");
            int seq = 0;
            int sum = 0;
            for(String answer : ansArr){
                if(answer.equals("O")){
                    ++seq;
                    sum += seq;
                } else {
                    seq = 0;
                }
            }
            System.out.println(sum);
        }
    }
}
