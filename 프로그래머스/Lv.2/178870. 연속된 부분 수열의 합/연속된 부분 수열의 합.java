class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int length = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (left <= right && right < sequence.length) {
            if (sum > k) {
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                right++;
                if (right == sequence.length) {
                    break;
                }
                sum += sequence[right];
            } else {
                if (length > right - left + 1) {
                    length = right - left + 1;
                    answer[0] = left;
                    answer[1] = right;                    
                }
                sum -= sequence[left];
                left++;
            }
        }
        
        
        return answer;
    }
}