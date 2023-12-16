import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }

    static void hanoi(int n, int from, int via, int to) {
        if (n == 0) {
            return;
        }
        count++;
        hanoi(n-1, from, to, via);
        sb.append(from + " " + to + "\n");
        hanoi(n-1, via, from, to);
    }
}