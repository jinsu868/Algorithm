import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int[][] grid;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int y, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][m];
        pq.offer(new Node(y, x, 0));
        visit[y][x] = true;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.y == n-1 && cur.x == m-1) {
                return cur.count;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (visit[ny][nx] == false) {
                    if (grid[ny][nx] == 1) {
                        visit[ny][nx] = true;
                        pq.offer(new Node(ny, nx, cur.count + 1));
                    } else {
                        visit[ny][nx] = true;
                        pq.offer(new Node(ny, nx, cur.count));
                    }
                }
            }
        }
        return 0;
    }

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int count;

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

        public int compareTo(Node node) {
            return Integer.compare(count, node.count);
        }
    }
}