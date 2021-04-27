package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자_카드2_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> cards = new HashMap<>();

        int cardLoop = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cardLoop; i++){
            int card = Integer.parseInt(st.nextToken());
            if(cards.get(card) != null) cards.put(card, cards.get(card)+1);
            else cards.put(card, 1);
        }

        st = new StringTokenizer(br.readLine());
        int candidateCnt = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<candidateCnt; i++){
            int card = Integer.parseInt(st.nextToken());
            int cnt = cards.get(card) == null ? 0 : cards.get(card);
            sb.append(cnt);
            if(i != candidateCnt-1)sb.append(" ");
        }
        System.out.println(sb);
    }
}

/*
System.out.print(cnt);
System.out.print(" ");

-> 시간 초과 남

*/
