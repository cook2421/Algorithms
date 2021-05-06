package D_BaekJoon.공개_카테고리.쉬운_문제들_총집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오븐_시계_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        m += t;
        if(m >= 60){
            h += (m/60);
            m %= 60;
        }

        while(h >= 24){
            h -= 24;
        }

        System.out.print(h);
        System.out.print(" ");
        System.out.print(m);
    }
}
