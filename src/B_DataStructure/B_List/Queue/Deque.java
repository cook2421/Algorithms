package B_DataStructure.B_List.Queue;

/**
 * Deque(덱 혹은 데크)은 Double-Ended-Queue의 줄임말
 *
 * 큐의 양쪽으로 엘리먼트의 삽입과 삭제를 수행할 수 있는 자료구조
 *
 * 어떤 쪽으로 입력하고 어떤 쪽으로 출력하느냐에 따라서
 * Stack으로 사용할 수도 있고, Queue로도 사용할 수 있다.
 *
 * scroll : 한쪽으로만 입력 가능하도록 설정한 덱
 * shelf : 한쪽으로만 출력 가능하도록 설정한 덱
 *
* */
class Node {
    char data;
    Node r_link;
    Node l_link;
}

public class Deque {

    Node front;
    Node rear;


    /**
     * 1. 생성자
    * */
    public Deque(){
        front = null;
        rear = null;
    }


    /**
     * 2. 조회
     * */
    public boolean isEmpty(){
        return (front == null);
    }

    public char peekFront(){
        if(isEmpty()){
            System.out.println("Front Peeking fail! Deque is empty!!");
            return 0;
        } else {
            return front.data;
        }
    }

    public char peekRear(){
        if(isEmpty()){
            System.out.println("Rear Peeking fail! Deque is empty!!");
            return 0;
        } else {
            return rear.data;
        }
    }


    /**
     * 3. 추가
     * */
    public void insertFront(char item){
        Node newNode = new Node();
        newNode.data = item;
        if(isEmpty()){
            front = newNode;
            rear = newNode;
            newNode.r_link = null;
            newNode.l_link = null;
        } else {
            front.l_link = newNode;
            newNode.r_link = front;
            newNode.l_link = null;
            front = newNode;
        }
    }

    public void insertRear(char item){
        Node newNode = new Node();
        newNode.data = item;
        if(isEmpty()){
            front = newNode;
            rear = newNode;
            newNode.r_link = null;
            newNode.l_link = null;
        } else {
            rear.r_link = newNode;
            newNode.r_link = null;
            newNode.l_link = rear;
            rear = newNode;
        }
    }


    /**
     * 4. 삭제
     * */
    public char deleteFront(){
        if(isEmpty()){
            System.out.println("Front Deleting fail! Deque is empty!!");
            return 0;
        } else {
            char item = front.data;
            if(front.r_link == null){
                front = null;
                rear = null;
            } else {
                front = front.r_link;
                front.l_link = null;
            }
            return item;
        }
    }

    public char deleteRear(){
        if(isEmpty()){
            System.out.println("Rear Deleting fail! Deque is empty!!");
            return 0;
        } else {
            char item = rear.data;
            if(rear.l_link == null){
                front = null;
                rear = null;
            } else {
                rear = rear.l_link;
                rear.r_link = null;
            }
            return item;
        }
    }


    /**
     * 5. 출력
     * */
    public void printDeque(){
        if(isEmpty()){
            System.out.printf("Deque is empty!! %n %n");
        } else {
            Node temp = front;
            System.out.printf("Deque>> ");
            while(temp != null){
                System.out.printf("%c ", temp.data);
                temp = temp.r_link;
            }
            System.out.println();   System.out.println();
        }
    }
}


class Main{
    public static void main(String[] args) {
        char deletedItem;
        Deque dq = new Deque();

        dq.insertFront('A');
        dq.printDeque();

        dq.insertFront('B');
        dq.printDeque();

        dq.insertRear('C');
        dq.printDeque();

        deletedItem = dq.deleteFront();
        if(deletedItem != 0) System.out.println("Front deleted Item : " + deletedItem);
        dq.printDeque();

        deletedItem = dq.deleteRear();
        if(deletedItem != 0) System.out.println("Rear deleted Item : " + deletedItem);
        dq.printDeque();

        dq.insertRear('D');
        dq.printDeque();

        dq.insertFront('E');
        dq.printDeque();

        dq.insertFront('F');
        dq.printDeque();
    }
}