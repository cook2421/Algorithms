package D_BaekJoon.String;

import java.util.Scanner;

public class 크로아티아_알파벳_2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        str = str.replaceAll("dz=", "1")
                .replaceAll("c=", "1")
                .replaceAll("c=", "1")
                .replaceAll("c-", "1")
                .replaceAll("d-", "1")
                .replaceAll("lj", "1")
                .replaceAll("nj", "1")
                .replaceAll("s=", "1")
                .replaceAll("z=", "1");

        System.out.println(str.length());
    }
}
