package Programmers.A_Hash;
//https://programmers.co.kr/learn/courses/30/lessons/42576?language=java

import java.util.*;

public class A_완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String result = solution(participant, completion);

        System.out.println(result);
    }


    public static String solution(String[] participant, String[] completion){
        HashMap<String, Integer> map = new HashMap<>();

        for(String p : participant){
            if(map.get(p) == null){
                map.put(p, 1);
            } else {
                map.put(p, map.get(p)+1);
            }
        }

        for(String c : completion){
            map.put(c, map.get(c) - 1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return "";
    }
}


/*
    HashMap<String, Integer> hm = new HashMap<>();

    for(String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
    for(String player : completion) hm.put(player, hm.get(player) - 1);

    for(String key : hm.keySet()){
        if(hm.get(key) != 0) answer = key;
    }
*/
