class Solution {
    private int res = 0;
    private boolean[] visit;
    private boolean flag = false;
    public int solution(String[] user_id, String[] banned_id) {
        visit = new boolean[user_id.length];
        dfs(0, 0, user_id.length, banned_id.length, user_id, banned_id);

        return res;
    }

    private void dfs(int depth, int v, int uSize, int bSize,
                     String[] user_id, String[] banned_id) {
        if (depth == bSize) {
            flag = false;
            String[] output = new String[bSize];
            String[] arr = new String[bSize];
            boolean[] visit2 = new boolean[bSize];
            int idx = 0;
            for (int i = 0; i < uSize; i++) {
                if (visit[i] == true) {
                    arr[idx++] = user_id[i];
                }
            }
            permutation(0, bSize, output, arr, visit2, banned_id);
            if (flag == true) {
                res++;
            }
            return;
        }

        for (int i = v; i < uSize; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                dfs(depth+1, i, uSize, bSize, user_id, banned_id);
                visit[i] = false;
            }
        }
    }

    private void permutation(int depth, int n, String[] output,
                             String[] arr, boolean[] visit2,
                             String[] banned_id) {
        if (depth == n) {
            boolean isSame = true;
            for (int i = 0; i < n; i++) {
                if (output[i].length() != banned_id[i].length()) {
                    isSame = false;
                    break;
                }
                for (int j = 0; j < output[i].length(); j++) {
                    if (banned_id[i].charAt(j) != output[i].charAt(j)) {
                        if (banned_id[i].charAt(j) == '*') {
                            continue;
                        } else {
                            isSame = false;
                            break;
                        }
                    }
                }
            }
            if (isSame == true) {
                flag = true;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit2[i] == false) {
                visit2[i] = true;
                output[depth] = arr[i];
                permutation(depth+1, n, output, arr, visit2, banned_id);
                visit2[i] = false;
            }
        }
    }
              
}