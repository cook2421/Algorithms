package A_Cracking_The_Coding_Interview_6E.A_big_O_Examples.Additional_Ex;

public class Ex4 {
    int div(int a, int b){
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }
}

// 내 답안: O(n) or O(a)
// 실 답안: