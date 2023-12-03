import java.io.*;
import java.util.*;

class SegTree {
    long[] tree;
    int size;

    public SegTree(long[] arr) {
        int h = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        size = arr.length;
        tree = new long[1 << (h + 1)];
        init(arr, 1, 0, size-1);
    }

    public long update(int index, long newValue) {
        return updateRec(index, newValue, 1, 0, size-1);
    }

    public long query(int queryLeft, long queryRight) {
        return queryRec(queryLeft, queryRight, 1, 0, size-1);
    }

    private long queryRec(int queryLeft, long queryRight, int node, int nodeLeft, int nodeRight) {
        if (queryRight < nodeLeft || queryLeft > nodeRight) {
            return 1;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return tree[node];
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        return merge(queryRec(queryLeft, queryRight, node * 2, nodeLeft, mid),
                queryRec(queryLeft, queryRight, node * 2 + 1, mid + 1, nodeRight)) % 1_000_000_007;
    }

    private long updateRec(int index, long newValue, int node, int nodeLeft, int nodeRight) {
        if (index < nodeLeft || nodeRight < index) {
            return tree[node];
        }

        if (nodeLeft == nodeRight) {
            return tree[node] = newValue;
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        return tree[node] = merge(updateRec(index, newValue, node * 2, nodeLeft, mid),
                updateRec(index, newValue, node * 2 + 1, mid + 1, nodeRight)) % 1_000_000_007;
    }

    private long init (long[] arr, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            return tree[node] = arr[nodeLeft];
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        return tree[node] = merge(init(arr, node * 2, nodeLeft, mid),
                init(arr, node * 2 + 1, mid+1, nodeRight)) % 1_000_000_007;
    }

    private long merge(long val1, long val2) {
        return val1 * val2;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        SegTree segTree = new SegTree(arr);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) { // b번째 값을 c로
                segTree.update(b-1, c);
            } else if (a == 2) { //b ~ c 구간 곱
                System.out.println(segTree.query(b-1, c-1) % 1_000_000_007);
            }
        }
    }
}