package D_BaekJoon.String;

import java.util.*;

public class 숫자의_개수_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        List<String> arr = Arrays.asList(Integer.toString(a*b*c).split(""));
        ArrayList<String> numArr = new ArrayList<>();
        numArr.addAll(arr);
        Collections.sort(numArr);

        for(int i=0; i<10; i++){
            int cnt = 0;
            while(numArr.size() != 0 && i == Integer.parseInt(numArr.get(0))){
                numArr.remove(0);
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
