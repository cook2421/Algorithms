package D_BaekJoon.String;

import java.util.Scanner;

public class 잃어버린_괄호_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] strArr = str.split("-|\\+");
        String[] oper = str.replaceAll("\\d", "").split("");

        boolean afterMinus = false;

        int sum = Integer.parseInt(strArr[0]);
        for(int i=0; i<oper.length && strArr.length > 1; i++){
            if(oper[i].equals("+") && !afterMinus){
                sum += Integer.parseInt(strArr[i+1]);
            } else {
                afterMinus = true;
                sum -= Integer.parseInt(strArr[i+1]);
            }
        }
        System.out.println(sum);
    }
}
