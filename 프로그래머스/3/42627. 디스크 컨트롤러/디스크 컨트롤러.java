import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>(
            (a, b) -> a.duration - b.duration);
        Arrays.sort(jobs, (a, b) -> a[0]-b[0]);
        int time = 0;
        int jobIdx = 0;
        int res = 0;
        while (true) {
            while (time >= jobs[jobIdx][0]) {
                pq.offer(new Job(jobs[jobIdx][0], jobs[jobIdx][1]));
                jobIdx++;
                if (jobIdx == jobs.length) {
                    break;
                }
            }
            if (jobIdx == jobs.length) {
                break;
            }
            if (!pq.isEmpty()) {
                Job job = pq.poll();
                res += (time - job.arrival + job.duration);
                time += job.duration;
            } else {
                time++;
            }
        }
        while (!pq.isEmpty()) {
            Job job = pq.poll();
            res += (time - job.arrival + job.duration);
            time += job.duration;
        }
        return res / jobs.length;
    }
}

class Job {
    int arrival;
    int duration;
    public Job(int arrival, int duration) {
        this.arrival = arrival;
        this.duration = duration;
    }
}

