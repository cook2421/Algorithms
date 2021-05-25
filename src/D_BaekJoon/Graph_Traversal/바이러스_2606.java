package D_BaekJoon.Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 바이러스_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];
        LinkedList<Integer>[] adjComputer = new LinkedList[n+1];

        for(int i=1; i<=n; i++){
            adjComputer[i] = new LinkedList<>();
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            adjComputer[com1].add(com2);
            adjComputer[com2].add(com1);
        }

        System.out.println(getInfectedComputerCount(1, adjComputer, visited, 0)-1);

    }

    public static int getInfectedComputerCount(int v, LinkedList<Integer>[] adjComputer, boolean[] visited, int count){
        visited[v] = true;

        Iterator<Integer> iter = adjComputer[v].listIterator();
        while(iter.hasNext()){
            int w = iter.next();
            if(!visited[w]){
                count = getInfectedComputerCount(w, adjComputer, visited, count);
            }
        }

        return ++count;
    }
}
