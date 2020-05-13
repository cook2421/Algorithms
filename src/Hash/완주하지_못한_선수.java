package Hash;
//https://programmers.co.kr/learn/courses/30/lessons/42576?language=java

import java.util.*;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String result = solution(participant, completion);

        System.out.println(result);
    }


    public static String solution(String[] participant, String[] completion){
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<completion.length; i++){
            if(participant[i] != completion[i]){
                answer = participant[i];
                break;
            }
        }

        return answer;
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
