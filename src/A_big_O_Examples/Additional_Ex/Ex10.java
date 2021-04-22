package A_big_O_Examples.Additional_Ex;

public class Ex10 {
    int sumDigits(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}

// 내 답안:
// 실 답안: