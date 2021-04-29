package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 집합의_표현_1717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeMap<Integer, TreeSet> map = new TreeMap<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int isPrint = Integer.parseInt(st.nextToken());
            int firNum = Integer.parseInt(st.nextToken());
            int secNum = Integer.parseInt(st.nextToken());

            if(isPrint == 0){
                int minNum = firNum <= secNum ? firNum : secNum;
                TreeSet set = new TreeSet();
                set.add(firNum);
                set.add(secNum);
                map.put(minNum, set);
            } else {

            }
        }
    }
}