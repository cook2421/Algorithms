package A_Cracking_The_Coding_Interview_6E.A_big_O_Examples;

public class Ex2 {

    void printPairs(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                System.out.println(array[i] + ", " + array[j]);
            }
        }
    }
}

// O(N^2)