package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 키로거_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCnt = Integer.parseInt(st.nextToken());

        for(int i=0; i<testCnt; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
            }
        }
    }

    public void input(String str) {

    }
}

class Word {
    String value;
    Word next;
}

class Password {

    Word front;
    Word rear;
    Word cursor;
    int size;

    public Password(){
        front = new Word();
        rear = new Word();
        cursor = new Word();
        size = 0;
    }

    public void add(String s){
        Word newWord = new Word();
        newWord.value = s;

        if(size == 0) {
            front = newWord;
            cursor = front;
        } else if(size == 1) {
            if(cursor == null){
                rear = front;
                front = newWord;
                front.next = rear;
                cursor = front;
            } else {
                rear = newWord;
                front.next = rear;
                cursor = rear;
            }
        } else {

        }
        size++;
    }

    public void delete(Word cursor){

    }

    public void moveLeft(){
        if(size == 0) {
            return;
        } else if(size == 1){

        } else {

        }
    }

    public void moveRight(){
        if(size == 0) {
            return;
        } else if(size == 1){

        } else {

        }
    }
}