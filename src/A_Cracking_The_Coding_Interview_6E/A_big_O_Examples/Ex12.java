package big_O_Examples;

public class Ex12 {

    void permutation(String str){
        permutation(str, "");
    }

    void permutation(String str, String prefix){
        if(str.length() == 0){
            System.out.println(prefix);
        } else {
            for(int i=0; i<str.length(); i++){
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}

/*
위의 예제는 문자열로 나타낼 수 있는 순열(permutation)의 개수를 구하는 코드이다.

[[[ 1. 순열이 완성되는 시점에 permutation 함수가 몇 번이나 호출되는가 ]]]
순열을 생성하고 싶다면 각 '자리'에 들어갈 문자를 골라야 한다.
길이가 7인 문자열이 주어졌을 때, 가능한 경우는 7*6*5*4*3*2*1
다시 말해 7!(7의 계승)이 된다.
 n!개의 순열이 존재한다는 뜻이고, 따라서 순열 생성이 완성되는 시점에
permutation 함수는 n!번 호출될 것이다.

[[[ 2. 순열 생이 완성되기 전에 permutation 함수는 몇 번 호출되는가 ]]]
모든 호출을 나타내는 거대한 호출 트리(call tree)를 상상해보자.
위에서 말한 대로 말단(leaf) 노드의 개수는 n!이 될 테고 루트에서
각 말단 노드까지의 거리는 n이 될 것이다.
따라서 전체 노드(함수 호출)의 개수는 n*n!개를 넘지 못한다.

[[[ 3. 각 함수 호출을 처리하는 데 얼마나 오래 걸리나 ]]]
11번째 줄에서는 문자열 전체를 출력하기 때문에 O(N)의 시간이 걸린다.
14, 15번째 줄에서는 문자열을 연결해주는 연산을 수행하므로 O(N) 시간이 걸릴 것이다.
또한 rem, prefix, str.charAt(i)의 길이의 합은 항상 n이 되는 것을 알 수 있다.
따라서 호출 트리의 각 노드가 처리하는 일은 O(n)이 된다.

[[[ 4. 총 수행 시간은 어떻게 되는가? ]]]
permutation 함수는 O(n*n!)번(상한) 호출되고 한 번 호출될 때마다 O(N) 시간이 걸리므로
총 수행 시간은 O(n^2 * n!)을 넘지 않을 것이다.


*/
