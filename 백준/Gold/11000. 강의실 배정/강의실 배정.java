import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Meeting> meets = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meets.add(new Meeting(s, e));
        }
        Collections.sort(meets);

        for (Meeting meet : meets) {
            if (pq.isEmpty()) {
                pq.offer(meet.e);
                continue;
            }
            int minEndTime = pq.peek();

            if (meet.s < minEndTime) {
                pq.offer(meet.e);
            } else {
                pq.poll();
                pq.offer(meet.e);
            }
        }

        System.out.println(pq.size());
    }

    static class Meeting implements Comparable<Meeting> {
        int s;
        int e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Meeting m) {
            if (s == m.s) {
                if (e > m.e) {
                    return 1;
                } else if (e == m.e) {
                    return 0;
                } else {
                    return -1;
                }
            } else if (s > m.s) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}