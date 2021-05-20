import java.util.*;
import java.io.*;

public class BOJ14002_가장긴_증가하는_부분수열4 {
    static int N;
    static int[] arr, dp;
    static int size;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(size);
        System.out.println(sb);

    }

    static void solution() {
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        size = max;
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == max) {
                stack.push(arr[i]);
                max--;
                if (max == 0) break;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
    }

}
