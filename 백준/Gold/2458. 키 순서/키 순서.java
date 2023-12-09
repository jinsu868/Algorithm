import java.io.*;
import java.util.*;

public class Main {
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            dist[from][to] = 1;
        }

        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int res = 0;
        for (int i = 1; i < n+1; i++) {
            int leftCount = 0;
            int rightCount = 0;
            for (int j = 1; j < n+1; j++) {
                if (i == j) {
                    continue;
                }
                if (dist[j][i] != INF) {
                    leftCount++;
                }
                if (dist[i][j] != INF) {
                    rightCount++;
                }
            }
            if (leftCount + rightCount == n-1) {
                res++;
            }
        }
        System.out.println(res);
    }
}