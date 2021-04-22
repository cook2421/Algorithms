package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 괄호_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());

        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            String[] arrStr = st.nextToken().split("");

            int isVps = 0;

            for(String str : arrStr){
                if(isVps < 0) break;
                switch (str){
                    case "(" : isVps++; break;
                    case ")" : isVps--; break;
                }
            }

            if(isVps == 0){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}