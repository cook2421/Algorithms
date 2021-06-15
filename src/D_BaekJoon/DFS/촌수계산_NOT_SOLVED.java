package D_BaekJoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산_NOT_SOLVED {

    static boolean[] visited;
    static List<Integer>[] genogram;
    static boolean p1_found;
    static boolean p2_found;
    static List<Integer> p1_genlgy;
    static List<Integer> p2_genlgy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int rel = Integer.parseInt(st.nextToken());

        visited = new boolean[cnt+1];
        genogram = new LinkedList[cnt+1];

        for(int i=0; i<=cnt; i++){
            genogram[i] = new LinkedList<>();
        }

        for(int i=0; i<rel; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            genogram[v1].add(v2);
        }





        for(int i=1; i<=cnt; i++){
            dfs(i, p1, p2);
        }

        if(!p1_found || !p2_found) {
            System.out.println(-1);
        } else {
            System.out.println();
        }
    }

    public static void dfs(int v, int p1, int p2){
        visited[v] = true;

        if(v == p1) { p1_found = true;}
        if(v == p2) { p2_found = true;}

        Iterator<Integer> iter = genogram[v].listIterator();
        while(iter.hasNext()){
            int w = iter.next();
            if(!visited[w]){
                dfs(w, p1, p2);
            }
        }
    }
}
