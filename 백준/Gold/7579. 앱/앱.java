import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringTokenizer memories = new StringTokenizer(br.readLine());
        StringTokenizer costs = new StringTokenizer(br.readLine());
        int[] cost = new int[n];
        int[] bite = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(costs.nextToken());
            bite[i] = Integer.parseInt(memories.nextToken());
            total += cost[i];
        }
        int[][] dp = new int[n][total+1];

        for (int j = 0; j < total+1; j++) {
            if (j < cost[0]) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = bite[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < total+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - cost[i] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]] + bite[i]);
                }
            }
        }

        for (int j = 0; j < total+1; j++) {
            if (dp[n-1][j] >= m) {
                System.out.println(j);
                break;
            }
        }
    }
}