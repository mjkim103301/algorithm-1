import java.util.*;

public class BOJ2631_줄세우기 {
    static int N;
    static int[] arr, dp;
    static int answer;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        arr = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }

        solution();
        System.out.println(answer);
    }

    static void solution() {
        Arrays.fill(dp, 1); // 모든 수는 최장수열의 첫번째 후보
        int max = 0; // 최장수열의 길이
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // arr 의 현재 값(i)이 이전 값(j)보다 크고, 이전의 기록된 값보다 현재 기록될 값이 더 클 때
                // dp[i] 갱신
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if (max < dp[i]) {
                        max = dp[i];
                    }
                }
            }
        }

        //답 = 전체 수의 개수 - 최장수열의 길이
        answer = N - max;
    }
}
