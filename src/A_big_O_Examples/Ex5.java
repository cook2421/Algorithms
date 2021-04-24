package A_big_O_Examples;

public class Ex5 {

    void printUnorderedPairs(int[] arrayA, int[] arrayB){
        for(int i=0; i<arrayA.length; i++){
            for(int j=0; j<arrayB.length; j++){
                for(int k=0; k<100000; k++){
                    System.out.println(arrayA[i] + ", " + arrayB.length);
                }
            }
        }
    }
}

// 크게 달라진 건 없다. 100,000은 여전히 상수항으로 간주되므로 수행 시간은 O(ab)가 된다.