import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();
            if (set.contains(a)) {
                set.add(b);
            }
            if (set.contains(b)) {
                set.add(a);
            }
        }
        System.out.println(set.size());
    }
}