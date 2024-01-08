class Solution {
    public int solution(int n, int[] stations, int w) {
        int range = 0;
        int res = 0;
        for (int i = 0; i <= stations.length; i++) {
            if (i == 0) {
                range = stations[0] - w - 1;
            } else if (i == stations.length) {
                range = n - (stations[i-1] + w);
            } else {
                range = stations[i] - stations[i-1] - (2 * w + 1);
            }
            
            if (range > 0) {
                res += range / (2 * w + 1);
                if (range % (2 * w + 1) != 0) {
                    res++;
                }
            }
        }
        return res;
    }
}