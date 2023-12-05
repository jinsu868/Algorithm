import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(dijk(0, 0));
    }

    public static int dijk(int y, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[y][x] = 0;
        pq.offer(new Node(y, x, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.count > dist[cur.y][cur.x]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }

                if (grid[ny][nx] == 1) {
                    if (dist[ny][nx] > dist[cur.y][cur.x]) {
                        dist[ny][nx] = dist[cur.y][cur.x];
                        pq.offer(new Node(ny, nx, dist[ny][nx]));
                    }
                } else { // 검방
                    if (dist[ny][nx] > dist[cur.y][cur.x] + 1) {
                        dist[ny][nx] = dist[cur.y][cur.x] + 1;
                        pq.offer(new Node(ny, nx, dist[ny][nx]));
                    }
                }
            }
        }
        return dist[n-1][n-1];
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
            return count - node.count;
        }
    }
}