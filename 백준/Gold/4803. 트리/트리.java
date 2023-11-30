import java.io.*;
import java.util.*;



public class Main {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 1;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            int[] parents = new int[n+1];
            for (int i = 1; i < n+1; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                union(parents, u, v);
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < n+1; i++) {
                int temp = find(parents, i);
                if (temp != 0) {
                    set.add(temp);
                }
            }

            if (set.size() >= 2) {
                System.out.println(String.format("Case %d: A forest of %s trees.", t, set.size()));
            } else if (set.size() == 1) {
                System.out.println(String.format("Case %d: There is one tree.", t));
            } else {
                System.out.println(String.format("Case %d: No trees.", t));
            }
            t++;
        }
    }

    static int find(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);
        }
        return parents[x];
    }


    static void union(int[] parents, int x, int y) {
        x = find(parents, x);
        y = find(parents, y);
        if (x < y) {
            parents[y] = x;
        } else if (x > y) {
            parents[x] = y;
        } else {
            parents[x] = 0;
            parents[y] = 0;
        }
    }
}