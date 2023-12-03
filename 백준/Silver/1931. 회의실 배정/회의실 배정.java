import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Meeting> meets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meets.add(new Meeting(s, e));
        }

        Collections.sort(meets);
        int res = 0;
        int end = 0;
        for (Meeting meet : meets) {
            if (end <= meet.s) {
                res += 1;
                end = meet.e;
            }
        }
        System.out.println(res);
    }

    static class Meeting implements Comparable<Meeting> {
        int s;
        int e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Meeting m) {
            if (e == m.e) {
                if (s > m.s) {
                    return 1;
                } else if (s == e) {
                    return 0;
                } else {
                    return -1;
                }
            } else if (e > m.e){
                return 1;
            } else {
                return -1;
            }
        }
    }
}