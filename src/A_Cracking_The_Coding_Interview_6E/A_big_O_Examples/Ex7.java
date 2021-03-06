package A_Cracking_The_Coding_Interview_6E.A_big_O_Examples;

public class Ex7 {

    /*

    다음 중 O(N)과 같은 것들은 무엇인가? 왜 그렇게 생각하는가?
    1. O(N+P), P < N/2일 때
    2. O(2N)
    3. O(N+logN)
    4. O(N+M)

    */

    /*

    하나씩 살펴보자.
    1. 만약 P < N/2이라면, N이 지배적인 항이므로 O(P)는 무시해도 괜찮다.
    2. O(2N)에서 상수항은 무시할 수 있으므로 O(N)과 같다.
    3. O(N)이 O(logN)보다 지배적인 항이므로 O(logN)은 버려도 된다.
    4. N과 M 사이에 어떤 연관 관계도 보이지 않으므로 여기에선 두 변수 모두를 표시해줘야 한다.

    따라서 마지막을 뺀 나머지는 모두 O(N)과 같다.

    */


}
