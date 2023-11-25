import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Star[] stars;
    static List<Edge> edges;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        stars = new Star[n];
        edges = new ArrayList<>();

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(i, x, y);
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                Star s1 = stars[i];
                Star s2 = stars[j];
                double dist = calcDist(s1, s2);
                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);

        double res = 0;
        int count = 0;
        for (Edge edge : edges) {
            int s = edge.s;
            int e = edge.e;
            if (find(s) != find(e)) {
                count += 1;
                union(s, e);
                res += edge.weight;
            }
            if (count == n-1) {
                break;
            }
        }
        System.out.printf("%.2f", res);
    }

    static int find(int x) {
        if (x != parents[x]) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x <= y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }


    private static double calcDist(Star s1, Star s2) {
        double x1 = s1.x;
        double x2 = s2.x;
        double y1 = s1.y;
        double y2 = s2.y;
        return Math.sqrt(Math.pow(x2- x1, 2) + Math.pow(y2 - y1, 2));
    }

    static class Star {
        int identity;
        double x;
        double y;
        public Star(int identity, double x, double y) {
            this.identity = identity;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable {
        int s;
        int e;
        double weight;

        Edge(int s, int e, double weight) {
            this.s = s;
            this.e = e;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            return compareTo((Edge) o);
        }

        private int compareTo(Edge e) {
            if (weight >= e.weight) {
                return 1;
            }
            return -1;
        }
    }
}