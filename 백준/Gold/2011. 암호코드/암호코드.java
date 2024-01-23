import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int n = number.length();
        if (number.startsWith("0")) {
            System.out.println(0);
            System.exit(0);
        }
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                int curValue = number.charAt(i-1) - '0';
                if (curValue >= 1 && curValue <= 9) {
                    dp[i] += dp[i-1];
                    dp[i] %= 1000000;
                }

                int preValue = number.charAt(i-2) - '0';
                if (preValue == 0) {
                    continue;
                }
                int temp = preValue * 10 + (number.charAt(i-1) -'0');
                if (temp >= 10 && temp <= 26) {
                    dp[i] += dp[i-2];
                    dp[i] %= 1000000;
                }
            }
        }
        System.out.println(dp[n] % 1000000);
    }
}