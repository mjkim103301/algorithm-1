import java.io.*;
import java.util.*;

//투 포인터
public class BOJ2003_수들의합2_2 {
    static int N, M; //N: 수의 개수, M: 수의 합
    static int[] arr; //arr: 입력된 수들이 저장된 배열, accum: 누적합
    static int cnt; //경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
        System.out.print(cnt);
    }

    static void solution() {
        int sum = 0;
        int left = 0;
        int right = 0;

        while (true) {
            if (sum < M && right < N) {
                sum += arr[right++];

            } else if (sum == M) {
                cnt++;
                sum -= arr[left++];

            } else if (sum > M) {
                sum -= arr[left++];

            } else if (right == N) {
                break;
            }
        }
    }
}
