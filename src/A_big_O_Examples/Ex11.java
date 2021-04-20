package A_big_O_Examples;

public class Ex11 {

    int factorial(int n){
        if(n < 0){
            return -1;
        } else if(n == 0){
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

/*
다음은 n의 계승(factorial) n!을 구하는 코드이다.
시간복잡도는 어떻게 되는가?

단순히 n부터 1까지 반복하는 재귀 함수이므로 O(n)이 된다.
*/