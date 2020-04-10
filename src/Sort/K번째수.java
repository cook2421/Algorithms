package Sort;
// https://programmers.co.kr/learn/courses/30/lessons/42748?language=java

public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        int[] result = solution(array, commands);
        if (result == new int[]{5,6,3}) {
            System.out.println("성공!!");
        } else {
            System.out.println("실패!!");
        }
    }


    public static int[] solution(int[] array, int[][] commands){
        int[] answer = {};




        return answer;
    }
}