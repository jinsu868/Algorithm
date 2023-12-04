import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int r;
    static int[] scores;
    static List<Edge>[] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        scores = new int[n+1];
        graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        int res = 0;
        for (int i = 1; i < n+1; i++) {
            dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijk(i);
            int temp = 0;
            for (int j = 1; j < n+1; j++) {
                if (dist[j] <= m) {
                    temp += scores[j];
                }
            }
            res = Math.max(res, temp);
        }

        System.out.println(res);
    }

    static void dijk(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dist[v] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.dist < dist[cur.node]) {
                continue;
            }
            for (int i = 0; i < graph[cur.node].size(); i++) {
                Edge next = graph[cur.node].get(i);
                if (dist[next.node] > dist[cur.node] + next.dist) {
                    dist[next.node] = dist[cur.node] + next.dist;
                    pq.offer(new Edge(next.node, dist[next.node]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int dist;
        public Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(Edge edge) {
            return Integer.compare(dist, edge.dist);
        }
    }
}