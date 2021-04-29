package D_BaekJoon.DataStructure;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 균형잡힌_세상_4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        String str = sc.nextLine();
        while(!str.equals(".")){
            Stack<String> stk = new Stack<>();

            boolean isIndefective = true;
            String[] strArr = str.split("");
            for (String s : strArr) {
                switch (s) {
                    case "(":
                        stk.push("(");
                        break;
                    case "[":
                        stk.push("[");
                        break;
                    case ")":
                        if (stk.size() == 0 || !stk.pop().equals("(")) isIndefective = false;
                        break;
                    case "]":
                        if (stk.size() == 0 || !stk.pop().equals("[")) isIndefective = false;
                        break;
                }
                if(s.equals(".")) {
                    if(stk.size() != 0) isIndefective = false;  // 반례 : ()(.
                    list.add(isIndefective ? "yes" : "no");
                    str = sc.nextLine();
                    break;
                }
            }

        }

        for(String res : list){
            System.out.println(res);
        }
    }
}
