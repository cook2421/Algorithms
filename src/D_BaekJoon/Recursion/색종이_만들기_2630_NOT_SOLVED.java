package D_BaekJoon.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 색종이_만들기_2630_NOT_SOLVED {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sqrSize = Integer.parseInt(st.nextToken());

        int[][] paper = new int[sqrSize][sqrSize];

        for(int i=0; i<sqrSize; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<sqrSize; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[][]> paperPieces = new LinkedList<>();
        paperPieces.add(paper);
        Integer[] sum = {0, 0};
        getPaperCnt(paperPieces, sum);

        System.out.println(sum[0]);
        System.out.println(sum[1]);

    }

    public static void getPaperCnt(Queue<int[][]> paperPieces, Integer[] sum) {

        if(paperPieces.isEmpty()) return;

        int[][] paper = paperPieces.poll();
        if(needToSplit(paper)){
            for(int i=1; i<=4; i++){
                paperPieces.add(getPaperPiece(paper, i));
            }
            getPaperCnt(paperPieces, sum);
        } else {
            if(paper[0][0] == 0){
                sum[0]++;
            } else {
                sum[1]++;
            }
        }
    }

    public static int[][] getPaperPiece(int[][] paper, int quadrant){
        switch(quadrant){
            case 1 : return split(paper, paper.length/2, paper.length, 0, paper.length/2);
            case 2 : return split(paper, 0, paper.length/2, 0, paper.length/2);
            case 3 : return split(paper, 0, paper.length/2, paper.length/2, paper.length);
            default: return split(paper, paper.length/2, paper.length, paper.length/2, paper.length);
        }
    }

    public static int[][] split(int[][] paper, int from_v, int to_v, int from_h, int to_h){
        int[][] paperPiece = Arrays.copyOfRange(paper, from_v, to_v);
        for(int i=0; i<paperPiece.length; i++){
            paperPiece[i] = Arrays.copyOfRange(paperPiece[i], from_h, to_h);
        }
        return paperPiece;
    }

    public static boolean needToSplit(int[][] paper){
        int color = paper[0][0];

        for(int i=0; i<paper.length; i++){
            for(int j=0; j<paper.length; j++){
                if(color != paper[i][j]) return true;
            }
        }
        return false;
    }
}
