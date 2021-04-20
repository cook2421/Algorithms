package A_big_O_Examples;

public class Ex6 {

    void reverse(int[] array){
        for(int i=0; i<array.length/2; i++){
            int other = array.length - i - 1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
    }
}

// O(N)