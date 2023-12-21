import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long s = 1;
        long e = arr[n-1];
        long res = 0;
        while (s <= e) {
            long total = 0;
            int wifiCnt = 1;
            long mid = (s + e) / 2;
            for (int i = 1; i < n; i++) {
                long dist = arr[i] - arr[i-1];
                total += dist;
                if (total >= mid) {
                    wifiCnt++;
                    total = 0;
                }
            }

            if (wifiCnt >= c) {
                res = Math.max(res, mid);
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        System.out.println(res);
    }
}