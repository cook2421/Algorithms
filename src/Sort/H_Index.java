package Sort;

// https://programmers.co.kr/learn/courses/30/lessons/42747

import java.util.Arrays;
import java.util.Collections;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int[] citations1 = {6, 6, 6, 6, 6, 6};
        int[] citations2 = {2, 2, 2};
        int[] citations3 = {4,3,3,1,1,1,1,0};
        int[] citations4 = {4,3,3,3,3};
        int[] citations5 = {42,22};
        int[] citations6 = {5,5,5,5};
        int[] citations7 = {42,22,0};
        int[] citations8 = {10, 100};
        int[] citations9 = {7,6,4,1,1,0};

        int result = solution(citations9);

        System.out.println(result);
    }


    public static int solution(int[] citations){
        int answer = 0;

        int sum = 0;
        Integer[] temp = new Integer[citations.length];
        for(int i=0; i<citations.length; i++) {
            temp[i] = citations[i];
            sum += citations[i];
        }

        Arrays.sort(temp, Collections.reverseOrder());

        for(int i=0; i<temp.length; i++){
            if(temp.length >= sum/temp.length && temp[i] == i+1) {
                return temp[i];
            } else if(temp.length >= sum/temp.length && temp[i] < i+1) {
                return i;
            } else if(temp.length < sum/temp.length && temp[i] < temp.length){
                return i;
            } else if(temp.length < sum/temp.length && temp[temp.length-1] > temp.length){
                return temp.length;
            }
        }

        return answer;
    }
}

