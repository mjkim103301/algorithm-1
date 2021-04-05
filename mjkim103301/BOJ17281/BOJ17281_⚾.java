import java.util.*;
import java.io.*;

public class BOJ17281_야구 {
    static int N;
    static int[][] player;
    static int[] perm; // 순열
    static boolean[] used;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        player = new int[N][9];
        perm = new int[9];
        used = new boolean[9];

        // 0번 index부터 넣음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
        System.out.println(max);
    }

    static void solution() {
        //0번 index 부터 시작
        used[0] = true; // index 0 사용했다고 표시
        perm[3] = 0; // 3번째에 참조할 index = 0
        permutation(0);
    }

    static void permutation(int level) {
        if (level == 3) { //perm[3]은 항상 0이므로 level+1 함
            level++;
        }
        if (level == 9) {
            int score = calc();
            if (max < score) {
                max = score;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (used[i]) continue;
            used[i] = true;
            perm[level] = i;
            permutation(level + 1);
            if (i != 0) { // perm[3]=0 이므로 used[0] 은 항상 true
                used[i] = false;
            }
        }
    }

    static int calc() {
        int out = 0; // 아웃
        int firstBase = 0; //1루
        int secondBase = 0; //2루
        int thirdBase = 0; //3루
        int inning = 0; //이닝
        int index = 0; // 순열 index
        int score = 0;

        while (inning < N) {
            int go = player[inning][perm[index]];
            if (go > 0) {
                if (go == 1) { //안타
                    score += thirdBase;
                    thirdBase = secondBase;
                    secondBase = firstBase;
                    firstBase = 1;
                } else if (go == 2) { //2루타
                    score += secondBase + thirdBase;
                    thirdBase = firstBase;
                    secondBase = 1;
                    firstBase = 0;
                } else if (go == 3) { //3루타
                    score += firstBase + secondBase + thirdBase;
                    firstBase = 0;
                    secondBase = 0;
                    thirdBase = 1;
                } else if (go == 4) {// 홈런
                    score += firstBase + secondBase + thirdBase + 1;
                    firstBase = 0;
                    secondBase = 0;
                    thirdBase = 0;
                }
            } else { // 아웃
                out++;
            }
            index = (index + 1) % 9;

            // 아웃이 3개일 때 inning+1, 다른 변수 초기화
            if (out == 3) {
                inning++;
                out = 0;
                firstBase = 0;
                secondBase = 0;
                thirdBase = 0;
            }

        }
        return score;
    }
}

