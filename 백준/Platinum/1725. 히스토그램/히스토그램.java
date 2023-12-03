import java.io.*;
import java.util.*;

public class Main {
    static long res;
    static int[] arr;
    static int[] tree;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        tree = new int[1 << (h + 1)];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, 0, n-1);
        System.out.println(getResult(0, n-1));

    }

    static void init(int node, int left, int right) {
        if (left == right) {
            tree[node] = left;
            return;
        }

        int mid = left + (right - left) / 2;
        init(node * 2, left, mid);
        init(node * 2 + 1, mid + 1, right);
        if (arr[tree[node * 2]] < arr[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }

    static int query(int queryLeft, int queryRight, int node, int left, int right) {
        if (right < queryLeft || left > queryRight) {
            return -1;
        }

        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;
        int leftIdx = query(queryLeft, queryRight, node * 2, left, mid);
        int rightIdx = query(queryLeft, queryRight, node * 2 + 1, mid + 1, right);
        if (leftIdx < 0) {
            return rightIdx;
        }
        if (rightIdx < 0) {
            return leftIdx;
        }
        if (arr[leftIdx] < arr[rightIdx]) {
            return leftIdx;
        } else {
            return rightIdx;
        }
    }

    static long getResult(int left, int right) {
        int minIdx = query(left, right, 1, 0, n-1);
        res = Math.max(res, (right - left + 1) * arr[minIdx]);
        int mid = left + (right - left) / 2;

        if (minIdx + 1 <= right) {
            Math.max(res, getResult(minIdx + 1, right));
        }
        if (minIdx - 1 >= left) {
            Math.max(res, getResult(left, minIdx - 1));
        }
        return res;
    }
}