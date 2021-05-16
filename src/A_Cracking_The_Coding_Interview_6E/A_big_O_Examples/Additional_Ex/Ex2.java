package A_Cracking_The_Coding_Interview_6E.A_big_O_Examples.Additional_Ex;

public class Ex2 {
    int power(int a, int b){
        if(b < 0){
            return 0;   // 에러
        } else if(b == 0){
            return 1;
        } else {
            return a * power(a, b-1);
        }
    }
}

// 내 답안: O(n) or O(b)
// 실 답안:
