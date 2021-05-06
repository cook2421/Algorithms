package D_BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 그룹_단어_체커_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int loop = Integer.parseInt(st.nextToken());

        int grpWrdCnt = 0;
        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");

            boolean keepSearch = true;
            ArrayList<String> wordList = new ArrayList<>();
            for(int j=0; j<str.length && keepSearch; j++){
                if(wordList.indexOf(str[j]) == -1){
                    wordList.add(str[j]);
                } else {
                    if(wordList.indexOf(str[j]) != wordList.size()-1){
                        keepSearch = false;
                    }
                }
            }
            if(keepSearch) grpWrdCnt++;
        }
        System.out.println(grpWrdCnt);
    }
}
