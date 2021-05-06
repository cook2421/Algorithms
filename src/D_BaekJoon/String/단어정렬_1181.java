package D_BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어정렬_1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());

        TreeMap<String, Integer> strMap = new TreeMap<>();
        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            strMap.put(s, s.length());
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(strMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for(Map.Entry entry : list){
            System.out.println(entry.getKey());
        }
    }
}
