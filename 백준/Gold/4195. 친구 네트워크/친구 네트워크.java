import java.io.*;
import java.util.*;

public class Main {
    static int[] counts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int identity = 0;
            int[] parents = new int[2 * n];
            counts = new int[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                parents[i] = i;
                counts[i] = 1;
            }
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map.containsKey(a)) {
                    map.put(a, identity++);
                }
                if (!map.containsKey(b)) {
                    map.put(b, identity++);
                }
                System.out.println(union(parents, map.get(a), map.get(b)));
            }
        }
    }

    static int union(int[] parents, int x, int y) {
        x = find(parents, x);
        y = find(parents, y);
        if (x != y) {
            if (x < y) {
                parents[y] = x;
                counts[x] += counts[y];
                return counts[x];
            } else {
                parents[x] = y;
                counts[y] += counts[x];
                return counts[y];
            }
        }
        return counts[x];
    }

    static int find(int[] parents, int x) {
        if (x != parents[x]) {
            parents[x] = find(parents, parents[x]);
        }
        return parents[x];
    }
}