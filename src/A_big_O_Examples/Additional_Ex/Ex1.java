package A_big_O_Examples.Additional_Ex;

public class Ex1 {
    int product(int a, int b){
        int sum = 0;
        for(int i=0; i<b; i++){
            sum += a;
        }
        return sum;
    }
}

// 내 답안: O(n) or O(b)
// 실 답안: