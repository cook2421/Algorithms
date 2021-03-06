package C_Algorithms.E_Combination;

/*
* arr : 조합을 뽑아낼 배열
* output : 조합에 뽑혔는지 체크하는 배열
* n : 배열의 길이
* r : 조합의 길이
* */

public class BackTracking {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];

        for (int i = 1; i <= n; i++) {
            combination(arr, visited, 0, n, i);
        }
    }


    // 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)
    static void combination(int[] arr, boolean[] visited, int start, int n, int r){
        if(r == 0){
            print(arr, visited, n);
            return;
        }

        for(int i=start; i<n; i++){
            visited[i] = true;
            combination(arr, visited, i+1, n, r-1);
            visited[i] = false;
        }
    }


    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
