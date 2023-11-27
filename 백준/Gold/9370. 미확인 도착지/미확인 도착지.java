import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] graph;
    static int n;
    static int m;
    static int g;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n+1];
            for (int i = 1; i < n+1; i++) {
                graph[i] = new ArrayList<>();
            }
            int gh = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[u].add(new Node(v, w));
                graph[v].add(new Node(u, w));
                if ((u == h && v == g) || (u == g && v == h)) {
                    gh = w;
                }
            }

            List<Integer> dest = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                dest.add(Integer.parseInt(br.readLine()));

            }
            List<Integer> res = new ArrayList<>();
            for (int d : dest) {
                int sd = dijk(s, d);
                int sh = dijk(s, h);
                int gd = dijk(g, d);
                int sg = dijk(s, g);
                int hd = dijk(h, d);
                if ((sh + gh + gd == sd) || (sg + gh + hd == sd)) {
                    res.add(d);
                }
            }
            Collections.sort(res);
            res.stream()
                    .forEach(d -> System.out.print(d + " "));
            System.out.println();
        }
    }

    static int dijk(int s, int d) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;
        pq.offer(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist > distance[cur.num]) {
                continue;
            }
            for (int i = 0; i < graph[cur.num].size(); i++) {
                Node next = graph[cur.num].get(i);
                if (distance[next.num] > distance[cur.num] + next.dist) {
                    distance[next.num] = distance[cur.num] + next.dist;
                    pq.offer(new Node(next.num, distance[next.num]));
                }
            }
        }
        return distance[d];
    }

    static class Node implements Comparable<Node> {
        int num;
        int dist;
        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        public int compareTo(Node node) {
            return Integer.compare(this.dist, node.dist);
        }
    }
}