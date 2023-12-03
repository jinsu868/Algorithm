import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int[] arr = new int[n];
        long[] tree = new long[1 << (h + 1)];
        init(arr, tree, 1, 0, n-1);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (op == 0) {
                if (a > b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                sb.append(query(tree, a-1, b-1, 1, 0, n-1) + "\n");
            } else {
                update(tree, a-1, b, 1, 0, n-1);
            }
        }
        System.out.println(sb);
    }

    static long init(int[] arr, long[] tree, int node, int left, int right) {
        if (left == right) {
            return tree[node] = arr[left];
        }

        int mid = left + (right - left) / 2;
        return tree[node] = init(arr, tree, node * 2, left, mid) +
                init(arr, tree, node * 2 + 1, mid + 1, right);
    }

    static long query(long[] tree, int queryLeft, int queryRight, int node, int left, int right) {
        if (right < queryLeft || left > queryRight) {
            return 0;
        }

        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;
        return query(tree, queryLeft, queryRight, node * 2, left, mid) +
                query(tree, queryLeft, queryRight, node * 2 + 1, mid + 1, right);
    }

    static long update(long[] tree, int index, int newValue, int node, int left, int right) {
        if (right < index || left > index) {
            return tree[node];
        }

        if (left == right) {
            return tree[node] = newValue;
        }

        int mid = left + (right - left) / 2;
        return tree[node] = update(tree, index, newValue, node * 2, left, mid) +
                update(tree, index, newValue, node * 2 + 1, mid + 1, right);
    }
}