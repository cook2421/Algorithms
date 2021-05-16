package A_Cracking_The_Coding_Interview_6E.A_big_O_Examples.Additional_Ex;

/**
 * appendToNew는 배열에 새로운 값을 추가할 때마다
 * 더 크기가 큰 배열을 새로 만든 뒤 해당 배열을 반환하는 함수이다.
 * 배열을 복사하는 데 걸리는 시간을 구하시오.
*/
public class Ex9 {
    int[] copyArray(int[] array){
        int[] copy = new int[0];
        for(int value : array){
            copy = appendToNew(copy, value);
        }
        return copy;
    }
    int[] appendToNew(int[] array, int value){
        // copy all elements over to new array
        int[] bigger = new int[array.length+1];
        for(int i=0; i<array.length; i++){
            bigger[i] = array[i];
        }
        // 새로운 원소 추가
        bigger[bigger.length-1] = value;
        return bigger;
    }
}

// 내 답안: O(n^2)
// 실 답안:
