import java.io.*;
import java.util.*;

public class BOJ7507_올림픽게임 {
    static int M;
    static int[][] play;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int test = 1; test <= N; test++) {
            M = Integer.parseInt(br.readLine());
            play = new int[M][3];
            answer = 0;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                play[i][0] = Integer.parseInt(st.nextToken());
                play[i][1] = Integer.parseInt(st.nextToken());
                play[i][2] = Integer.parseInt(st.nextToken());
            }
            solution();
            sb.append("Scenario #" + test + ":\n");
            sb.append(answer + "\n\n");
        }
        System.out.print(sb);
    }

    static void solution() {
        // 날짜, 종료시간, 시작시간 순으로 오름차순 정렬
        Arrays.sort(play, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] == o2[0] && o1[2] > o2[2]) {
                    return 1;
                } else if (o1[0] == o2[0] && o1[2] == o2[2]) {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else if (o1[1] == o2[1]) {
                        return 0;
                    }
                }
                return -1;
            }
        });
        
        int day = play[0][0]; // 첫번째 날짜
        int end = 0; // 끝나는 시간

        for (int i = 0; i < M; i++) {
            if (day == play[i][0] && play[i][1] >= end) { // 날짜가 같으면 시작시간>= 전타임 끝난시간일 때
                answer++;
                end = play[i][2];
            } else if (day < play[i][0]) {// 날짜가 다를 때
                answer++;
                day = play[i][0];
                end = play[i][2];
            }
        }
    }
}
