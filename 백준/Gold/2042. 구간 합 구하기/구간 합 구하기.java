import java.io.*;
import java.util.*;

class SegTree {
    long[] tree;
    int size;

    public SegTree(long[] arr) {
        int h = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        size = arr.length;
        int treeSize = (int) Math.pow(2, h+1);
        tree = new long[treeSize];
        init(arr, 1, 0,  size-1);
    }

    public long update(int idx, long newValue) {
        return updateRec(idx, newValue, 1, 0, size-1);
    }

    public long query(int queryLeft, long queryRight) {
        return queryRec(queryLeft, queryRight, 1, 0, size-1);

    }

    private long queryRec(int queryLeft, long queryRight, int node, int nodeLeft, int nodeRight) {
        if (queryLeft > nodeRight || queryRight < nodeLeft) {
            return 0;
        }

        if (queryLeft <= nodeLeft && queryRight >= nodeRight) {
            return tree[node];
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        return merge(queryRec(queryLeft, queryRight, node * 2, nodeLeft, mid),
                queryRec(queryLeft, queryRight, node * 2 + 1, mid + 1, nodeRight));
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
                updateRec(index, newValue, node * 2 + 1, mid + 1, nodeRight));
    }

    private long init(long[] arr, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            return tree[node] = arr[nodeLeft];
        }
        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        long leftVal = init(arr, node * 2, nodeLeft, mid);
        long rightVal = init(arr, node * 2 + 1, mid + 1, nodeRight);
        return tree[node] = merge(leftVal, rightVal);
    }

    private long merge(long value1, long value2) {
        return value1 + value2;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
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
            if (a == 1) { //b번째 수 c로 변경
                segTree.update(b-1, c);
            } else if (a == 2) { // b~c 까지의 합
                System.out.println(segTree.query(b-1, c-1));
            }
        }
    }
}