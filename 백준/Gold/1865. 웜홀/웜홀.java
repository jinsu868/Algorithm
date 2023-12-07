import java.io.*;
import java.util.*;

public class Main {
    static List<Edge> edges;
    static int n;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, -t));
            }

            dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            boolean flag = false;
            for (int i = 1; i < n + 1; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    if (bellman(i)) {
                        flag = true;
                    }
                }
            }
            if (flag == true) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    static boolean bellman(int start) {

        dist[start] = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);
                int s = edge.s;
                int e = edge.e;
                int t = edge.t;
                if (dist[s] == Integer.MAX_VALUE) {
                    continue;
                }
                if (dist[e] > dist[s] + t) {
                    if (i == n) {
                        return true;
                    }
                    dist[e] = dist[s] + t;
                }
            }
        }
        return false;
    }

    static class Edge {
        int s;
        int e;
        int t;
        public Edge(int s, int e, int t) {
            this.s = s;
            this.e = e;
            this.t = t;
        }
    }
}
