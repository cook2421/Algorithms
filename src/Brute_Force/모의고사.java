package Brute_Force;
// https://programmers.co.kr/learn/courses/30/lessons/42840?language=java

import java.util.*;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};

        int[] result = solution(answers);

        System.out.println(result.toString());
    }


    public static int[] solution(int[] answers){
        int[] result = new int[3];
        int a = 0, b = 0, c = 0;

        for(int i=1; i<=answers.length; i++){
            int answer = answers[i-1];

            switch (answer){
                case 1 : if(i%5 == 1) a++;
                         if(i%8 == 2) b++;
                         if(i%10 == 3 || i%10 == 4) c++;
                         break;
                case 2 : if(i%5 == 2) a++;
                         if(i%2 == 1) b++;
                         if(i%10 == 5 || i%10 == 6) c++;
                         break;
                case 3 : if(i%5 == 3) a++;
                         if(i%8 == 4) b++;
                         if(i%10 == 1 || i%10 == 2) c++;
                         break;
                case 4 : if(i%5 == 4) a++;
                         if(i%8 == 6) b++;
                         if(i%10 == 7 || i%10 == 8) c++;
                         break;
                case 5 : if(i%5 == 0) a++;
                         if(i%8 == 0) b++;
                         if(i%10 == 9 || i%10 == 0) c++;
                         break;
            }
        }

        int[] temp = {a,b,c};



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
