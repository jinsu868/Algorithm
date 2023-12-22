import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int res = Integer.MAX_VALUE;
        while (left <= right) {
            if (sum >= m) {
                res = Math.min(res, right-left+1);
                if (res == 1) {
                    break;
                }
                sum -= arr[left++];
            } else {
                right++;
                if (right < n) {
                    sum += arr[right];
                } else {
                    break;
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(res);
        }
    }
}
