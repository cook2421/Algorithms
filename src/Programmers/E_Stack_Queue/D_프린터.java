package Programmers.E_Stack_Queue;
// https://programmers.co.kr/learn/courses/30/lessons/42587?language=java

import java.util.*;

public class D_프린터 {
    public static void main(String[] args) {
        int[] priorities = {2, 4, 2, 5, 2};
        int location = 1;

        int result = solution(priorities, location);
        System.out.println(result);
    }

    public static int solution(int[] priorities, int location) {

        List<Integer> id = new ArrayList();
        List<Integer> priCopy = new ArrayList();
        List<Integer> priOrder = new ArrayList();

        for(int i=0; i<priorities.length; i++){
            id.add(i);
            priCopy.add(priorities[i]);
        }

        Arrays.sort(priorities);

        for(int i=priorities.length-1; i>=0; i--){
            if(priOrder.size() == 0 || priOrder.get(priOrder.size()-1) != priorities[i]) priOrder.add(priorities[i]);
        }

        int myDoc = id.get(location);

        for(int i=0; i<priOrder.size()-1; i++){
            int endIdx = priCopy.indexOf(priOrder.get(i));
            priCopy = arrayTransposition(priCopy, i, endIdx);
            id = arrayTransposition(id, i, endIdx);
        }

        return id.indexOf(myDoc);
    }

    public static List arrayTransposition(List arr, int startIdx, int endIdx){
        if(arr.size() == 0) return arr;

        List latterPart = arr.subList(endIdx, arr.size());
        List formerPart = arr.subList(startIdx, endIdx);

        latterPart.addAll(formerPart);

        return latterPart;
    }
}

/* 미해결!! */