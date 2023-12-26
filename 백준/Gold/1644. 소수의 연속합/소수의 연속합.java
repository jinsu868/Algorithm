import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] primes = new int[n+1];
        int size = 0;
        boolean[] arr = new boolean[n+1];
        arr[1] = true;
        for (int i = 2; i < n+1; i++) {
            if (arr[i] == true) {
                continue;
            }
            for (int j = i*2; j < n+1; j += i) {
                arr[j] = true;
            }
        }
        for (int i = 2; i < n+1; i++) {
            if (arr[i] == false) {
                primes[size++] = i;
            }
        }
        int res = 0;
        int left = 0;
        int right = 0;
        int sum = primes[0];
        while (left <= right) {
            if (sum == n) {
                res++;
                sum -= primes[left++];
            }
            if (sum > n) {
                sum -= primes[left++];
            } else {
                right++;
                if (right < size) {
                    sum += primes[right];
                } else {
                    break;
                }
            }
        }
        System.out.println(res);
    }
}