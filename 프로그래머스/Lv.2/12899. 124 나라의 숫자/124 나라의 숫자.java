import java.util.*;

class Solution {
    public String solution(int n) {
        String[] arr = {"4", "1", "2"};
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int idx = n % 3;
            sb.append(arr[idx]);
            if (idx == 0) {
                n -= 1;
            }
            n /= 3;
        }
        return sb.reverse().toString();
    }
}