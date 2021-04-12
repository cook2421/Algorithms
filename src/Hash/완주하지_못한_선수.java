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

        Map<String, Integer> participants = new HashMap<>();

        for(int i=0; i<participant.length; i++){
            if(participants.get(participant[i]) != null){
                participants.put(participant[i], participants.get(participant[i])+1);
            } else {
                participants.put(participant[i], 1);
            }
        }

        for(int i=0; i<completion.length; i++){
            if(participants.get(completion[i]) > 1){
                participants.put(completion[i], participants.get(completion[i])-1);
            } else {
                participants.remove(completion[i]);
            }
        }

        Iterator<String> key = participants.keySet().iterator();
        answer = key.next();

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
