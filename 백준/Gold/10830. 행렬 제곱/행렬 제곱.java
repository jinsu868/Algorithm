import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int[][] result = solution(arr, k);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] solution(int[][] arr, long k) {
        if (k == 1) {
            return arr;
        }
        int[][] temp = solution(arr, k/2);
        int[][] result = multiple(temp, temp);
        if (k % 2 == 1) {
            return multiple(result, arr);
        }
        return result;
    }

    static int[][] multiple(int[][] arr1, int[][] arr2) {
        int[][] result = new int[n][n];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }
}