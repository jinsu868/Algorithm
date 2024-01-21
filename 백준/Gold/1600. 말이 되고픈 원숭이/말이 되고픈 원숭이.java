import java.util.*;
import java.io.*;

public class Main {
    static int[][] grid;
    static int[] bdx = {0, 0, -1, 1};
    static int[] bdy = {-1, 1, 0, 0};
    static int[] hdx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] hdy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int n;
    static int m;
    static int k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Position> q = new LinkedList<>();
        boolean[][][] visit = new boolean[n][m][31];
        q.offer(new Position(0, 0, 0, 0));
        visit[0][0][0] = true;
        int res = Integer.MAX_VALUE;
        if (n == 1 && m == 1) {
            return 0;
        }
        while (!q.isEmpty()) {
            Position cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int kCnt = cur.kCnt;
            int mCnt = cur.mCnt;
            if (kCnt < k) {
                for (int i = 0; i < 8; i++) {
                    int ny = y + hdy[i];
                    int nx = x + hdx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                        continue;
                    }
                    if (grid[ny][nx] == 1) {
                        continue;
                    }
                    if (visit[ny][nx][kCnt+1] == true) {
                        continue;
                    }
                    if (ny == n-1 && nx == m-1) {
                        res = Math.min(res, mCnt+1);
                        continue;
                    }
                    visit[ny][nx][kCnt+1] = true;
                    q.offer(new Position(ny, nx, kCnt+1, mCnt+1));
                }
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + bdy[i];
                int nx = x + bdx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (grid[ny][nx] == 1) {
                    continue;
                }
                if (visit[ny][nx][kCnt] == true) {
                    continue;
                }
                if (ny == n-1 && nx == m-1) {
                    res = Math.min(res, mCnt+1);
                    continue;
                }
                visit[ny][nx][kCnt] = true;
                q.offer(new Position(ny, nx, kCnt, mCnt+1));
            }
        }

        if (res == Integer.MAX_VALUE) {
            return -1;
        } else {
            return res;
        }
    }

    static class Position {
        int y;
        int x;
        int kCnt;
        int mCnt;
        public Position(int y, int x, int kCnt, int mCnt) {
            this.y = y;
            this.x = x;
            this.kCnt = kCnt;
            this.mCnt = mCnt;
        }
    }
}