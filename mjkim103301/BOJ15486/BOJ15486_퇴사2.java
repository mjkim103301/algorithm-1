import java.io.*;
import java.util.*;

public class BOJ15486_퇴사2 {
    static int N;
    static int[][] inform;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        inform = new int[N + 1][3];
        dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            inform[i][0] = i; //시작일
            inform[i][1] = i + start - 1; // 종료일
            inform[i][2] = Integer.parseInt(st.nextToken()); // 금액
        }
        solution();
        System.out.println(dp[1]);
    }

    static void solution() {
        for (int i = N; i >= 1; i--) {
            if (inform[i][1] > N) {// 종료일이 N보다 클 때
                dp[i] = dp[i + 1];
            } else {
                int end = inform[i][1];
                dp[i] = Math.max(dp[end + 1] + inform[i][2], dp[i + 1]);
            }
        }
    }
}
