import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long s = 1;
        long e = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (e < arr[i]) {
                e = arr[i];
            }
        }
        long res = -1;
        while (s <= e) {
            long mid = (s + e) / 2;
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += arr[i] / mid;
            }
            if (total >= k) {
                s = mid + 1;
                res = Math.max(res, mid);
            } else {
                e = mid -1;

            }
        }
        System.out.println(res);
    }
}
