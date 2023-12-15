import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) {
                continue;
            }
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        ArrayList<Entry<String, Integer>> result = new ArrayList<>(map.entrySet());
        Collections.sort(result, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    if (o1.getKey().length() == o2.getKey().length()) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getKey().length() - o1.getKey().length();
                }
                return o2.getValue() - o1.getValue();
            }
        });

        result.stream()
                .forEach(entry -> sb.append(entry.getKey()).append('\n'));
        System.out.println(sb);
    }
}