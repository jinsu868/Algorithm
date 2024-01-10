import java.util.*;
import java.io.*;

public class Main {
    static List<Edge> edges;
    static List<Star> stars;
    static int[] parents;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        stars = new ArrayList<>();

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars.add(new Star(x, y));
        }
        edges = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                double dist = calculate(stars.get(i), stars.get(j));
                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);
        int count = 0;
        double res = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (find(edge.from) == find(edge.to)) {
                continue;
            }
            count++;
            res += edge.cost;
            union(edge.from, edge.to);
            if (count == n-1) {
                break;
            }
        }
        System.out.println(String.format("%.2f", res));
    }


    static double calculate(Star s1, Star s2) {
        return Math.sqrt(Math.pow(s1.y - s2.y, 2) + Math.pow(s1.x - s2.x, 2));
    }

    static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double cost;

        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return (int) (cost - o.cost);
        }
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
}