import java.util.*;
import java.io.*;

public class Main {
    static int cnt1; // -1, 0, 1
    static int cnt2;
    static int cnt3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(grid, 0, 0, n-1, n-1);
        System.out.println(cnt1);
        System.out.println(cnt2);
        System.out.println(cnt3);
    }

    static void solution(int[][] grid, int y1, int x1, int y2, int x2) {
        if (x1 == x2) {
            if (grid[y1][x1] == -1) {
                cnt1++;
            } else if (grid[y1][x1] == 0) {
                cnt2++;
            } else {
                cnt3++;
            }
            return;
        }
        int id = grid[y1][x1];
        boolean flag = true;
        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                if (grid[y][x] != id) {
                    flag = false;
                    break;
                }
            }
            if (flag == false) {
                break;
            }
        }
        if (flag == false) {
            int yLeft = y1 + (y2-y1) / 3;
            int xLeft = x1 + (x2-x1) / 3;
            int yRight = y1 + ((y2-y1) / 3) * 2 + 1;
            int xRight = x1 + ((x2-x1) / 3) * 2 + 1;
            solution(grid, y1, x1, yLeft, xLeft);
            solution(grid, y1, xLeft+1, yLeft, xRight);
            solution(grid, y1, xRight+1, yLeft, x2);
            solution(grid, yLeft+1, x1, yRight, xLeft);
            solution(grid, yLeft+1, xLeft+1, yRight, xRight);
            solution(grid, yLeft+1, xRight+1, yRight, x2);
            solution(grid, yRight+1, x1, y2, xLeft);
            solution(grid, yRight+1, xLeft+1, y2, xRight);
            solution(grid, yRight+1, xRight+1, y2, x2);
        } else {
            if (id == -1) {
                cnt1++;
            } else if (id == 0) {
                cnt2++;
            } else {
                cnt3++;
            }
        }
    }
}