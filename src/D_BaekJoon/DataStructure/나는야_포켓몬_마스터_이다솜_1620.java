package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pokemonCnt = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> nameBook = new HashMap<>();
        HashMap<String, Integer> numBook = new HashMap<>();

        for(int i=1; i<=pokemonCnt; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            nameBook.put(i, name);
            numBook.put(name, i);
        }

        for(int i=0; i<goal; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.charAt(0) < 65) {
                System.out.println(nameBook.get(Integer.parseInt(str)));
            } else if (str.charAt(0) >= 65) {
                System.out.println(numBook.get(str));
            }
        }
    }
}
