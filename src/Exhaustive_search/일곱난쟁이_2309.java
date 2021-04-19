package Exhaustive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이_2309 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] height = new int[9];
        int[] result = new int[7];

        for(int i=0; i<height.length; i++){
            height[i] = Integer.parseInt(br.readLine());
        }
        br.close();



        System.out.println(Arrays.toString(height));
    }
}
