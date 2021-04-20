package big_O_Examples;

public class Ex16 {

    int powersOf2(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powersOf2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }
}

/*
1과 n을 포함하여 그 사이에 있는 모든 2의 승수(powers of 2)를 출력하는 함수이다.
예를 들어 n이 4일 때 이 함수는 1, 2, 4를 출력한다.

[[[ 1. 함수가 어떻게 동작하는가? ]]]
powersOf2(50)
    → powersOf2(25)
        → powersOf2(12)
            → powersOf2(6)
                → powersOf2(3)
                    → powersOf2(1)
                        print & return 1
                    print & return 2
                print & return 4
            print & return 8
        print & return 16
    print & return 32

수행 시간은 50이 기본값(1)이 될 때까지 2로 나누는 횟수가 된다.
1이 될 때까지 n을 절반씩 나누는 함수의 수행 시간은 O(logN)과 같다.

[[[ 2. 무엇을 의미하는가 ]]]
수행 시간을 구할 때 해당 코드의 목적이 무엇인지 생각해보는 방법이 있다.
powersOf2를 한 번 호출할 때마다 재귀 호출 안에서 일어나는 일은 제외하고는
정확히 숫자 하나를 출력하고 반환한다.
따라서 최종적으로 숫자 13개가 출력됐다면 powersOf2 함수는 13번 호출됐다는 뜻이다.
1과 n 사이에는 2의 승수가 logN개 존재하므로 수행 시간은 O(logN)이 된다.

[[[ 3. 수행 시간 증가 속도 ]]]
수행 시간을 구하는 마지막 방법은 n이 커질수록 수행 시간이 어떻게 바뀌는지 생각해보는 것이다.
결국 이것이 big-O 시간이 의미하는 바와 정확히 일치하는 것이다.
n이 P에서 P+1이 됐을 때 powersOf2 함수의 호출 횟수는 전혀 바뀌지 않을 수 있다.
n의 크기가 두 배가 될 때 호출 횟수가 한 번 증가한다.
powersOf2의 호출 횟수는 n이 될 때까지 숫자 1을 두 배로 증가시킨 횟수와 같게 된다.
즉 2^x=n에서 x와 같다. x=logN이 된다.
따라서 수행 시간은 O(logN)이 된다.

*/