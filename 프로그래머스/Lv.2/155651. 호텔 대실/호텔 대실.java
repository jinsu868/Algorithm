import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < book_time.length; i++) {
            String[] meeting = book_time[i];
            String[] start = meeting[0].split(":");
            String[] end = meeting[1].split(":");
            int s = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int e = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            meetings.add(new Meeting(s, e));
        }
        Collections.sort(meetings, (a, b) -> a.s - b.s);
        pq.add(meetings.get(0).e);
        for (int i = 1; i < meetings.size(); i++) {
            Meeting meet = meetings.get(i);
            int e = pq.poll();
            if (e <= meet.s) {
                pq.offer(meet.e);
            } else {
                pq.offer(e);
                pq.offer(meet.e);
            }
        }
    
        return pq.size();
    }
}

class Meeting {
    int s;
    int e;
    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }
}