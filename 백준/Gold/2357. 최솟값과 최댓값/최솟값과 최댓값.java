import java.io.*;
import java.util.*;

class SegMinTree {
    int[] tree;
    int n;
    public SegMinTree(int[] arr) {
        n = arr.length;
        int h = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        int treeSize = 1 << (h + 1);
        tree = new int[treeSize];
        init(arr, 1, 0, n-1);
    }

    public int query(int queryLeft, int queryRight) {
        return queryRec(queryLeft, queryRight, 1, 0, n-1);
    }
    private int queryRec(int queryLeft, int queryRight, int node, int nodeLeft, int nodeRight) {
        if (nodeRight < queryLeft || queryRight < nodeLeft) {
            return Integer.MAX_VALUE;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return tree[node];
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        return merge(queryRec(queryLeft, queryRight, node * 2, nodeLeft, mid),
                queryRec(queryLeft, queryRight, node * 2 + 1, mid + 1, nodeRight));
    }

    private int init(int[] arr, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            return tree[node] = arr[nodeLeft];
        }
        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        return tree[node] = merge(init(arr, node * 2, nodeLeft, mid),
                init(arr, node  * 2 + 1, mid + 1, nodeRight));
    }

    private int merge(int a, int b) {
        return Math.min(a, b);
    }
}

class SegMaxTree {
    int[] tree;
    int n;

    public SegMaxTree(int[] arr) {
        n = arr.length;
        int h = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        int treeSize = 1 << (h + 1);
        tree = new int[treeSize];
        init(arr, 1, 0, n-1);
    }

    public int query(int queryLeft, int queryRight) {
        return queryRec(queryLeft, queryRight, 1, 0, n-1);
    }
    private int queryRec(int queryLeft, int queryRight, int node, int nodeLeft, int nodeRight) {
        if (nodeRight < queryLeft || queryRight < nodeLeft) {
            return 0;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return tree[node];
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        return merge(queryRec(queryLeft, queryRight, node * 2, nodeLeft, mid),
                queryRec(queryLeft, queryRight, node * 2 + 1, mid + 1, nodeRight));
    }

    private int init(int[] arr, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            return tree[node] = arr[nodeLeft];
        }
        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        return tree[node] = merge(init(arr, node * 2, nodeLeft, mid),
                init(arr, node  * 2 + 1, mid + 1, nodeRight));
    }

    private int merge(int a, int b) {
        return Math.max(a, b);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        SegMaxTree segMaxTree = new SegMaxTree(arr);
        SegMinTree segMinTree = new SegMinTree(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(),  " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(segMinTree.query(a-1, b-1) + " " + segMaxTree.query(a-1, b-1));
        }
    }
}