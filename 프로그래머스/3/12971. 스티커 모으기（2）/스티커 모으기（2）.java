class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        int[][] dp1 = new int[n][2];
        int[][] dp2 = new int[n][2];
        
        if (n == 1) {
            return sticker[0];
        } else if (n == 2) {
            return Math.max(sticker[0], sticker[1]);
        } 
        
        //첫칸을 뜯는 경우
        dp1[0][1] = sticker[0];
        dp1[0][0] = Integer.MIN_VALUE;
        dp1[1][0] = sticker[0];
        dp1[1][1] = Integer.MIN_VALUE;
        
        for (int i = 2; i < n-1; i++) {
            dp1[i][0] = Math.max(dp1[i-1][0], dp1[i-1][1]);
            dp1[i][1] = sticker[i] + Math.max(dp1[i-2][0], dp1[i-2][1]);
        }
        
        //첫칸을 뜯지 않는 경우
        dp2[0][0] = 0;
        dp2[0][1] = Integer.MIN_VALUE;
        dp2[1][0] = 0;
        dp2[1][1] = sticker[1];
        
        for (int i = 2; i < n; i++) {
            dp2[i][0] = Math.max(dp2[i-1][0], dp2[i-1][1]);
            dp2[i][1] = sticker[i] + Math.max(dp2[i-2][0], dp2[i-2][1]);
        }
        
        int a = Math.max(dp1[n-2][0], dp1[n-2][1]);
        int b = Math.max(dp2[n-1][0], dp2[n-1][1]);
        return Math.max(a, b);
    }
}