import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        int count = set.size();
        int[] res = new int[2];
        int right = Integer.MAX_VALUE;
        int left = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            if (map.containsKey(gems[i])) {
                map.put(gems[i], map.get(gems[i]) + 1);
            } else {
                map.put(gems[i], 1);
            }
            while (map.get(gems[left]) > 1) {
                map.put(gems[left], map.get(gems[left])-1);
                left++;
            }
            
            if (map.size() == count && right > (i - left)) {
                right = i - left;
                res[0] = left+1;
                res[1] = i+1;
            }            
        } 
        return res;
    }
}