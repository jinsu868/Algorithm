import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int s = 0;
        int e = Integer.MAX_VALUE;
        
        int res = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (check(stones, mid, k)) {
                res = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return res;
    }

    private boolean check(int[] stones, int n, int k) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < n) {
                count++;
                if (count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        return true;
    }
}