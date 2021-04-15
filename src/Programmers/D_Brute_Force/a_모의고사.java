package Programmers.D_Brute_Force;
// https://programmers.co.kr/learn/courses/30/lessons/42840?language=java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a_모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,3,2,5,4,2,3,1,4,2,4,5,3,2,4,1,4,3,5,5,5,2,1,3,3,3};

        int[] result = solution(answers);

        System.out.println(Arrays.toString(result));
    }


    public static int[] solution(int[] answers){

        int[] supoja1 = {1,2,3,4,5};
        int[] supoja2 = {2,1,2,3,2,4,2,5};
        int[] supoja3 = {3,3,1,1,2,2,4,4,5,5};

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++) list.add(0);

        for(int i=0; i<answers.length; i++){
            if(answers[i] == supoja1[i%5]) list.set(0, list.get(0)+1);
            if(answers[i] == supoja2[i%8]) list.set(1, list.get(1)+1);
            if(answers[i] == supoja3[i%10]) list.set(2, list.get(2)+1);
        }

        int max = Collections.max(list);

        List<Integer> returnList = new ArrayList<>();
        for(int i=0; i<list.size(); i++) if(max == list.get(i)) returnList.add(i+1);

        int[] answer = new int[returnList.size()];
        for(int i=0; i<returnList.size(); i++) answer[i] = returnList.get(i);

        return answer;
    }
}

/*

        선택지	   1	2	3	4	5

        수포자1 : 1   2   3   4   5

        2,1,2,3,2,4,2,5, 2,1,2,3,2,4,2,5, 2,1,2,3,2,4,2,5
        수포자2 : 2,10,18  1,3,5,7,9  4,12,20  6,14,22  8,16,24

        3,3,1,1,2,2,4,4,5,5, 3,3,1,1,2,2,4,4,5,5, 3,3,1,1,2,2,4,4,5,5
        수포자3 : 3,4,13,14,23,24
        5,6,15,16,25,26
        1,2,11,12,21,22
        7,8,17,18,27,28
        9,10,19,20,29,30
*/
