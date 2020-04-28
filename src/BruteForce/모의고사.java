package BruteForce;
// https://programmers.co.kr/learn/courses/30/lessons/42840?language=java

import java.util.*;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};

        int[] result = solution(answers);

        System.out.println(result.toString());
    }


    public static int[] solution(int[] answers){
        int[] answer;
        int[][] arr = {{1, 0}, {2, 0}, {3, 0}};
        
        for(int i=1; i<=answers.length; i++){
            int temp = answers[i-1];
            int a = i%5, b = i%8, c = i%10;

            switch (temp){
                case 1 : if(a == 1) arr[0][1]++;
                         if(b == 2) arr[1][1]++;
                         if(c == 3 || c == 4) arr[2][1]++;
                         break;
                case 2 : if(a == 2) arr[0][1]++;
                         if(i%2 == 1) arr[1][1]++;
                         if(c == 5 || c == 6) arr[2][1]++;
                         break;
                case 3 : if(a == 3) arr[0][1]++;
                         if(b == 4) arr[1][1]++;
                         if(c == 1 || c == 2) arr[2][1]++;
                         break;
                case 4 : if(a == 4) arr[0][1]++;
                         if(b == 6) arr[1][1]++;
                         if(c == 7 || c == 8) arr[2][1]++;
                         break;
                case 5 : if(a == 0) arr[0][1]++;
                         if(b == 0) arr[1][1]++;
                         if(c == 9 || c == 0) arr[2][1]++;
                         break;
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]){
                    return -1;
                } else if(o1[1] <= o2[1]){
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int count = 0;
        for(int[] i : arr){
            if(i[1] != 0){
                count++;
            }
        }

        answer = new int[count];

        for(int i=0; i<count; i++){
            answer[i] = arr[i][0];
        }


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
