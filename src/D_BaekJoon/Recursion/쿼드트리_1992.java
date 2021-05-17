package D_BaekJoon.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 쿼드트리_1992 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[size][size];

        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            String[] pixel = st.nextToken().split("");
            for(int j=0; j<pixel.length; j++){
                matrix[i][j] = Integer.parseInt(pixel[j]);
            }
        }

        StringBuilder sb = new StringBuilder();

        compress(matrix, sb);

        System.out.println(sb);
    }

    public static StringBuilder compress(int[][] matrix, StringBuilder sb){
        int needToSplit = needToSplit(matrix);
        if(needToSplit == 2){
            sb.append("(");
            compress(getQuadrant(matrix, 1), sb);
            compress(getQuadrant(matrix, 2), sb);
            compress(getQuadrant(matrix, 3), sb);
            compress(getQuadrant(matrix, 4), sb);
            sb.append(")");
        } else {
            sb.append(needToSplit);
        }
        return sb;
    }

    public static int[][] getQuadrant(int[][] matrix, int quadrant){
        switch (quadrant){
            case 1 : return split(matrix, 0, matrix.length/2, 0, matrix.length/2);
            case 2 : return split(matrix, matrix.length/2, matrix.length, 0, matrix.length/2);
            case 3 : return split(matrix, 0, matrix.length/2, matrix.length/2, matrix.length);
            default: return split(matrix, matrix.length/2, matrix.length, matrix.length/2, matrix.length);
        }
    }

    public static int needToSplit(int[][] matrix){
        int standard = matrix[0][0];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] != standard) return 2;
            }
        }
        return standard;
    }

    public static int[][] split(int[][] matrix, int h_from, int h_to, int V_from, int v_to){
        int[][] pix = Arrays.copyOfRange(matrix, V_from, v_to);
        for(int i=0; i<pix.length; i++){
            pix[i] = Arrays.copyOfRange(pix[i], h_from, h_to);
        }
        return pix;
    }
}
