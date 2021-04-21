package big_O_Examples;

public class Ex13 {

    int fib(int n){
        if(n<=0) return 0;
        else if(n==1) return 1;
        return fib(n-1) + fib(n-2);
    }
}

/*

O(분기^깊이)
각 호출마다 분기가 2개 존재하므로 깊이가 N일 때 수행 시간은 O(2^N)이 된다.

좀 더 복잡한 수학적 방법을 사용하면 더 정확한 상한을 찾을 수 있다. O(1.6^N)
정확히 O(2^N)이 되지 않는 이유는 호출이 호출 스택의 밑바닥에서 가끔씩 한 번만
일어나기 떄문이다.
대부분의 트리에서 단말 노드가 많으므로 한 번 호출한 것과 두 번 호출한 것 사이에는
큰 차이가 생긴다.

*/