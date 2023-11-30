import java.io.*;
import java.util.*;



public class Main {
    static List<Integer>[] graph;
    static boolean[] visit;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 1;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            graph = new ArrayList[n+1];
            for (int i = 1; i < n+1; i++) {
                graph[i] = new ArrayList<>();
            }
            visit = new boolean[n+1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            int res = 0;
            for (int i = 1; i < n+1; i++) {
                if (visit[i] == false) {
                    res += bfs(i);
                }
            }

            if (res >= 2) {
                System.out.println(String.format("Case %d: A forest of %s trees.", t, res));
            } else if (res == 1) {
                System.out.println(String.format("Case %d: There is one tree.", t));
            } else {
                System.out.println(String.format("Case %d: No trees.", t));
            }
            t++;
        }
    }



    static int bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        visit[v] = true;
        int node = 0;
        int edge = 0;
        q.offer(v);
        while (!q.isEmpty()) {
            int cur = q.poll();
            node++;
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                edge++;
                if (visit[next] == false) {
                    visit[next] = true;
                    q.add(next);
                }
            }
        }
        if (node == (edge / 2) + 1) {
            return 1;
        }
        return 0;
    }
}