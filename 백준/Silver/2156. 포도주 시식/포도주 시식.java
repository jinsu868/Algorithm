import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0][1] = arr[0];
        if (n == 1) {
            System.out.println(arr[0]);
        } else {
            dp[1][0] = arr[0];
            dp[1][1] = arr[0] + arr[1];
            for (int i = 2; i < n; i++) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
                dp[i][1] = Math.max(dp[i-2][0] + arr[i-1] + arr[i], dp[i-2][1] + arr[i]);
            }
            System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
        }

    }
}
