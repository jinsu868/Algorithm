import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        int lcm = (y1 * y2) / gcd(y1, y2);
        int a = (lcm / y1) * x1;
        int b = (lcm / y2) * x2;
        int c = (a + b);
        int div = gcd(lcm, c);

        System.out.println(((a+b) / div) + " " + (lcm / div));
    }

    public static int gcd(int x, int y) {
        if (y > x) {
            int temp = x;
            x = y;
            y = temp;
        }
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}