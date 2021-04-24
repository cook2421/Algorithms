package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 제로_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());

        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n != 0) {
                stk.push(n);
            } else {
                stk.pop();
            }
        }

        int sum = 0;
        for(int n : stk){
            sum += n;
        }

        System.out.println(sum);
    }
}
