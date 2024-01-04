import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int time : works) {
            pq.offer(-time);
        }
        
        while (n-- > 0) {
            if (pq.isEmpty()) {
                break;
            }
            int time = -pq.poll();
            time -= 1;
            if (time != 0) {
                pq.offer(-time);
            }
        }
        
        long res = 0;
        while (!pq.isEmpty()) {
            long temp = pq.poll();
            res += temp * temp;
        }
        return res;
    }
}