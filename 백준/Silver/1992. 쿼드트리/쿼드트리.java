import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(line.charAt(j)+"");
            }
        }
        solution(grid, 0, 0, n-1, n-1);
    }

    static void solution(int[][] grid, int y1, int x1, int y2, int x2) {
        if (x1 == x2) {
            System.out.print(grid[y1][x1]);
            return;
        }
        int color = grid[y1][x1];
        boolean flag = true;
        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                if (grid[y][x] != color) {
                    flag = false;
                }
            }
            if (flag == false) {
                break;
            }
        }
        if (flag == false) {
            int xMid = (x1 + x2) / 2;
            int yMid = (y1 + y2) / 2;
            System.out.print("(");
            solution(grid, y1, x1, yMid, xMid);
            solution(grid, y1, xMid+1, yMid, x2);
            solution(grid, yMid+1, x1, y2, xMid);
            solution(grid, yMid+1, xMid+1, y2, x2);
            System.out.print(")");
        } else {
            System.out.print(color);
        }
    }
}