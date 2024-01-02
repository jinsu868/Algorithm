import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Line[] lines = new Line[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines[i] = new Line(s, e);
        }
        Arrays.sort(lines);
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (lines[i].e > lines[j].e) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i=  0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(n - res);
    }

    static class Line implements Comparable<Line> {
        int s;
        int e;
        public Line(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Line line) {
            return s - line.s;
        }
    }
}