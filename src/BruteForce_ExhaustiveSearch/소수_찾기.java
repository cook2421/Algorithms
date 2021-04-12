package BruteForce_ExhaustiveSearch;
// https://programmers.co.kr/learn/courses/30/lessons/42839?language=java

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {
    public static void main(String[] args) {

        int result = solution("1725140");

        System.out.println(result);
    }


    public static int solution(String numbers){
        int answer = 0;

        String[] integers = numbers.split("");
        Set<Integer> candidates = new HashSet<>();
        Set<Integer> primeNumbers = new HashSet<>();

        for(int i=0; i<integers.length; i++){
            if(Integer.parseInt(integers[i]) == 2){
                candidates.add(Integer.parseInt(integers[i]));
            }
            if(Integer.parseInt(integers[i])/2 != 0 && Integer.parseInt(integers[i]) != 5){

            }
        }

        return answer;
    }
}
