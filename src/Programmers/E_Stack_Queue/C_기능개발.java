package Programmers.E_Stack_Queue;
// https://programmers.co.kr/learn/courses/30/lessons/42586?language=java

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class C_기능개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] result = solution(progresses, speeds);
        for(int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        int[] answer = {};

        Queue days = new LinkedList();
        Stack result = new Stack();

        for(int i=0; i<progresses.length; i++){
            days.add((int)Math.ceil((100 - progresses[i]) / (double)speeds[i]));
        }

        int workingDay = 0;
        while(!days.isEmpty()){
            if(workingDay >= (int)days.peek() && (int)days.peek() != 0){
                int temp = (int)result.pop()+1;
                result.push(temp);
            } else {
                result.push(1);
                workingDay = (int)days.peek();
            }
            days.poll();
        }

        answer = new int[result.size()];
        int idx = result.size()-1;
        while(!result.isEmpty()){
            answer[idx] = (int)result.pop();
            idx--;
        }

        return answer;
    }
}
