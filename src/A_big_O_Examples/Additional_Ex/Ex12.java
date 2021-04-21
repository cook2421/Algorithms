package A_big_O_Examples.Additional_Ex;

import static java.util.Arrays.*;

/**
 * 두 배열의 교집합의 개수를 세어주는 코드이다(각 배열에 중복된 값은 없다)
 * 교집합을 구하기 위해 배열 하나(배열 b)를 정렬한 뒤
 * 이진 탐색으로 배열 a를 차례로 살펴보면서 해당 원소가 b에 존재하는지 확인한다.
* */
public class Ex12 {

    int intersection(int[] a, int[] b){
        sort(b);
        int intersect = 0;
        for(int x : a){
            if(binarySearch(b, x) >= 0){
                intersect++;
            }
        }
        return intersect;
    }
}
