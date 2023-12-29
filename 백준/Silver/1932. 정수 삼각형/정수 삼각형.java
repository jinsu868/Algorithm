import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] arr = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    arr[i].set(j, arr[i-1].get(0) + arr[i].get(0));
                } else if (j == i-1) {
                    arr[i].set(j, arr[i-1].get(j-1) + arr[i].get(j));
                } else {
                    arr[i].set(j, Math.max(arr[i-1].get(j-1), arr[i-1].get(j)) + arr[i].get(j));
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, arr[n].get(i));
        }
        System.out.println(res);
    }
}
