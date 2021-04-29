package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class AC_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());

        for(int i=0; i<loop; i++){
            String order = new StringTokenizer(br.readLine()).nextToken();
            int arrLength = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            String arr = new StringTokenizer(br.readLine()).nextToken();
            Deque<Integer> deque = new ArrayDeque<>();

            boolean isError = false;
            char firstOrLast = 'F';

            arr = arr.substring(1, arr.length()-1);
            String[] str = arr.split(",");
            for(String s : str){
                if(!s.equals("")) deque.add(Integer.parseInt(s));
            }

            str = order.split("");
            for(String s : str){
                if(s.equals("R")){
                    firstOrLast = firstOrLast == 'F' ? 'L' : 'F';
                } else {
                    if(deque.size() == 0){
                        isError = true;
                        break;
                    } else {
                        if(firstOrLast == 'F'){
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                    }
                }
            }

            if(isError){
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                for(int j=0; deque.size()!=0 && j<deque.size();){
                    if(firstOrLast == 'F'){
                        sb.append(deque.pollFirst());
                    } else {
                        sb.append(deque.pollLast());
                    }
                    if(deque.size() != 0){
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
