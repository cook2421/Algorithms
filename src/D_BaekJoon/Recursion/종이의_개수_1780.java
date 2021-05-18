package D_BaekJoon.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 종이의_개수_1780 {

    static int negative = 0;
    static int zero = 0;
    static int positive = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        int[][] paper = new int[size][size];

        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countPaper(paper);
        System.out.println(negative);
        System.out.println(zero);
        System.out.println(positive);

    }

    public static void countPaper(int[][] paper){
        int cntOrSplit = needToSplit(paper, paper.length);
        switch (cntOrSplit){
            case -1 : negative++; break;
            case 0 : zero++; break;
            case 1 : positive++; break;
            case 2 :
                countPaper(split(paper, 0, paper.length/3, 0, paper.length/3));
                countPaper(split(paper, paper.length/3, paper.length/3*2, 0, paper.length/3));
                countPaper(split(paper, paper.length/3*2, paper.length, 0, paper.length/3));

                countPaper(split(paper, 0, paper.length/3, paper.length/3, paper.length/3*2));
                countPaper(split(paper, paper.length/3, paper.length/3*2, paper.length/3, paper.length/3*2));
                countPaper(split(paper, paper.length/3*2, paper.length, paper.length/3, paper.length/3*2));

                countPaper(split(paper, 0, paper.length/3, paper.length/3*2, paper.length));
                countPaper(split(paper, paper.length/3, paper.length/3*2, paper.length/3*2, paper.length));
                countPaper(split(paper, paper.length/3*2, paper.length, paper.length/3*2, paper.length));
                break;
        }

    }

    public static int needToSplit(int[][] paper, int size){
        int standard = paper[0][0];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(paper[i][j] != standard) return 2;
            }
        }

        return standard;
    }

    public static int[][] split(int[][] paper, int from_h, int to_h, int from_v, int to_v){
        int[][] result = Arrays.copyOfRange(paper, from_v, to_v);
        for(int i=0; i<result.length; i++){
            result[i] = Arrays.copyOfRange(result[i], from_h, to_h);
        }
        return result;
    }
}
