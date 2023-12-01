import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Building> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] top = new int[n+1];
        int[] res = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n+1; i++) {
            if (stack.empty()) {
                res[i] = 0;
                stack.push(new Building(top[i], i));
                continue;
            }
            while (!stack.isEmpty()) {
                Building building = stack.pop();
                if (building.height >= top[i]) {
                    stack.push(building);
                    stack.push(new Building(top[i], i));
                    res[i] = building.index;
                    break;
                }
            }
            if (stack.isEmpty()) {
                res[i] = 0;
                stack.push(new Building(top[i], i));
            }
        }

        for (int i = 1; i < n+1; i++) {
            sb.append(res[i] + " ");
        }
        System.out.println(sb);
    }

    static class Building {
        int height;
        int index;

        Building(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}