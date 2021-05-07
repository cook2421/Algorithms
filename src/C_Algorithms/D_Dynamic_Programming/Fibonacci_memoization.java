package C_Algorithms.D_Dynamic_Programming;

public class Fibonacci_memoization {

    int memo[] = new int[100];

    int fibonacci(int n){
        if(n <= 1){
            return n;
        } else {
            if(memo[n] > 0) {       // memo의 값이 0이 아니면
                return memo[n];     // 그 값을 그대로 사용
            }
            memo[n] = fibonacci(n-1) * fibonacci(n-2);
            return memo[n];
        }
    }
}
