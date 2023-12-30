import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][10];
        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][1];
                } else if (j == 9) {
                    dp[i][j] = dp[i-1][8];
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < 10; i++) {
            res += dp[n-1][i];
            res %= 1000000000;
        }
        System.out.println(res);
    }
}