package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_수열_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());

        List<String> result = new ArrayList<>();
        boolean isPass = true;

        Stack<Integer> stk = new Stack();
        int strIdx = 1;

        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            int targetNum = Integer.parseInt(st.nextToken());

            if(stk.isEmpty() || stk.peek() < targetNum){
                for (int j = strIdx; j <= targetNum; j++) {
                    stk.push(j);
                    result.add("+");
                }
                strIdx = stk.pop() + 1;
                result.add("-");
            } else if(stk.peek() == targetNum){
                stk.pop();
                result.add("-");
            } else {
                isPass = false;
                break;
            }
        }

        if(isPass){
            for(String s : result){
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }
    }
}
