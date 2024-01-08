import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int bIdx = 0;
        int bSize = B.length;
        int res = 0;
        
        for (int i = 0; i < A.length; i++) {
            while (bIdx < bSize && B[bIdx] <= A[i]) {
                bIdx++;
            }    
            if (bIdx == bSize) {
                break;
            }
            bIdx++;
            res++;
            
            if (bIdx == bSize) {
                break;
            }
        }
        
        return res;
    }
}