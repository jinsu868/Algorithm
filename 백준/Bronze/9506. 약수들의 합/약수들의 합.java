import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }
            List<Integer> temp = new ArrayList<>();
            int ac = 0;
            for (int i = 1; i < n/2 + 1; i++) {
                if (n % i == 0) {
                    temp.add(i);
                    ac += i;
                }
            }
            if (ac == n) {
                sb.append(n + " = ");
                sb.append(temp.stream()
                        .map(s -> s + "")
                        .collect(Collectors.joining(" + ")) + "\n");
            } else {
                sb.append(n + " is NOT perfect.\n");
            }
        }
        System.out.println(sb);
    }
}