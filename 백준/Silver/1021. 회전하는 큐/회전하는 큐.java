import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer> dq = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> targets = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            dq.offer(i);
        }
        for (int i = 0; i < m; i++) {
            targets.add(Integer.parseInt(st.nextToken()));
        }
        int res = 0;
        for (int target : targets) {
            while (dq.peekFirst() != target) {
                if (isLeft(target)) {
                    dq.addLast(dq.pollFirst());
                    res++;
                } else {
                    dq.addFirst(dq.pollLast());
                    res++;
                }
            }
            dq.poll();
        }
        System.out.println(res);
    }

    static boolean isLeft(int target) {
        for (int i = 0; i <= dq.size() / 2; i++) {
            if(dq.get(i) == target) {
                return true;
            }
        }
        return false;
    }
}