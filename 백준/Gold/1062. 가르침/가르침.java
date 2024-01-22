import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int n;
    static String[] words;
    static boolean[] learnedWords;
    static int res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        learnedWords = new boolean[26];
        words = new String[n];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            words[i] = temp.substring(4, temp.length()-4);
        }
        learnedWords['a' - 'a'] = true;
        learnedWords['n' - 'a'] = true;
        learnedWords['t' - 'a'] = true;
        learnedWords['i' - 'a'] = true;
        learnedWords['c' - 'a'] = true;

        if (k < 5) {
            System.out.println(0);
            System.exit(0);
        }
        if (k == 26) {
            System.out.println(n);
            System.exit(0);
        }

        dfs(0, 0);
        System.out.println(res);
    }

    private static void dfs(int depth, int start) {
        if (depth == k - 5) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                String word = words[i];
                boolean flag = true;
                for (int j = 0; j < word.length(); j++) {
                    if (learnedWords[word.charAt(j)-'a'] == false) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    count++;
                }
            }
            res = Math.max(res, count);
            return;
        }
        for (int i = start; i < 26; i++) {
            if (learnedWords[i] == false) {
                learnedWords[i] = true;
                dfs(depth+1, i);
                learnedWords[i] = false;
            }
        }
    }
}