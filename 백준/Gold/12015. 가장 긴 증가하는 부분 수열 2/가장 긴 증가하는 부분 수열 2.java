import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] subSequence = new int[n];
        subSequence[0] = arr[0];
        int subSize = 1;
        for (int i = 1; i < n; i++) {
            if (subSequence[subSize-1] < arr[i]) {
                subSequence[subSize++] = arr[i];
            } else {
                int s = 0;
                int e = subSize-1;
                int pos = 0;
                while (s <= e) {
                    int mid = (s + e) / 2;
                    if (subSequence[mid] == arr[i]) {
                        pos = mid;
                        break;
                    } else if (subSequence[mid] >= arr[i]){
                        e = mid-1;
                        pos = mid;
                    } else {
                        s = mid+1;
                    }
                }
                subSequence[pos] = arr[i];
            }
        }
        System.out.println(subSize);
    }
}