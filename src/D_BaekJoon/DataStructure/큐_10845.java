package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큐_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());
        Queue_10845 que = new Queue_10845();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.equals("push")){
                que.push(Integer.parseInt(st.nextToken()));
            } else if(input.equals("pop")){
                sb.append(que.pop());
                sb.append(System.lineSeparator());
            } else if(input.equals("size")){
                sb.append(que.size());
                sb.append(System.lineSeparator());
            } else if(input.equals("empty")){
                sb.append(que.empty());
                sb.append(System.lineSeparator());
            } else if(input.equals("front")){
                sb.append(que.front());
                sb.append(System.lineSeparator());
            } else if(input.equals("back")){
                sb.append(que.back());
                sb.append(System.lineSeparator());
            }
        }

        System.out.println(sb);
    }
}


class Queue_10845 {
    class Node {
        private int value;
        private Node nextNode;

        public Node(int n){
            this.value = n;
            this.nextNode = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public Queue_10845(){
        this.front = null;
        this.rear = null;
        size = 0;
    }

    public void push(int n){
        Node node = new Node(n);
        node.nextNode = null;

        if(empty() == 1){
            rear = node;
            front = node;
        } else {
            rear.nextNode = node;
            rear = node;
        }

        size++;
    }

    public int pop(){
        if(size == 0) return -1;

        int result = front.value;
        front = front.nextNode;
        size--;

        return result;
    }

    public int size(){
        return size;
    }

    public int empty(){
        return size() == 0 ? 1 : 0;
    }

    public int front(){
        if(size() == 0) return -1;
        return front.value;
    }

    public int back(){
        if(size() == 0) return -1;
        return rear.value;
    }
}