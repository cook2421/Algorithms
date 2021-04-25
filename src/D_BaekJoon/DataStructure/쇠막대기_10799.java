package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 쇠막대기_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] str = st.nextToken().split("");

        Stack<String> stk = new Stack();

        int stickCnt = 0;
        boolean isLaser = false;

        for(int i=0; i<str.length; i++){
            if(str[i].equals(")")){
                if(stk.peek().equals("(") && isLaser) {
                    stk.pop();
                    stickCnt += stk.size();
                    isLaser = false;
                } else {
                    stk.pop();
                    stickCnt += 1;
                }
            } else {
                stk.push("(");
                isLaser = true;
            }
        }
        System.out.println(stickCnt);
    }
}
