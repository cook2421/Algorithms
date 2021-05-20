package A_Cracking_The_Coding_Interview_6E.A_big_O_Examples;

public class Ex10 {

    boolean isPrime(int n){
        for(int x=2; x * x <= n; x++){
            if(n % x == 0){
                return false;
            }
        }
        return true;
    }

    /*
    현재의 값보다 작은 수들로 나누어 떨어지는지 확인함으로써 현재의 값이 소수인지 아닌지 판별하는 함수이다.
    이때 현재의 값보다 작은 수 전체를 이용할 필요는 없고 n의 제곱근까지만 확인해 보면 된다.
    만약 제곱근보다 큰 수로 나누어 떨어지는 경우가 존재한다면, 그에 상응하는 제곱근보다 작은 수로도 나누어 떨어지기 때문이다.

    예를 들어 33은 33의 제곱근보다 큰 11로 나누어 떨어짐과 동시에 그에 상응하는 3(3*11=33)으로도 나누어 떨어진다.
    33은 3으로 나누어 떨어지므로 진작에 소수가 되질 못했을 것이다.

    이 함수의 시간 복잡도는 어떻게 되겠는가?

    많은 사람들이 이 문제를 틀린다.
    하지만 논리 전개하는 데 주의를 기울인다면 꽤 쉽게 풀 수 있다.
    for 루프의 내부 코드는 상수 시간에 동작한다.
    따라서 최악의 경우에 for 루프가 몇 번 반복하는지만 세어보면 시간 복잡도를 구할 수 있다.

    시간복잡도는 O(루트N)이 된다.
    */
}