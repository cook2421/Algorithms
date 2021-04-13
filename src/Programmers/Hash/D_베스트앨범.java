package Programmers.Hash;
// https://programmers.co.kr/learn/courses/30/lessons/42579?language=java

import java.util.*;

public class D_베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plays);
        for(int i : result){
            System.out.println(i);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genre = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<genres.length; i++){
            if(!genre.containsKey(genres[i])){
                genre.put(genres[i], plays[i]);
            } else {
                genre.put(genres[i], genre.get(genres[i])+plays[i]);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(genre.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        for(int i=0; i<list.size(); i++){
            Map<Integer, Integer> song = new HashMap<>();
            for(int j=0; j<genres.length; j++){
                if(list.get(i).getKey().equals(genres[j])){
                    song.put(j, plays[j]);
                }
            }
            List<Map.Entry<Integer, Integer>> list2 = new ArrayList<>(song.entrySet());
            list2.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            for(int j=0; j<list2.size() && j<2; j++){
                res.add(list2.get(j).getKey());
            }
        }

        int[] answer = new int[res.size()];

        for(int i=0; i<res.size(); i++){
            answer[i] = res.get(i);
        }

        return answer;
    }
}
