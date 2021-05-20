package D_BaekJoon.Recursion;

import java.util.Scanner;

public class 별찍기_10_2447_NOT_SOLVED {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        char[][] stars = new char[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                stars[i][j] = '*';
            }
        }


    }

    public static char[][] goDeep(char[][] stars){
        if(stars.length == 3){
            //makeVoid(star)
        }
        return stars;
    }

    public static char[][] makeVoid(char[][] stars, int str, int end){
        for(int i=str; i<end; i++){
            for(int j=str; j<end; j++){
                stars[i][j] = ' ';
            }
        }
        return stars;
    }
}