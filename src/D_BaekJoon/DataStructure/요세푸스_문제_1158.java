package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요세푸스_문제_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temp = new int[n];
        Queue_1158 que = new Queue_1158();

        for(int i=1; i<=n; i++){
            que.push(i);
        }

        int idx = 0;
        while(!que.isEmpty()){
            temp[idx] = que.nthPoll(k);
            idx++;
        }

        String result = "<";
        for(int i=0; i<temp.length; i++){
            result += temp[i];
            if(i<temp.length-1){
                result += ", ";
            }
        }
        result += ">";

        System.out.println(result);
    }
}


class Queue_1158 {
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

    public Queue_1158(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void push(int n){
        if(isEmpty()){
            front = new Node(n);
            rear = new Node(n);
            front.nextNode = rear;
            rear.nextNode = front;
        } else {
            Node node = new Node(n);
            rear.nextNode = node;
            rear = node;
            rear.nextNode = front;
            if(size() == 1){
                front.nextNode = node;
            }
        }
        size++;
    }

    public int pollNextNode(Node node) {
        Node resultNode = node.nextNode;
        node.nextNode = resultNode.nextNode;

        rear = node;
        front = node.nextNode;

        size--;
        return resultNode.value;
    }

    public int nthPoll(int n){
        Node node = front;
        if(n == 1){
            node = rear;
        } else {
            for(int i=1; i<n-1; i++){
                node = node.nextNode;
            }
        }
        return pollNextNode(node);
    }

    public boolean isEmpty(){
        return this.size == 0 ? true : false;
    }

    public int size(){
        return this.size;
    }
}


/*
* 반례1 : 1 1
* 반례2 : 3 2
* 반례3 : 10 1
*/