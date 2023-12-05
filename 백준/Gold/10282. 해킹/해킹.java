import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] graph;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n+1];
            for (int i = 1; i < n+1; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new Node(a, s));
            }
            Pair result = dijk(c);
            System.out.println(result.count + " " + result.time);
        }
    }

    static Pair dijk(int s) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.offer(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.num]) {
                continue;
            }
            for (int i = 0; i < graph[cur.num].size(); i++) {
                Node next = graph[cur.num].get(i);
                if (dist[next.num] > dist[cur.num] + next.cost) {
                    dist[next.num] = dist[cur.num] + next.cost;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }
        int maxDist = 0;
        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                count++;
                if (dist[i] > maxDist) {
                    maxDist = dist[i];
                }
            }
        }
        return new Pair(count, maxDist);
    }

    static class Node implements Comparable<Node> {
        int num;
        int cost;
        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        public int compareTo(Node node) {
            return cost - node.cost;
        }
    }

    static class Pair {
        int count;
        int time;
        public Pair(int count, int time) {
            this.count = count;
            this.time = time;
        }
    }
}