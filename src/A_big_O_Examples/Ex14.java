package big_O_Examples;

public class Ex14 {

    void allFib(int n){
        for(int i=0; i<n; i++){
            System.out.println(i + ": " + fib(i));
        }
    }

    int fib(int n){
        if(n <= 0) return 0;
        else if(n==1) return 1;
        return fib(n-1) + fib(n-2);
    }
}

/*

O(n * 2^n) 아니다.

n이 변하기 때문이다.
물론 fib(n)은 O(2^n)이 걸리지만 n번의 호출이 모두
다른 n을 사용하므로 이를 반영해서 계산하는 것이 중요하다.

2^1 + 2^2 + 2^3 + 2^4 + ... + 2^n
즉, 2^n+1
여전히 O(2^n)이다.

*/