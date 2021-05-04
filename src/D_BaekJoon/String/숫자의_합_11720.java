package D_BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자의_합_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCnt = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String nums = st.nextToken();

        List<String> arr = Arrays.asList(nums.split(""));
        List<String> numArr = new ArrayList<>();
        numArr.addAll(arr);

        int sum = 0;
        for(String num : numArr){
            sum += Integer.parseInt(num);
        }

        System.out.println(sum);
    }
}
