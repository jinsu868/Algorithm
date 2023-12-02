import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (int i = n-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                res[i] = -1;
                stack.push(arr[i]);
            } else {
                int top = 0;
                while (!stack.isEmpty()) {
                    top = stack.pop();
                    if (map.get(top) > map.get(arr[i])) {
                        break;
                    }
                }
                if (map.get(top) > map.get(arr[i])) {
                    res[i] = top;
                    stack.push(top);
                    stack.push(arr[i]);
                } else {
                    res[i] = -1;
                    stack.push(arr[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i] + " ");
        }
        System.out.println(sb);
    }
}