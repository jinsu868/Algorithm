import java.io.*;
import java.util.*;

public class Main {
    static List<Edge> edges;
    static long[] dist;
    static List<Integer> nodeInCycle;
    static int n;
    static int m;
    static List<Integer>[] graph;
    static int[] path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            edges.add(new Edge(u, v, w));
        }

        path = new int[n+1];
        nodeInCycle = new ArrayList<>();
        dist = new long[n+1];
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[1] = 0;
        boolean isCycle = bellman();

        if (dist[n] == Long.MIN_VALUE) {
            System.out.println(-1);
            return;
        }

        if (isCycle) {
            boolean flag = false;
            for (int node : nodeInCycle) {
                if (bfs(node)) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                System.out.println(-1);
                return;
            }
        }

        int x = n;
        path[1] = -1;
        List<Integer> result = new ArrayList<>();
        while (path[x] != -1) {
            result.add(x);
            x = path[x];
        }
        result.add(1);
        for (int i = result.size()-1; i >= 0; i--) {
            System.out.print(result.get(i) + " ");
        }

    }

    static boolean bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        visit[node] = true;
        q.add(node);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if (visit[next] == false) {
                    visit[next] = true;
                    q.add(next);
                }
            }
        }
        if (visit[n] == true) {
            return true;
        } else {
            return false;
        }
    }

    static boolean bellman() {
        boolean isCycle = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = edges.get(j);
                int from = edge.s;
                int to = edge.e;
                int cost = edge.w;
                if (dist[from] == Long.MIN_VALUE) {
                    continue;
                }
                if (dist[to] < dist[from] + cost) {
                    path[to] = from;
                    dist[to] = dist[from] + cost;
                    if (i == n-1) {
                        nodeInCycle.add(to);
                        isCycle = true;
                    }
                }
            }
        }
        return isCycle;
    }

    static class Edge {
        int s;
        int e;
        int w;
        Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}