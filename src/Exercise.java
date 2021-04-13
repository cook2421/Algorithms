import java.util.LinkedList;
import java.util.Queue;

public class Exercise {
    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] answer = {};

        Queue days = new LinkedList();
        Queue result = new LinkedList();

        for(int i=0; i<progresses.length; i++){
            days.add((int)Math.ceil((100 - progresses[i]) / speeds[i]));
        }

        int workingDay = (int)days.poll();
        while(!days.isEmpty()){
            int res = 1;
            if(workingDay > (int)days.peek()){
                res++;
            }
            days.poll();
            result.add(res);
        }

        answer = new int[result.size()];
        int idx = 0;
        while(!result.isEmpty()){
            answer[idx] = (int)result.poll();
            idx++;
        }

        for(Integer i : answer){
            System.out.println(i);
        }
    }
}

