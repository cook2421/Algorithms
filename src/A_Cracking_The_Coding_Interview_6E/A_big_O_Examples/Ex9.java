package A_Cracking_The_Coding_Interview_6E.A_big_O_Examples;

public class Ex9 {

    int sum(Node node){
        if(node == null){
            return 0;
        }
        return sum(node.left) + node.value + sum(node.right);
    }

    /*
    균형 이진 탐색 트리에서 모든 노드의 값을 더하는 간단한 코드이다.
    수행 시간은 어떻게 되겠는가?

    단지 이진 탐색 트리라는 이유로 로그가 들어갈거라 생각하지 말길 바란다!
    우리는 수행 시간을 구하는 두 가지 다른 방법을 살펴볼 것이다.


    [[[ 1. 코드가 무엇을 의미하는가 ]]]
    이 코드는 트리의 각 노드를 한 번씩 방문한 뒤 각 노드에서(재귀 호출 부분은 제외하고) 상수 시간에 해당하는 일을 수행한다.
    따라서, 수행 시간은 노드의 개수와 선형 관계에 있다.
    즉, N개의 노드가 있을 때 수행 시간은 O(N)이 된다.


    [[[ 2. 재귀호출 패턴분석 ]]]
    만약 분기가 두 개 존재한다면 O(2^깊이)가 될 것이다.
    지수 시간 알고리즘으로 표현되긴 했지만, 결과적으로 보면 생각보다 나쁜 알고리즘은 아니다.
    이 알고리즘이 어떤 변수에 대해 지수 시간으로 증가하는지 판단해보자.
    깊이는 어떻게 되는가?
    여기 나온 트리는 균형 이진 탐색 트리다. 즉, 총 N개의 노드가 있다면 깊이는 대략 logN이 된다.
    위의 수식에 따르면 수행 시간은 O(2^logN)이 된다.

    P=2^logN이라 하자. log의 정의에 따라 logP=logN이 된다.
    즉 P=N이라는 뜻이다.

    P = 2^logN
      -> logP = logN
      -> P = N
      -> 2^logN = N

    따라서 총 수행 시간은 O(N)이 된다. 여기서 N은 노드의 개수이다.

    */
}


class Node{
    Node left;
    Node right;
    int value;
}
