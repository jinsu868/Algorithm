import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] matrix1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] matrix2 = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < k; j++) {
                matrix2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] result = multiple(matrix1, matrix2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] multiple(int[][] m1, int[][] m2) {
        int[][] result = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int x = 0; x < m; x++) {
                    result[i][j] += m1[i][x] * m2[x][j];
                }
            }
        }
        return result;
    }
}