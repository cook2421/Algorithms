package C_Algorithms.D_Dynamic_Programming;

public class Fibonacci_Recursive {
    int fibonacci(int n){
        if(n <= 1) {        // F(0) = 0, F(1) = 1
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}


/*

시간복잡도는 함수의 깊이가 n일때
O(2^n)이다.

*/