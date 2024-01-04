import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < operations.length; i++) {
            String[] op = operations[i].split(" ");
            if (op[0].equals("I")) {
                maxHeap.offer(Integer.parseInt(op[1]));
                minHeap.offer(Integer.parseInt(op[1]));
            } else {
                if (minHeap.isEmpty()) {
                    continue;
                }
                
                if (op[1].equals("1")) {
                    minHeap.remove(maxHeap.poll());
                } else {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        int[] res = new int[2];
        if (maxHeap.isEmpty()) {
            return res;
        } else {
        res[0] = maxHeap.poll();
        res[1] = minHeap.poll();
            return res;
        }
    }
}