package D_BaekJoon.Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기_2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[size][size];
        int[][] complex = new int[size][size];

        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            complex[i] = Arrays.asList(st.nextToken().split("")).stream().mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> complexCnt = new ArrayList<>();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(complex[i][j] == 1 && !visited[i][j]){
                    complexCnt.add(getComplexSize(i, j, complex, visited, 0));
                }
            }
        }

        Collections.sort(complexCnt);
        int resultSize = complexCnt.size();
        System.out.println(resultSize);
        for(int i=0; i<resultSize; i++){
            System.out.println(complexCnt.get(i));
        }
    }


    public static int getComplexSize(int x, int y, int[][] complex, boolean[][] visited, int count){
        visited[x][y] = true;
        int size = complex.length;

        if(0<=y+1 && y+1<=size-1 && complex[x][y+1] == 1 && !visited[x][y+1]) count = getComplexSize(x, y+1, complex, visited, count);
        if(0<=x+1 && x+1<=size-1 && complex[x+1][y] == 1 && !visited[x+1][y]) count = getComplexSize(x+1, y, complex, visited, count);
        if(0<=y-1 && y-1<=size-1 && complex[x][y-1] == 1 && !visited[x][y-1]) count = getComplexSize(x, y-1, complex, visited, count);
        if(0<=x-1 && x-1<=size-1 && complex[x-1][y] == 1 && !visited[x-1][y]) count = getComplexSize(x-1, y, complex, visited, count);

        return ++count;
    }
}
