package Sort;
// https://programmers.co.kr/learn/courses/30/lessons/42746?language=java

import java.util.*;

public class 가장_큰_수 {
    public static void main(String[] args) {
        int[] numbers0 = {3, 30, 34, 5, 9};
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

        String result = solution(numbers0);

        System.out.println(result);
    }


    public static String solution(int[] numbers){
        String answer = "";

        //int 배열을 String 배열로 변환
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = (String.valueOf(numbers[i]));
        }

        //배열 정렬, 정렬 규칙으로는 2개를 더하여 더 큰 쪽이 우선순위가 있도록 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });

        //0000 처럼 0으로만 구성되어있으면 0 return
        if (arr[0].equals("0")) return "0";

        //그 외의 경우 순차적으로 연결하여 answer return
        for (int i = 0; i < arr.length; i++) {
            answer+=arr[i];
        }

        return answer;
    }
}
