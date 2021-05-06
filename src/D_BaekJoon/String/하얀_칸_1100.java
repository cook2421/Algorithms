package D_BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하얀_칸_1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;

        for(int i=1; i<=8; i++){
            st = new StringTokenizer(br.readLine());
            char[] c = st.nextToken().toCharArray();
            boolean oddWhite = (i%2 == 1);

            for(int j=0; j<8; j++){
                if(c[j] == 'F'){
                    if((j+1)%2 == 1 && oddWhite){
                        sum++;
                    } else if((j+1)%2 == 0 && !oddWhite){
                        sum++;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
