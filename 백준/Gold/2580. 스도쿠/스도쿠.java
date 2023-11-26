import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int blankCount = 0;
    static boolean flag = false;
    static List<Position> blank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        grid = new int[10][10];
        blank = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 0) {
                    blank.add(new Position(i, j));
                    blankCount++;
                }
            }
        }

        dfs(0);

    }

    static boolean isValid(int y, int x, int val) {
        if (isValidRow(x, val) && isValidCol(y, val) && isValidSquare(y, x, val)) {
            return true;
        }
        return false;
    }

    static boolean isValidRow(int x, int val) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][x] == val) {
                return false;
            }
        }
        return true;
    }

    static boolean isValidCol(int y, int val) {
        for (int j = 0; j < 9; j++) {
            if (grid[y][j] == val) {
                return false;
            }
        }
        return true;
    }

    static boolean isValidSquare(int y, int x, int val) {
        int startY = 3 * (y / 3);
        int startX = 3 * (x / 3);
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (grid[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    static void dfs(int idx) {
        if (idx == blank.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        Position cur = blank.get(idx);
        for (int i = 1; i < 10; i++) {
            if (grid[cur.y][cur.x] == 0) {
                if (isValid(cur.y, cur.x, i)) {
                    grid[cur.y][cur.x] = i;
                    dfs(idx + 1);
                    grid[cur.y][cur.x] = 0;
                }
            }
        }

    }

    static class Position {
        int y;
        int x;
        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}