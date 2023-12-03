import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = 1 << (h+1);
        int[] arr = new int[n];
        int[] tree = new int[treeSize];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(tree, arr, 1, 0, n-1);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(query(tree, a-1, b-1, 1, 0, n-1));
        }
    }

    static int init(int[] tree, int[] arr, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            return tree[node] = arr[nodeLeft];
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        return tree[node] = Math.min(init(tree, arr, node * 2, nodeLeft, mid),
                init(tree, arr, node * 2 + 1, mid + 1, nodeRight));
    }

    static int query(int[] tree, int queryLeft, int queryRight, int node, int nodeLeft, int nodeRight) {
        if (nodeRight < queryLeft || nodeLeft > queryRight) {
            return Integer.MAX_VALUE;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return tree[node];
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        return Math.min(query(tree, queryLeft, queryRight, node * 2, nodeLeft, mid),
                query(tree, queryLeft, queryRight, node * 2 + 1, mid + 1, nodeRight));
    }
}