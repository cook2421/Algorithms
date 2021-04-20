package B_DataStructure.B_List.LinkedList;

class Node {
    private String data;
    public Node link;

    /* 생성자 */
    public Node(){
        this.data = null;
        this.link = null;
    }

    public Node(String data){
        this.data = data;
    }

    public Node(String data, Node link){
        this.data = data;
        this.link = link;
    }

    /* 조회 */
    public String getData(){
        return this.data;
    }
}


/**
* 원형 연결 리스트
* */
public class CircularLinkedList {

    private Node head;

    public CircularLinkedList() {
        this.head = null;
    }

    public void printList(){
        if(head == null){
            System.out.println("길이가 0인 리스트");
            return;
        }
        Node temp = head;

        // 길이가 1인 리스트
        if(temp.link != temp){
            while(temp.link != head){
                temp = temp.link;
            }
        }
    }

    public void FirstNodeInsert(String data){

        Node insertNode = new Node(data);

        if(this.head == null){
            head = insertNode;
            insertNode.link = insertNode;
        } else {
            Node temp = head;
            insertNode.link = head;

            while(temp.link != head){
                temp = temp.link;
            }

            temp.link = insertNode;
            head = insertNode;
        }
    }

    public void middleNodeInsert(String data, Node pre){

        Node insertNode = new Node(data);

        // head is null
        if(head == null){
            head = insertNode;
            insertNode.link = insertNode;
        } else {
            Node temp = head;

            // middle node insert
            while(temp.link != head){
                if(pre == temp){
                    insertNode.link = pre.link;
                    pre.link = insertNode;
                    return;
                } else {
                    temp = temp.link;
                }
            }

            // last node insert
            if(temp == pre){
                insertNode.link = pre.link;
                pre.link = insertNode;
                return;
            } else {
                // not exist node
                System.out.println("pre 노드가 존재하지 않습니다.");
            }
        }
    }

    public void deleteNode(Node deleteNode){

        Node temp = head;

        // FirstList Del
        if(temp == deleteNode){
            Node headNode = head;
            head = headNode.link;
            while(temp.link != headNode){
                temp = temp.link;
            }
            temp.link = head;
        } else {
            // MiddleList Del
            Node preNode = temp;
            while(temp.link != head){
                if(temp.link == deleteNode){
                    temp.link = deleteNode.link;
                    deleteNode.link = null;
                    return;
                } else {
                    preNode = temp;
                    temp = temp.link;
                }
            }

            if(temp == deleteNode){
                // LastList Del
                preNode.link = head;
                deleteNode.link = null;
            } else {
                // Not Exist Node
                System.out.println("해당 노드가 없음");
                return;
            }
        }
    }

    public Node searchNode(String data){

        Node searchNode = new Node();
        searchNode = head;

        // middleNode Insert
        while(searchNode.link != head){
            if(searchNode.getData().equals(data)){
                return searchNode;
            } else {
                searchNode = searchNode.link;
            }
        }

        // lastNode Insert
        if(searchNode.getData().equals(data)){
            return searchNode;
        } else {
            // Not Exist Node
            System.out.println("찾는 데이터 없음");
            return null;
        }
    }

    public void reverseList(){
        Node pre = null;
        Node current = null;
        Node next = head;
        Node headNode = head;

        if (next.link == head) {
            System.out.println("리스트의 길이가 1입니다. reverse할 길이가 안됩니다.");
            return;
        } else if(head == null){
            System.out.println("리스트의 길이가 0입니다. reverse할 길이가 안됩니다.");
            return;
        }

        while (next.link != head) {
            pre = current;
            current = next;
            next = next.link;
            current.link = pre;
        }

        // head setting
        pre = current;
        current = next;
        current.link = pre;
        headNode.link = current;
        head = current;
    }


}
