package Programmers.Hash;
// https://programmers.co.kr/learn/courses/30/lessons/42578?language=java

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class C_위장 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution(clothes);
        System.out.println(result);
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for(String[] items : clothes){
            String itemClass = items[items.length-1];
            if(map.get(itemClass) == null){
                map.put(itemClass, 1);
            } else {
                map.put(itemClass, map.get(itemClass)+1);
            }
        }

        Iterator<String> itr = map.keySet().iterator();
        while(itr.hasNext()){
            answer *= (map.get(itr.next())+1);
        }

        return answer - 1;
    }
}
