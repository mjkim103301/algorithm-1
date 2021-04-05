package ssafy.algo.study.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17281_야구_nextPermutation {
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
        for(int i=4;i<9;i++){
            perm[i]=i;
        }
        for(int i=0;i<3;i++){
            perm[i]=i+1;
        }
        perm[3] = 0;

        do{
            int score=calc();
            if(max<score){
                max=score;
            }
        }while(permutation());

    }
    static int temp[];
    static boolean permutation() {
        int i=8, j=8, k=8;
        int target=0;
        temp=Arrays.copyOf(perm, 9);
        while(i>0){
            if(perm[i-1]==0 && i-2>=0 && perm[i-2]<perm[i]){
                target=i-2;
                break;
            }
            if(perm[i-1]!=0 && perm[i-1]<perm[i]){
                target=i-1;
                break;
            }
            i--;
        }
        if(i==0)return false;

        while(true){
            if(perm[j]>perm[target]){
                break;
            }
            j--;
        }

        swap(target, j);

        while(k>i){
            if(perm[i]==0)i++;
            swap(k--, i++);
        }

        return true;
    }

    static void swap(int index1, int index2){
        int temp=perm[index1];
        perm[index1]=perm[index2];
        perm[index2]=temp;
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
