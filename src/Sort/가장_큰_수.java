package Sort;
// https://programmers.co.kr/learn/courses/30/lessons/42746?language=java

import java.util.*;

public class 가장_큰_수 {
    public static void main(String[] args) {
        int[] numbers1 = {0,0,0,0,0};
        int[] numbers2 = {40, 403};
        int[] numbers3 = {40, 405};
        int[] numbers4 = {40, 404};
        int[] numbers5 = {12, 121};
        int[] numbers6 = {2, 22, 223};
        int[] numbers7 = {21, 212};
        int[] numbers8 = {41, 415};
        int[] numbers9 = {2, 22};
        int[] numbers10 = {70, 0, 0, 0};
        int[] numbers11 = {0, 0, 0, 1000};
        int[] numbers12 = {12, 1213};
        int[] numbers13 = {0, 0, 1000, 0};
        int[] numbers14 = {0, 1000, 0, 0};
        int[] numbers15 = {121, 12};

        String result = solution(numbers4);

        System.out.println(result);
    }


    public static String solution(int[] numbers){
        String answer = "";
        Map<Double, Integer> map = new HashMap<>();
        List<Double> keyList = new ArrayList<>();

        for(int n : numbers){
            if(n < 10){
                map.put((double)n, n);
            } else if(n >= 10 && n < 100){
                double key = n/10 + (double)(n%10 - n/10)/10;
                map.put(key, n);
            } else if(n >= 100 && n < 1000){
                double key = n/100 + (double)(n/10%10 - n/100)/10 + (double)(n%10 - n/100)/100;

                map.put(key, n);
            } else {
                map.put(0.5, 1000);
            }
        }

        keyList.addAll(map.keySet());
        Collections.sort(keyList, Collections.reverseOrder());

        for(double key : keyList){
            answer += map.get(key);
        }

        return answer;
    }
}
