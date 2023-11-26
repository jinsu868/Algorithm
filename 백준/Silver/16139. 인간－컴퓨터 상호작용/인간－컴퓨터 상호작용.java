import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[][] dp = new int[26][s.length()+1];
        dp[s.charAt(0) - 'a'][1]++;

        for (int i = 2; i <= s.length(); i++) {
            int cur = s.charAt(i-1) - 'a';
            for (int j = 0; j < 26; j++) {
                int before = dp[j][i-1];
                if (j == cur) {
                    dp[cur][i] = before + 1;
                } else {
                    dp[j][i] = before;
                }
            }
        }

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String alpha = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(dp[alpha.charAt(0) - 'a'][end+1] - dp[alpha.charAt(0) - 'a'][start]);
        }
    }
}
