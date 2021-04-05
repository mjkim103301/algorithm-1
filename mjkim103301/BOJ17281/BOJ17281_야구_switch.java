package ssafy.algo.study.week08;

import java.util.*;
import java.io.*;

public class BOJ17281_야구_switch {
    static int N;
    static int[][] player;
    static int[] perm;
    static boolean[] used;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        player = new int[N][9];
        perm = new int[9];
        used = new boolean[9];

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
        used[0] = true;
        perm[3] = 0;
        permutation(0);
    }

    static void permutation(int level) {
        if (level == 3) {
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
            if (i != 0) {
                used[i] = false;
            }
        }
    }

    static int calc() {
        int out=0;
        int firstBase=0,secondBase=0,thirdBase=0;

        int inning=0;
        int index=0;
        int score=0;

        while(inning<N){
            int go=player[inning][perm[index]];
            switch (go){
                case 1:
                    score+=thirdBase;
                    thirdBase=secondBase;
                    secondBase=firstBase;
                    firstBase=1;
                    break;
                case 2:
                    score+=secondBase+thirdBase;
                    thirdBase=firstBase;
                    secondBase=1;
                    firstBase=0;
                    break;
                case 3:
                    score+=firstBase+secondBase+thirdBase;
                    firstBase=0;
                    secondBase=0;
                    thirdBase=1;
                    break;
                case 4:
                    score+=firstBase+secondBase+thirdBase+1;
                    firstBase=0;
                    secondBase=0;
                    thirdBase=0;
                    break;
                case 0:
                    out++;
                    break;

            }
            index=(index+1)%9;
            if(out==3){
                inning++;
                out=0;
                firstBase=0;
                secondBase=0;
                thirdBase=0;
            }
        }
        return score;
    }
}
