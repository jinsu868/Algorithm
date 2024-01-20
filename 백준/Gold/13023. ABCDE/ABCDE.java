import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static int n;
    static int m;
    static boolean[] visit;
    static int res = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);

        }
        for (int i = 0; i < n; i++) {
            if (res == 0) {
                dfs(i, 1);
            }
        }
        System.out.println(res);
    }

    static void dfs(int v, int depth) {
        if (depth == 5) {
            res = 1;
            return;
        }
        visit[v] = true;
        for (int i = 0; i < graph[v].size(); i++) {
            int u = graph[v].get(i);
            if (visit[u] == false) {
                dfs(u, depth+1);
            }
        }
        visit[v] = false;
    }
}