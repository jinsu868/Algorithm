import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] line = br.readLine().split(" ");
            if (line.length == 1) {
                if (line[0].equals("size")) {
                    sb.append(q.size() + "\n");
                } else if (line[0].equals("front")) {
                    if (q.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(q.peekFirst() + "\n");
                    }
                } else if (line[0].equals("back")) {
                    if (q.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(q.peekLast() + "\n");
                    }
                } else if (line[0].equals("empty")) {
                    if (q.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                } else if (line[0].equals("pop")) {
                    if (q.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(q.poll() + "\n");
                    }
                }
            } else {
                q.add(Integer.parseInt(line[1]));
            }
        }
        System.out.println(sb);
    }
}
