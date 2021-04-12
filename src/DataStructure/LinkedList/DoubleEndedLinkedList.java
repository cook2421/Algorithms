package DataStructure.LinkedList;

public class DoubleEndedLinkedList {

    private class Header {
        private Node nextNode;
        private Node lastNode;

        Header(){
            nextNode = null;
            lastNode = null;
        }
    }

    private class Node {
        private Object data;
        private Node nextNode;

        Node(Object data){
            this.data = data;
            this.nextNode = null;
        }
    }


    private Header header;
    private int size;


    public DoubleEndedLinkedList(){
        header = new Header();
        size = 0;
    }


    // index번째 노드의 데이터를 반환한다.
    public Object get(int index){
        return getNode(index).data;
    }


    // 첫번째 노드의 데이터를 반환한다.
    public Object getFirst(){
        return get(0);
    }


    // index번째의 노드를 반환한다.
    private Node getNode(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : "+index+", Size : "+size);
        }

        Node node = header.nextNode;

        for(int i=0; i<index; i++){
            node = node.nextNode;
        }

        return node;
    }


    // 해당 데이터의 노드 위치 index를 반환한다.
    public int getNodeIndex(Object obj){
        if(size <= 0){
            return -1;
        }

        int index = 0;
        Node node = header.nextNode;
        Object nodeData = node.data;

        // header에서부터 순차적으로 nodeData와 값을 비교한다.
        while(!obj.equals(nodeData)){
            node = node.nextNode;

            if(node == null){
                return -1;
            }

            nodeData = node.data;

            index++;
        }

        return index;
    }


    // 리스트의 첫번째에 data를 삽입한다.
    public void addFirst(Object data){
        Node newNode = new Node(data);
        newNode.nextNode = header.nextNode;
        header.nextNode = newNode;
        size++;

        if(newNode.nextNode == null){
            header.lastNode = newNode;
        }
    }


    // 리스트의 마지막에 data를 삽입한다.
    public void addLast(Object data){
        if(header.lastNode == null){
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            header.lastNode.nextNode = newNode;
            header.lastNode = newNode;
            size++;
        }
    }


    // index의 위치에 data를 삽입한다.
    public void add(int index, Object data){
        if(index == 0){
            addFirst(data);
            return;
        } else if(index == size){
            addLast(data);
        } else {
            Node previous = getNode(index-1);
            Node next = previous.nextNode;
            Node newNode = new Node(data);
            previous.nextNode = newNode;
            newNode.nextNode = next;
            size++;
        }
    }


    // data를 리스트의 마지막에 삽입한다.
    public void add(Object data){
        addLast(data);
    }


    // 리스트의 첫번째 노드를 제거하고 데이터를 반환한다.
    public Object removeFirst(){
        Node firstNode = getNode(0);
        header.nextNode = firstNode.nextNode;
        size--;

        // 헤더의 다음 노드가 null이면, 리스트가 비어있다.
        // lastNode도 null로 변경
        if(header.nextNode == null){
            header.lastNode = null;
        }

        return firstNode.data;
    }


    // index 위치의 노드를 제거하고 데이터를 반환한다.
    public Object remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : "+index+", Size : "+size);
        } else if(index == 0){
            return removeFirst();
        }

        Node previous = getNode(index-1);
        Node removeNode = previous.nextNode;
        Node next = removeNode.nextNode;
        previous.nextNode = next;
        size--;

        if(previous.nextNode == null){
            header.lastNode = previous;
        }

        return removeNode.data;
    }


    // data가 있는 노드를 제거한다.
    public boolean remove(Object data){
        int nodeIndex = getNodeIndex(data);

        if(nodeIndex == -1){
            return false;
        } else {
            remove(nodeIndex);
            return true;
        }
    }


    // 리스트의 마지막 노드를 제거하고 데이터를 반환한다.
    public Object removeLast(){
        return remove(size-1);
    }


    // 리스트의 크기를 반환한다.
    public int size(){
        return size;
    }


    // 리스트의 데이터 String으로 반환
    public String toString(){
        StringBuffer result = new StringBuffer("[");
        Node node = header.nextNode;

        if(node != null){
            result.append(node.data);
            node = node.nextNode;

            while(node != null){
                result.append(", ");
                result.append(node.data);
                node = node.nextNode;
            }
        }

        result.append("]");

        return result.toString();
    }







    public static void main(String[] args){

        DoubleEndedLinkedList list = new DoubleEndedLinkedList();

        list.add(100);
        list.add(200);
        list.add(400);
        list.add(500);
        System.out.println(list);

        list.add(2, 300);
        list.addFirst(50);
        System.out.println(list);

        System.out.println(list.get(4));

        list.remove(2);
        list.remove(new Integer(400));
        System.out.println(list);

        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        System.out.println("크기 " + list.size());

    }
}
