package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int neverSeen = Integer.parseInt(st.nextToken());
        int neverHeardOf = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<neverSeen; i++){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), 1);
        }

        ArrayList<String> res = new ArrayList<>();
        for(int i=0; i<neverHeardOf; i++){
            st = new StringTokenizer(br.readLine());
            String nho = st.nextToken();
            if(map.get(nho) != null){
                res.add(nho);
            }
        }

        Collections.sort(res);

        System.out.println(res.size());
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
