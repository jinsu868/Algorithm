import java.util.*;
import java.io.*;

public class Main {
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        dp =  new int[21][21][21];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        dp[0][1][0] = 1;
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;
        dp[0][1][1] = 1;
        dp[1][1][1] = 2;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            System.out.println(String.format("w(%d, %d, %d) = %d", a, b, c, solution(a, b, c)));
        }
    }

    static int solution(int a, int b, int c) {
        if (a < 1 || b < 1 || c < 1) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return solution(20, 20, 20);
        }
        if (a < b && b < c) {
            if (dp[a][b][c] == 0) {
                return dp[a][b][c] = solution(a, b, c-1) + solution(a, b-1, c-1) - solution(a, b-1, c);
            } else {
                return dp[a][b][c];
            }
        } else {
            if (dp[a][b][c] == 0) {
                return dp[a][b][c] = solution(a-1, b, c) + solution(a-1, b-1, c) + solution(a-1, b, c-1)
                        - solution(a-1, b-1, c-1);
            } else {
                return dp[a][b][c];
            }
        }
    }
}
