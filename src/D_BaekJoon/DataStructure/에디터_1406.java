package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에디터_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringList strList = new StringList();

        String[] strArr = st.nextToken().split("");
        for(String str : strArr){
            strList.insertLeft(str);
        }

        st = new StringTokenizer(br.readLine());
        int loop = Integer.parseInt(st.nextToken());
        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("P")){
                strList.insertLeft(st.nextToken());
            } else if(order.equals("B")){
                strList.deleteLeft();
            } else if(order.equals("L")){
                strList.moveLeft();
            } else if(order.equals("D")){
                strList.moveRight();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Node_1406 node = strList.front;
        sb.append(node.value);
        for(int i=0; i<strList.size && node.r_link != null; i++){
            if(!node.r_link.value.equals("cursor")){
                sb.append(node.r_link.value);
            }
            node = node.r_link;
        }

        System.out.println(sb);
    }

    
}

class Node_1406 {
    String value = "";
    Node_1406 r_link;
    Node_1406 l_link;
}

class StringList {

    Node_1406 front;
    Node_1406 rear;
    Node_1406 cursor;
    int size;

    public StringList(){
        front = new Node_1406();
        rear = new Node_1406();
        cursor = new Node_1406();
        cursor.value = "cursor";
        rear.r_link = cursor;
        size = 0;
    }

    public void moveLeft(){
        if(cursor.l_link == null) return;
        if(cursor.r_link == null) {
            rear.r_link = null;
            rear.l_link.r_link = cursor;
            cursor.l_link = rear.l_link;
            cursor.r_link = rear;
            rear.l_link = cursor;
        } else {
            cursor.l_link.r_link = cursor.r_link;
            cursor.r_link.l_link = cursor.l_link;
            cursor.r_link = cursor.l_link;
            cursor.l_link = cursor.l_link.l_link;
        }
    }

    public void moveRight(){
        if(cursor.r_link == null) return;
        if(cursor.l_link == null) {
            front.l_link = null;
            front.r_link.l_link = cursor;
            cursor.r_link = front.r_link;
            cursor.l_link = front;
            front.r_link = cursor;
        } else {
            cursor.r_link.l_link = cursor.l_link;
            cursor.l_link.r_link = cursor.r_link;
            cursor.l_link = cursor.r_link;
            cursor.r_link = cursor.r_link.r_link;
        }
    }

    public void insertLeft(String str){
        Node_1406 newNode_1406 = new Node_1406();
        newNode_1406.value = str;

        if(cursor.l_link == null){
            cursor.l_link = newNode_1406;
            newNode_1406.r_link = cursor;
            front = newNode_1406;
            if(size == 0) rear = newNode_1406;
        } else {
            cursor.l_link.r_link = newNode_1406;
            newNode_1406.l_link = cursor.l_link;
            newNode_1406.r_link = cursor;
            cursor.l_link = newNode_1406;
            if(cursor.r_link == null) rear = newNode_1406;
        }

        size++;
    }

    public void deleteLeft(){
        if(cursor.l_link == null) {
            return;
        } else {
            if(cursor.l_link == front){
                cursor.l_link = null;
                front = cursor.r_link;
            } else {
                cursor.l_link.l_link.r_link = cursor;
                cursor.l_link = cursor.l_link.l_link;
                if(cursor.r_link == null) rear = cursor.l_link;
            }

            size--;
        }
    }
}

