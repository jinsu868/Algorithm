import java.util.*;
import java.io.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();

        parents = new int[v+1];
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }

        Collections.sort(edges);
        int res = 0;
        int n = 0;

        for (int i = 0; i < edges.size(); i++) {
            int from = edges.get(i).from;
            int to = edges.get(i).to;
            int cost = edges.get(i).cost;
            if (find(from) == find(to)) {
                continue;
            }
            union(from, to);
            res += cost;
            n++;
            if (n == v-1) {
                break;
            }
        }
        System.out.println(res);
    }

    static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}