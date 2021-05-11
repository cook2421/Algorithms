package D_BaekJoon.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리_순회_1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());

        Map<String, 이진_트리.Node> map = new HashMap<>();

        이진_트리 tree = new 이진_트리();
        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            if(map.get(root) != null){
                tree.createChild(map.get(root), left, right);
            } else {
                map.put(root, tree.createNode(root, left, right));
            }
            map.put(left, map.get(root).left);
            map.put(right, map.get(root).right);
        }

        tree.preOrder(tree.getRoot());
        System.out.println();
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.postOrder(tree.getRoot());
    }
}

class 이진_트리 {
    class Node {
        String value;
        Node left;
        Node right;

        public Node(String value){
            this.value = value;
        }
    }

    private Node root;

    public void setRoot(Node node){
        this.root = node;
    }

    public Node getRoot(){
        return root;
    }

    public Node createNode(String value, String leftValue, String rightValue){

        Node node = new Node(value);
        if (!leftValue.equals(".")) node.left = new Node(leftValue);
        if (!rightValue.equals(".")) node.right = new Node(rightValue);
        if(root == null) setRoot(node);

        return node;
    }

    public Node createChild(Node node, String leftValue, String rightValue){
        if (!leftValue.equals(".")) node.left = new Node(leftValue);
        if (!rightValue.equals(".")) node.right = new Node(rightValue);

        return node;
    }


    public void preOrder(Node node){
        if(node != null){
            System.out.print(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.value);
            inOrder(node.right);
        }
    }

    public void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value);
        }
    }
}
