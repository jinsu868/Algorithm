import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (mode == 0) {
                union(a, b);
            } else {
                a = find(a);
                b = find(b);
                if (a != b) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }

    static int find(int x) {
        if (x != parents[x]) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x <= y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }
}