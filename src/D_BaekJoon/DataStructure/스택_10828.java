package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스택_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int loop = Integer.parseInt(st.nextToken());
        Stack stk = new Stack();

        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push" : push(stk, Integer.parseInt(st.nextToken())); break;
                case "top" : top(stk); break;
                case "size" : size(stk); break;
                case "empty" : empty(stk); break;
                case "pop" : pop(stk); break;
            }
        }
    }

    static void push(Stack stk, int n){
        stk.push(n);
    }

    static void top(Stack stk){
        System.out.println(stk.top());
    }

    static void size(Stack stk){
        System.out.println(stk.size());
    }

    static void empty(Stack stk){
        System.out.println(stk.empty());
    }

    static void pop(Stack stk){
        System.out.println(stk.pop());
    }



    static class Node {
        Integer value;
        Node nextNode;

        public Node(int item){
            this.value = item;
            this.nextNode = null;
        }
    }


    static class Stack {
        private Node top;
        private int size;

        public Stack(){
            this.top = null;
        }

        public void push(int n){
            Node newNode = new Node(n);
            newNode.nextNode = top;
            top = newNode;
            size++;
        }

        public int pop(){
            if(size() == 0){
                return -1;
            } else {
                int result = top();
                top = top.nextNode;
                size--;
                return result;
            }
        }

        public int size(){
            return this.size;
        }

        public int empty(){
            if(size() == 0) return 1;
            else return 0;
        }

        public int top(){
            if(size() == 0) return -1;

            return top.value;
        }
    }
}
