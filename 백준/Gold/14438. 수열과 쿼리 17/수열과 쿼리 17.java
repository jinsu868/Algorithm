import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        long[] tree = new long[1 << (h + 1)];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(arr, tree, 1, 0, n-1);
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (op == 1) { // modify
                update(tree, a-1, b, 1, 0, n-1);
            } else { // query
                System.out.println(query(tree, a-1, b-1, 1, 0, n-1));
            }
        }
    }

    static long init(int[] arr, long[] tree, int node, int left, int right) {
        if (left == right) {
            return tree[node] = arr[left];
        }

        int mid = left + (right - left) / 2;
        return tree[node] = Math.min(init(arr, tree, node * 2, left, mid),
                init(arr, tree, node * 2 + 1, mid + 1, right));
    }

    static long update(long[] tree, int index, int newValue, int node, int left, int right) {
        if (right < index || left > index) {
            return tree[node];
        }

        if (left == right) {
            return tree[node] = newValue;
        }

        int mid = left + (right - left) / 2;
        return tree[node] = Math.min(update(tree, index, newValue, node * 2, left, mid),
                update(tree, index, newValue, node *2 + 1, mid + 1, right));
    }

    static long query(long[] tree, int queryLeft, int queryRight, int node, int left, int right) {
        if (right < queryLeft || left > queryRight) {
            return Integer.MAX_VALUE;
        }

        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;
        return Math.min(query(tree, queryLeft, queryRight, node * 2, left, mid),
                query(tree, queryLeft, queryRight, node * 2 + 1, mid + 1, right));
    }
}