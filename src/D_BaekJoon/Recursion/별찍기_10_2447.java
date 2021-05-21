package D_BaekJoon.Recursion;

import java.util.Scanner;

public class 별찍기_10_2447 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        String[][] stars = new String[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                stars[i][j] = "*";
            }
        }

        stars = goDeep(stars, size, 0, size-1, 0, size-1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                sb.append(stars[i][j]);
            }
            if(i+1 != size) sb.append("\n");
        }

        System.out.println(sb);
    }

    public static String[][] goDeep(String[][] stars, int size, int from_h, int to_h, int from_v, int to_v){
        if(size == 3){
            makeVoid(stars, from_h+1, to_h, from_v+1, to_v, size);
        } else {
            int nextSize = size/3;
            makeVoid(stars, from_h+nextSize, to_h-nextSize+1,from_v+nextSize, to_v-nextSize+1, size);

            stars = goDeep(stars, nextSize, from_h, to_h-(nextSize*2), from_v, to_v-(nextSize*2));
            stars = goDeep(stars, nextSize, from_h, to_h-(nextSize*2), from_v+nextSize, to_v-nextSize);
            stars = goDeep(stars, nextSize, from_h, to_h-(nextSize*2), from_v+(nextSize*2), to_v);

            stars = goDeep(stars, nextSize, from_h+nextSize, to_h-nextSize, from_v, to_v-(nextSize*2));
            stars = goDeep(stars, nextSize, from_h+nextSize, to_h-nextSize, from_v+(nextSize*2), to_v);

            stars = goDeep(stars, nextSize, from_h+(nextSize*2), to_h, from_v, to_v-(nextSize*2));
            stars = goDeep(stars, nextSize, from_h+(nextSize*2), to_h, from_v+nextSize, to_v-nextSize);
            stars = goDeep(stars, nextSize, from_h+(nextSize*2), to_h, from_v+(nextSize*2), to_v);


        }

        return stars;
    }

    public static String[][] makeVoid(String[][] stars, int str_h, int end_h, int str_v, int end_v, int size){
        for (int i = str_v; i < end_v; i++) {
            for (int j = str_h; j < end_h; j++) {
                stars[i][j] = " ";
            }
        }
        return stars;
    }
}