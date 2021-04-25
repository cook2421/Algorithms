package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드2_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=n; i++){
            que.add(i);
        }

        while(que.size() != 1){
            que.poll();
            que.add(que.poll());
        }

        System.out.println(que.peek());

    }
}
