import java.util.*;

class Solution {
    HashMap<String, Integer> map;
    public int solution(String begin, String target, String[] words) {
        map = new HashMap<>();
        Arrays.stream(words)
            .forEach(word -> map.put(word, 0));
        
        bfs(begin, words, target);
        if (!map.containsKey(target)) {
            return 0;
        } else {
            if (map.get(target) == 0) {
                return 0;
            } else {
                return map.get(target) - 1;
            }
        }
    }
    
    private void bfs(String begin, String[] words, String target) {
        map.put(begin, 1);
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        while (!q.isEmpty()) {
            String cur = q.poll();
            for (String word : words) {
                int diffCount = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != cur.charAt(i)) {
                        diffCount++;
                    }
                }
                if (diffCount == 1 && map.get(word) == 0) {
                    map.put(word, map.get(cur) + 1);
                    q.offer(word);
                    if (word.equals(target)) {
                        return;
                    }
                }
            }
        }
    }
}