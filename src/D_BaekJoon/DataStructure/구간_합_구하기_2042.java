package D_BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 구간_합_구하기_2042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCnt = Integer.parseInt(st.nextToken());
        int chgCnt = Integer.parseInt(st.nextToken());
        int sumCnt = Integer.parseInt(st.nextToken());

        int[] numArr = new int[numCnt];
        TreeMap<Integer, Integer> chgLog = new TreeMap<>();

        for(int i=0; i<numCnt; i++){
            st = new StringTokenizer(br.readLine());
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<chgCnt+sumCnt; i++){
            st = new StringTokenizer(br.readLine());
            int chgOrSum = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(chgOrSum == 1){
                chgLog.put(b-1, c);
            } else {
                int sum = sum(b, c, numArr);
                int lastStd = b-1;
                while(true) {
                    Map.Entry entry = getChgNums(lastStd, c, chgLog);
                    if(entry != null){
                        lastStd = (Integer)entry.getKey();
                        sum += ((Integer)entry.getValue() - numArr[(Integer)entry.getKey()]);
                    } else {
                        break;
                    }
                }
                System.out.println(sum);
            }
        }
    }

    public static int sum(int str, int end, int[] numArr){
        int sum = 0;

        for(int i=str-1; i<end; i++){
            sum += numArr[i];
        }

        return sum;
    }

    public static Map.Entry<Integer, Integer> getChgNums(int str, int end, TreeMap<Integer, Integer> map){

        if(str > end) return null;

        Map.Entry<Integer, Integer> res = map.higherEntry(str);
        if(res == null || res.getKey() >= end) {
            return null;
        } else {
            return res;
        }
    }
}
