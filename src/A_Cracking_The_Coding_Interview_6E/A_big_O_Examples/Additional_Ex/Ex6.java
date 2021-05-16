package A_Cracking_The_Coding_Interview_6E.A_big_O_Examples.Additional_Ex;

/**
 * 만약 완전제곱이 아니라면 -1을 반환해야 한다.
 * 완전제곱근인지 아닌지 확인하기 위해 숫자를 하나씩 증가시켜가면서 현재 숫자가 정답인지 아니면 정답을 넘어갔는지 확인한다.
* */
public class Ex6 {
    int sqrt(int n){
        for(int guess=1; guess*guess <= n; guess++){
            if(guess*guess == n){
                return guess;
            }
        }
        return -1;
    }
}

// 내 답안: O(sqrt n)
// 실 답안:
