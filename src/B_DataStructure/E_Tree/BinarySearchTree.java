package B_DataStructure.E_Tree;

public class BinarySearchTree {

    class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value){
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    Node rootNode = null;

    /**
    * 1. 추가
    * */
    public void insertNode(int element){
        if(rootNode == null){
            rootNode = new Node(element);
        } else {
            Node head = rootNode;
            Node currentNode;

            while(true){
                currentNode = head;

                // 현재의 루트보다 작은 경우, 왼쪽으로 탐색을 한다.
                if(head.value > element) {
                    head = head.leftChild;

                    if(head == null){
                        currentNode.leftChild = new Node(element);
                        break;
                    }
                } else {
                // 현재의 루트보다 큰 경우, 오른쪽으로 탐색을 한다.
                    head = head.rightChild;

                    if(head == null){
                        currentNode.rightChild = new Node(element);
                        break;
                    }
                }
            }
        }
    }


    /**
     * 2. 삭제
     * */
    public boolean removeNode(int element){

        Node removeNode = rootNode;
        Node parentOfRemoveNode = null;

        while(removeNode.value != element){
            parentOfRemoveNode = removeNode;

            // 삭제할 값이 현재 노드보다 작으면 왼쪽을 탐색한다.
            if(removeNode.value > element){
                removeNode = removeNode.leftChild;
            } else {
                removeNode = removeNode.rightChild;
            }

            // 값 대소를 비교하며 탐색했을 때
            // 잎 노드(leaf node)인 경우 삭제를 위한 탐색 실패
            if(removeNode == null) return false;
        }

        // 자식 노드가 모두 없을 때
        if (removeNode.leftChild == null && removeNode.rightChild == null) {
            if(removeNode == rootNode){
                rootNode = null;
            } else if(removeNode == parentOfRemoveNode.rightChild){
                parentOfRemoveNode.rightChild = null;
            } else {
                parentOfRemoveNode.leftChild = null;
            }
        // 오른쪽 자식 노드만 존재하는 경우
        } else if(removeNode.leftChild == null){
            if(removeNode == rootNode){
                rootNode = removeNode.rightChild;
            } else if(removeNode == parentOfRemoveNode.rightChild){
                parentOfRemoveNode.rightChild = removeNode.rightChild;
            } else {
                parentOfRemoveNode.leftChild = removeNode.rightChild;
            }
        // 왼쪽 자식 노드만 존재하는 경우
        } else if(removeNode.rightChild == null){
            if(removeNode == rootNode){
                rootNode = removeNode.leftChild;
            } else if(removeNode == parentOfRemoveNode.rightChild){
                parentOfRemoveNode.rightChild = removeNode.leftChild;
            } else {
                parentOfRemoveNode.leftChild = removeNode.leftChild;
            }
        // 두 개의 자식 노드가 존재하는 경우
            // 1. 삭제할 노드의 왼쪽 서브 트리에 있는 가장 큰 값 노드를 올린다.
            // 2. 오른쪽 서브 트리에 있는 가장 작은 값 노드를 올린다.
        // 여기서는 2번을 사용
        } else {
            Node parentOfReplaceNode = removeNode;

            Node replaceNode = parentOfReplaceNode.rightChild;

            while(replaceNode.leftChild != null){
                parentOfReplaceNode = replaceNode;
                replaceNode = replaceNode.leftChild;
            }

            if(replaceNode != removeNode.rightChild){
                parentOfReplaceNode.leftChild = replaceNode.rightChild;

                replaceNode.rightChild = removeNode.rightChild;
            }

            if(removeNode == rootNode){
                rootNode = replaceNode;
            } else if(removeNode == parentOfRemoveNode.rightChild){
                parentOfRemoveNode.rightChild = replaceNode;
            } else {
                parentOfRemoveNode.leftChild = replaceNode;
            }

            replaceNode.leftChild = removeNode.leftChild;
        }

        return true;
    }


    /**
    * 중위 순회
    * */
    public void inOrderTree(Node root, int depth){
        if(root != null){
            inOrderTree(root.leftChild, depth+1);
            for(int i=0; i<depth; i++){
                System.out.print("ㄴ");
            }
            System.out.println(root.value);
            inOrderTree(root.rightChild, depth+1);
        }
    }

    /**
     * 후위 순회
     * */
    public void postOrderTree(Node root, int depth){
        if(root != null){
            postOrderTree(root.leftChild, depth+1);
            postOrderTree(root.rightChild, depth+1);
            for(int i=0; i<depth; i++){
                System.out.print("ㄴ");
            }
            System.out.println(root.value);
        }
    }

    /**
     * 전위 순회
     * */
    public void preOrderTree(Node root, int depth){
        if(root != null){
            for(int i=0; i<depth; i++){
                System.out.print("ㄴ");
            }
            System.out.println(root.value);
            preOrderTree(root.leftChild, depth+1);
            preOrderTree(root.rightChild, depth+1);
        }
    }
}



class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertNode(5);
        tree.insertNode(8);
        tree.insertNode(7);
        tree.insertNode(10);
        tree.insertNode(9);
        tree.insertNode(11);

        if(tree.removeNode(10)){
            System.out.println("노드 삭제");
        }

        // tree.inOrderTree(tree.rootNode, 0);
        // tree.postOrderTree(tree.rootNode, 0);
        tree.preOrderTree(tree.rootNode, 0);
    }
}
