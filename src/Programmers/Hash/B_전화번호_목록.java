package Programmers.Hash;
//https://programmers.co.kr/learn/courses/30/lessons/42577?language=java

import java.util.Arrays;

public class B_전화번호_목록 {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean result = solution(phone_book);
        System.out.println(result);
    }

    public static boolean solution(String[] phone_book){
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}
