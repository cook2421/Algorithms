package A_big_O_Examples.Additional_Ex;

/**
 *  제곱근이 자연수가 아닐 때 완전제곱(perfect squares)이 아니라면 -1을 반환해야 한다.
 *  완전제곱근인지 아닌지 확인하기 위해 다음과 같은 유추 방식을 이용한다.
 *  n이 100이라면 먼저 50을 의심해본다.
 *  50이 너무 크다면 그보다 작은 숫자로 시도해 본다.
 *  이와 같은 방식으로 1부터 50 사이의 숫자를 절반씩 시도해본다.
* */
public class Ex5 {
    int sqrt(int n){
        return sqrt_helper(n, 1, n);
    }
    int sqrt_helper(int n, int min, int max){
        if(max < min) return -1;    // 제곱근이 없다.

        int guess = (min + max) / 2;

        if(guess * guess == n) { // 찾았다!!
            return guess;
        } else if(guess * guess < n) {
            return sqrt_helper(n, guess+1, max);    // 더 큰 값으로 시도
        } else {    // 너무 크다.
            return sqrt_helper(n, min, guess-1);    // 더 작은 값으로 시도
        }
    }
}

// 내 답안: O(logN)
// 실 답안: