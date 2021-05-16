package A_Cracking_The_Coding_Interview_6E.A_big_O_Examples.Additional_Ex;

public class Ex3 {
    int mod(int a, int b){
        if(b <= 0){
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }
}

// 내 답안: O(1)
// 실 답안: