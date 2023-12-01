import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int x;
    static int[] dist;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        bfs(x);
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if (dist[i] == k) {
                res.add(i);
            }
        }
        if (res.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(res);
            res.forEach(System.out::println);
        }
    }

    static void bfs(int s) {
        dist[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if (dist[next] == Integer.MAX_VALUE) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}