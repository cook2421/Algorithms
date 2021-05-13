package D_BaekJoon.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또_6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCnt = Integer.parseInt(st.nextToken());

        while(numCnt != 0){
            int[] arr = new int[numCnt];
            boolean[] visited = new boolean[numCnt];
            for(int i=0; i<numCnt; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            combination(arr, visited, 0, numCnt, 6);

            st = new StringTokenizer(br.readLine());
            numCnt = Integer.parseInt(st.nextToken());
            System.out.println();
        }
    }

    public static void combination(int[] arr, boolean[] visited, int depth, int n, int r){
        if(r == 0){
            print(arr, visited, n);
            return;
        }

        if(depth == n){
            return;
        } else {
            visited[depth] = true;
            combination(arr, visited, depth+1, n, r-1);

            visited[depth] = false;
            combination(arr, visited, depth+1, n, r);
        }
    }

    public static void print(int[] arr, boolean[] visited, int n){
        for(int i=0; i<n; i++){
            if(visited[i] == true){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
