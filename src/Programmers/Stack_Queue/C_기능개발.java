package Programmers.Stack_Queue;
// https://programmers.co.kr/learn/courses/30/lessons/42586?language=java

import java.util.LinkedList;
import java.util.Queue;

public class C_기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] result = solution(progresses, speeds);
        for(int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        int[] answer = {};

        Queue days = new LinkedList();
        Queue result = new LinkedList();

        for(int i=0; i<progresses.length; i++){
            days.add((int)Math.ceil((100 - progresses[i]) / speeds[i]));
        }

        int res = 1;
        int workingDay = (int)days.poll();
        while(!days.isEmpty()){
            if(workingDay > (int)days.peek()){
                res++;
            } else {
                workingDay = (int)days.peek();
                res = 1;
                result.add(res);
            }
            days.poll();
        }

        answer = new int[result.size()];
        int idx = 0;
        while(!result.isEmpty()){
            answer[idx] = (int)result.poll();
            idx++;
        }

        return answer;
    }
}
