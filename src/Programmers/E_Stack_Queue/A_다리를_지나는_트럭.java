package Programmers.E_Stack_Queue;
// https://programmers.co.kr/learn/courses/30/lessons/42583?language=java

import java.util.LinkedList;
import java.util.Queue;

public class A_다리를_지나는_트럭 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        int result = solution(bridge_length, weight, truck_weights);
        System.out.println(result);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue waiting = new LinkedList();
        Queue crossing = new LinkedList();
        Queue crossed = new LinkedList();

        for (int t : truck_weights) {
            waiting.add(t);
        }

        int time = 0;
        int tempWeight = 0;
        while (crossed.size() != truck_weights.length) {
            if (crossing.size() == bridge_length) {
                tempWeight -= (int) crossing.peek();
                int crsed = (int) crossing.poll();
                if (crsed != 0) crossed.add(crsed);
            }

            if (waiting.size() != 0 && (tempWeight + (int) waiting.peek() <= weight)) {
                tempWeight += (int) waiting.peek();
                crossing.add(waiting.poll());
            } else {
                crossing.add(0);
            }

            time++;
        }

        return time;
    }
}
