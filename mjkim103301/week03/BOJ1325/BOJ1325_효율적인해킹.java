package ssafy.algo.study.week03;

import java.util.*;

public class BOJ1325_효율적인해킹 {

    static int N, M;
    static ArrayList<ArrayList<Integer>> map;
    static ArrayList<Integer> computer;
    static boolean[] visited;
    static int[]memo;
    static int cnt, max;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        map = new ArrayList<>(N);
        computer = new ArrayList<>(N);

        for (int i = 0; i <= N; i++) {
            map.add(i, new ArrayList<>(N));
        }
        visited = new boolean[N + 1];
        memo=new int[N+1];

        for (int i = 0; i < M; i++) {
            int y = scan.nextInt();
            int x = scan.nextInt();
            map.get(y).add(x);
        }

        solution();
        print();
    }

    static void print() {
        StringBuilder sb = new StringBuilder();

       for(int y=1;y<=N;y++){
           if(max==memo[y]){
               sb.append(y+" ");
           }
       }
        System.out.print(sb);
    }

    static void solution() {

        for (int y = 1; y <= N; y++) {

            visited=new boolean[N+1];
            dfs(y);

        }

        for(int y=1;y<=N;y++){
            max=Math.max(max, memo[y]);
        }

    }

    static void dfs(int y) {
        visited[y] = true;

        int end=map.get(y).size();
        for(int x=0;x<end;x++){
            int next=map.get(y).get(x);
            if(visited[next]) continue;
            memo[next]++;
            dfs(next);
        }

    }
}
