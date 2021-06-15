package D_BaekJoon.Divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 히스토그램에서_가장_큰_직사각형_6549_NOT_SOLVED {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens() && !st.nextToken().equals("0")) {
            int tmp = 0;
            int max = 0;
            List<Integer> rect = new ArrayList<>();

            while (st.hasMoreTokens()) {
                tmp = Integer.parseInt(st.nextToken());
                if(max < tmp) max = tmp;
                rect.add(tmp);
            }

            for(int i=0; i<rect.size(); i++){
                int min_h = 1000000001;
                for(int j=0; j<rect.size()-i; j++){
                    int temp = rect.get(j);
                    if(temp < min_h) min_h = temp;
                }
                if(max < min_h*rect.size()-i) max = min_h*rect.size()-i;
            }

            System.out.println(max);

            st = new StringTokenizer(br.readLine());
        }

    }
}
