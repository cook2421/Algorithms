package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터_큐_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());

        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            int docCnt = Integer.parseInt(st.nextToken());
            int myDocIdx = Integer.parseInt(st.nextToken());

             List<Integer> orderByPriority = new ArrayList<>();
             Queue<Integer> printQueue = new LinkedList<>();
             Queue<Boolean> myDocQueue = new LinkedList<>();
             st = new StringTokenizer(br.readLine());
             for(int j=0; j<docCnt; j++){
                 int priority = Integer.parseInt(st.nextToken());
                 printQueue.add(priority);
                 orderByPriority.add(priority);
                 if(j == myDocIdx) {
                     myDocQueue.add(true);
                 } else {
                     myDocQueue.add(false);
                 }
             }

             orderByPriority.sort(Collections.reverseOrder());

             List<Boolean> result = new ArrayList<>();
             for(int n : orderByPriority){
                while(printQueue.peek() != n){
                    printQueue.add(printQueue.poll());
                    myDocQueue.add(myDocQueue.poll());
                }
                printQueue.poll();
                result.add(myDocQueue.poll());
             }

             System.out.println(result.indexOf(true)+1);
        }
    }
}
