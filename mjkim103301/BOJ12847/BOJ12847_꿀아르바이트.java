import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12847_꿀아르바이트 {
    static int N, M;
    static int[] money;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        money = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        solution();
        System.out.println(answer);
    }

    static void solution() {
        long temp = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            temp += money[i];
            cnt++;
            if (cnt == M) { // M일 일을 했을 때
                if (answer < temp) { //현재까지 일해서 버는 돈이 많으면 answer 갱신
                    answer = temp;
                }
                cnt--;
                temp = temp - money[i - cnt]; //일을 처음 시작한 날의 돈 빼기
            }
        }
    }
}
