package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회전하는_큐_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int queSize = Integer.parseInt(st.nextToken());
        int pickCnt = Integer.parseInt(st.nextToken());

        Deque_1021 deque = new Deque_1021();

        for(int i=1; i<=queSize; i++){
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int movingCnt = 0;
        for(int i=0; i<pickCnt; i++){
            int pickNum = Integer.parseInt(st.nextToken());
            int bwdOrder = findOrder(deque, pickNum) - 1;
            int frntOrder = deque.size - bwdOrder;

            if(bwdOrder < frntOrder) {
                deque.rotateLeft(bwdOrder);
                deque.pollFront();
                movingCnt += bwdOrder;
            } else {
                deque.rotateRight(frntOrder);
                deque.pollFront();
                movingCnt += frntOrder;
            }
        }

        System.out.println(movingCnt);
    }

    public static int findOrder(Deque_1021 deque, int n){
        int times = 1;
        Node node = deque.front;
        while(node.value != n){
            node = node.r_link;
            times++;
        }
        return times;
    }
}

class Node {
    int value;
    Node r_link;
    Node l_link;
}

class Deque_1021 {

    Node front;
    Node rear;
    int size;

    public Deque_1021() {
        this.front = new Node();
        this.rear = new Node();
        this.size = 0;
    }

    public void add(int num){
        Node newNode = new Node();
        newNode.value = num;
        if(size == 0) {
            front = newNode;
        } else if(size == 1){
            front.r_link = newNode;
            rear = newNode;
            rear.l_link = front;
        } else {
            rear.r_link = newNode;
            newNode.l_link = rear;
            rear = newNode;
        }

        size ++;
    }

    public int pollFront(){
        if(size == 0) return 0;
        Node res = front;
        front = front.r_link;
        size--;
        return res.value;
    }

    public int pollRear(){
        if(size == 0) return 0;
        Node res = rear;
        rear = rear.l_link;
        size--;
        return res.value;
    }

    public int rotateLeft(int n){
        if(size == 0 || size == 1) return 0;
        for(int i=0; i<n; i++) {
            Node newRear = new Node();
            newRear.value = pollFront();
            rear.r_link = newRear;
            newRear.l_link = rear;
            rear = newRear;
            size++;
        }
        return 1;
    }

    public int rotateRight(int n){
        if(size == 0 || size == 1) return 0;
        for(int i=0; i<n; i++) {
            Node newFront = new Node();
            newFront.value = pollRear();
            front.l_link = newFront;
            newFront.r_link = front;
            front = newFront;
            size++;
        }

        return 1;
    }
}