package E_Programmers.D_Exhaustive_Search;
// https://programmers.co.kr/learn/courses/30/lessons/42842?language=java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c_카펫 {
    public static void main(String[] args) {
        int[] result = solution(18, 12);

        System.out.println(Arrays.toString(result));
    }


    public static int[] solution(int brown, int red){
        int[] answer = {};

        List<Integer[]> temp = new ArrayList<>();

        for(int i=1; i<=red; i++){
            if(red%i == 0) {
                Integer[] a = {i+2, red/i+2};
                temp.add(a);
            }
        }

        for(int i=temp.size()-1; i>=0; i--){
            if(brown/2 == temp.get(i)[0] + temp.get(i)[1] - 4){
                answer = Arrays.stream(temp.get(i)).mapToInt(Integer::intValue).toArray();
                break;
            } else if(brown/2 == temp.get(i)[0] + temp.get(i)[1] - 2){
                answer = Arrays.stream(temp.get(i)).mapToInt(Integer::intValue).toArray();
                break;
            }
        }

        return answer;
    }
}


/*

<다른 사람 답변>

for(int i=1; i<=red; i++) {
    if(red%i==0 && (red/i+i)*2+4==brown) {
        return new int[] {red/i+2, i+2};
    }
}
return null;

*/
