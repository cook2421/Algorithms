package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덱_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());
        Deque_10866 deque = new Deque_10866();

        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order) {
                case "push_front" : deque.push_front(Integer.parseInt(st.nextToken())); break;
                case "push_back" : deque.push_back(Integer.parseInt(st.nextToken())); break;
                case "pop_front" : System.out.println(deque.pop_front()); break;
                case "pop_back" : System.out.println(deque.pop_back()); break;
                case "front" : System.out.println(deque.front()); break;
                case "back" : System.out.println(deque.back()); break;
                case "size" : System.out.println(deque.size()); break;
                case "empty" : System.out.println(deque.empty()); break;
            }
        }
    }
}

class Deque_10866 {
    class Node {
        private int value;
        private Node l_link;
        private Node r_link;
    }


    private Node front;
    private Node rear;
    private int size;

    public Deque_10866(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void push_front(int n) {
        Node newNode = new Node();
        newNode.value = n;

        if(empty() == 1){
            front = newNode;
            rear = newNode;
            newNode.l_link = null;
            newNode.r_link = null;
        } else {
            front.l_link = newNode;
            newNode.r_link = front;
            newNode.l_link = null;
            front = newNode;
        }

        size++;
    }

    public void push_back(int n) {
        Node newNode = new Node();
        newNode.value = n;

        if(empty() == 1){
            front = newNode;
            rear = newNode;
            newNode.l_link = null;
            newNode.r_link = null;
        } else {
            rear.r_link = newNode;
            newNode.r_link = null;
            newNode.l_link = rear;
            rear = newNode;
        }

        size++;
    }

    public int pop_front() {
        if(empty() == 1) return -1;
        int result = front.value;
        if(size() == 1) {
            this.front = null;
            this.rear = null;
        } else {
            front = front.r_link;
            front.l_link = null;
        }
        size--;
        return result;
    }

    public int pop_back() {
        if(empty() == 1) return -1;
        int result = rear.value;
        if(size() == 1) {
            this.front = null;
            this.rear = null;
        } else {
            rear = rear.l_link;
            rear.r_link = null;
        }
        size--;
        return result;
    }

    public int front() {
        return size() == 0 ? -1 : this.front.value;
    }

    public int back() {
        return size() == 0 ? -1 : this.rear.value;
    }

    public int size() {
        return this.size;
    }

    public int empty() {
        return this.size == 0 ? 1 : 0;
    }
}