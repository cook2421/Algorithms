package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 집합의_표현_1717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int isPrint = Integer.parseInt(st.nextToken());
            int firNum = Integer.parseInt(st.nextToken());
            int secNum = Integer.parseInt(st.nextToken());

            if(isPrint == 0){
                int min = firNum <= secNum ? firNum : secNum;
                int max = firNum > secNum ? firNum : secNum;
                map.put(min, min);
                map.put(max, min);
            } else {

            }
        }
    }


}