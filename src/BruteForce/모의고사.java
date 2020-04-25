package BruteForce;
// https://programmers.co.kr/learn/courses/30/lessons/42840?language=java

import java.util.*;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};

        int[] result = solution(answers);

        System.out.println(result.toString());
    }


    public static int[] solution(int[] answers){
        int[] result = new int[3];


        for(int i=1; i<=answers.length; i++){
            int answer = answers[i-1];

        }

        return result;
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
