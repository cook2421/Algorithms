package Exhaustive_Search;

import java.util.Scanner;

/*
arr : 순열을 만들 배열
output : 순열을 만든 후 배열
visited : 방문 체크
depth : dfs 깊이
*/

public class 모든순열_10974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();

        int[] arr = new int[n];
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            arr[i] = i + 1;
        }

        perm(arr, output, visited, 0, n, n);
    }


    // 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            print(output, r);
            return;
        }

        for(int i=0; i<n; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }


    static void print(int[] arr, int r) {
        for(int i=0; i<r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
