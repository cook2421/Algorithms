package D_BaekJoon.String;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class 단어_공부_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toUpperCase();
        char[] charArr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(Character c : charArr){
            if(map.get(c) != null){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        int maxCnt = 0;
        char answer = 0;
        boolean isTie = false;

        Iterator<Character> iter = map.keySet().iterator();
        while(iter.hasNext()){
            char key = iter.next();
            int cnt = map.get(key);

            if(cnt > maxCnt){
                answer = key;
                maxCnt = cnt;
                isTie = false;
            } else if(cnt == maxCnt){
                isTie = true;
            }
        }
        if(isTie){
            System.out.println("?");
        } else {
            System.out.println(answer);
        }
    }
}
