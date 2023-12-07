import java.io.*;
import java.util.*;

public class Main {
    static List<Edge> edges;
    static List<Integer>[] graph;
    static List<Integer> cycleNodes;
    static int[] earning;
    static long[] result;
    static int nodeInCycle;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        earning = new int[n];
        result = new long[n];
        cycleNodes = new ArrayList<>();
        edges = new ArrayList<>();
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            earning[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(result, -Long.MAX_VALUE);
        result[s] = earning[s];

        bellman();
        boolean flag = false;
        if (result[e] == -Long.MAX_VALUE) {
            System.out.println("gg");
        } else if (!cycleNodes.isEmpty()) {
            for (int cycleNode : cycleNodes) {
                if (bfs(cycleNode, e)) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                System.out.println("Gee");
            } else {
                System.out.println(result[e]);
            }
        } else {
            System.out.println(result[e]);
        }
    }

    private static boolean bfs(int nodeInCycle, int end) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n];
        visit[nodeInCycle] = true;
        q.offer(nodeInCycle);
        if (nodeInCycle == end) {
            return true;
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if (next == end) {
                    return true;
                }
                if (visit[next] == false) {
                    visit[next] = true;
                    q.offer(next);
                }

            }
        }
        return false;
    }


    static void bellman() {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);
                int s = edge.s;
                int e = edge.e;
                int w = edge.w;
                if (result[s] == -Long.MAX_VALUE) {
                    continue;
                }
                if (result[e] < result[s] - w + earning[e]) {
                    result[e] = result[s] - w + earning[e];
                    if (i == n-1) {
                        cycleNodes.add(s);
                    }
                }
            }
        }
    }

    static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}