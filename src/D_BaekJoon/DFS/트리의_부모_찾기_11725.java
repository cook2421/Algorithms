package D_BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의_부모_찾기_11725 {

    static boolean[] visited;
    static List<Integer>[] genogram;
    static Map<Integer, Integer> temp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        genogram = new LinkedList[n+1];

        for(int i=0; i<=n; i++){
            genogram[i] = new LinkedList<>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            genogram[v1].add(v2);
            genogram[v2].add(v1);
        }

        setGenoGramMap(1, 0);

        List<Integer> result = new ArrayList<>(temp.keySet());
        result.sort(Integer::compareTo);
        for(int i=2; i<=result.size(); i++){
            System.out.println(temp.get(i));
        }
    }

    public static void setGenoGramMap(int v, int asc){

        visited[v] = true;
        temp.put(v, asc);

        Iterator<Integer> iter = genogram[v].listIterator();
        while(iter.hasNext()){
            int w = iter.next();
            if(!visited[w]) setGenoGramMap(w, v);
        }
    }
}