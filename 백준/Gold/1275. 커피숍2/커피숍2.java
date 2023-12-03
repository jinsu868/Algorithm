import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int[] arr = new int[n];
        long[] tree = new long[1 << (h + 1)];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(arr, tree, 1, 0, n-1);
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            System.out.println(query(tree,x-1, y-1, 1, 0, n-1));
            update(tree, a-1, b, 1, 0, n-1);
        }
    }

    static long init(int[] arr, long[] tree, int node, int left, int right) {
        if (left == right) {
            return tree[node] = arr[left];
        }

        int mid = left + (right - left) / 2;
        return tree[node] = init(arr, tree, node * 2, left, mid) + init(arr, tree, node * 2 + 1, mid + 1, right);
    }

    static long query(long[] tree, int leftQuery, int rightQuery, int node, int left, int right) {
        if (right < leftQuery || left > rightQuery) {
            return 0;
        }

        if (leftQuery <= left && right <= rightQuery) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;
        return query(tree, leftQuery, rightQuery, node * 2, left, mid) +
                query(tree, leftQuery, rightQuery, node * 2 + 1, mid + 1, right);
    }

    static long update(long[] tree, int index, int newValue, int node, int left, int right) {
        if (right < index || left > index) {
            return tree[node];
        }

        if (right == left) {
            return tree[node] = newValue;
        }

        int mid = left + (right - left) / 2;
        return tree[node] = update(tree, index, newValue, node * 2, left, mid) +
                update(tree, index, newValue, node * 2 + 1, mid + 1, right);
    }
}