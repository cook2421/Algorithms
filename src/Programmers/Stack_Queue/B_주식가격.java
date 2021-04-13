package Programmers.Stack_Queue;
// https://programmers.co.kr/learn/courses/30/lessons/42584?language=java

public class B_주식가격 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] result = solution(prices);
        for(int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[i] > prices[j] || j == prices.length-1){
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }
}
