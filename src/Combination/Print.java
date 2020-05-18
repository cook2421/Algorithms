package Combination;

public class Print {
    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
