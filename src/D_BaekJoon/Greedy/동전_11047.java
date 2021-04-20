package D_BaekJoon.Greedy;

import java.util.Scanner;

public class 동전_11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i, m = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n + 1];

        for (i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        for(i=n;i>0;i--){
            m += k/a[i];
            k %= a[i];
        }

        System.out.println(m);
        sc.close();
    }
}
