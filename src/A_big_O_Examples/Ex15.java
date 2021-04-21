package big_O_Examples;

public class Ex15 {

    void allFib(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib(i, memo));
        }
    }

    int fib(int n, int[] memo){
        if(n<=0) return 0;
        else if(n==1) return 1;
        else if(memo[n]>0) return memo[n];

        memo[n] = fib(n-1, memo) + fib(n-2, memo);
        return memo[n];
    }
}

/*

fib(i)를 호출할 때마다 fib(n-1)과 fib(n-2)의 계산은 이미 끝나 있고 그 값은 캐시 배열에 저장되어 있을 것이다.
따라서 단순히 캐시값을 찾아서 더한 뒤 그 결과를 캐시 배열에 다시 저장하고 반환해주기만 하면 된다.
이 일련의 과정은 상수 시간 안에 동작한다. O(N)

메모이제이션(memoization)이라 불리는 이 기술은 지수 시간이 걸리는
재귀 알고리즘을 최적화할 때 쓰는 흔한 방법 중 하나이다.

*/

