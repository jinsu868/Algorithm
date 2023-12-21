import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long s = 1;
        long e = k;
        long res = 0;
        while (s <= e) {
            long mid = (s + e) / 2;
            long total = 0;
            for (int i = 1; i <= n; i++) {
                total += Math.min(n, mid/i);
            }
            if (total >= k) {
                e = mid - 1;
                res = mid;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(res);
    }
}