package A_Cracking_The_Coding_Interview_6E.A_big_O_Examples;

public class Ex1 {

    void foo(int[] array){
        int sum = 0;
        int product = 1;

        for(int i=0; i<array.length; i++){
            sum += array[i];
        }

        for(int i=0; i<array.length; i++){
            product *= array[i];
        }

        System.out.println(sum + ", " + product);
    }
}


// O(N)