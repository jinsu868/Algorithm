import java.io.*;
import java.util.*;

public class Main {
    static long res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr, 0, n-1);
        System.out.println(res);
    }

    public static void merge(int[] arr, int s, int mid, int e) {
        int leftPtr = s;
        int rightPtr = mid + 1;
        int arrPtr = 0;
        int[] temp = new int[e-s+1];
        while (leftPtr <= mid && rightPtr <= e) {
            if (arr[leftPtr] <= arr[rightPtr]) {
                temp[arrPtr++] = arr[leftPtr++];
            } else {
                res += (mid - leftPtr + 1);
                temp[arrPtr++] = arr[rightPtr++];
            }
        }

        if (leftPtr > mid) {
            while (rightPtr <= e) {
                temp[arrPtr++] = arr[rightPtr++];
            }
        } else {
            while (leftPtr <= mid) {
                temp[arrPtr++] = arr[leftPtr++];
            }
        }

        for (int i = 0; i < e-s+1; i++) {
            arr[s+i] = temp[i];
        }
    }

    public static void mergeSort(int[] arr, int s, int e) {
        if (s < e) {
            int mid = (s + e) / 2;
            mergeSort(arr, s, mid);
            mergeSort(arr, mid+1, e);
            merge(arr, s, mid, e);
        }
    }
}