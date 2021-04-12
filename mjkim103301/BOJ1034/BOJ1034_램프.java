package ssafy.algo.study.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1034_램프 {
    static int N, M, K; // 행 길이, 열 길이, 클릭 수
    static String[] ramp; // 램프 배열
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ramp = new String[N];

        for (int i = 0; i < N; i++) {
            ramp[i] = br.readLine();
        }

        K = Integer.parseInt(br.readLine());

        solution();
        System.out.println(answer);
    }

    static void solution() {
        for (int y = 0; y < N; y++) {
            int zeroCnt = getZeroCnt(y); // 행 별로 0의 개수를 셈

            // 0의 개수가 K이하이고, 둘 다 짝수거나 홀수일 때
            if (zeroCnt <= K && K % 2 == zeroCnt % 2) { 
                int temp = getSamePattern(y); // 같은 패턴의 수를 셈
                if (answer < temp) { // answer 갱신
                    answer = temp;
                }
            }
        }
    }

    static int getZeroCnt(int index) {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (ramp[index].charAt(i) == '0') {
                cnt++;
            }
        }
        return cnt;
    }

    static int getSamePattern(int index) {
        int cnt = 1;
        for (int i = index + 1; i < N; i++) {
            if (ramp[index].equals(ramp[i])) {
                cnt++;
            }
        }
        return cnt;
    }
}
