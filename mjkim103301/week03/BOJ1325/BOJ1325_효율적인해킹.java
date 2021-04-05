package ssafy.algo.study.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1325_효율적인해킹 {

    static int N, M;
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int[]memo; //해당 열에서 방문할 수 있는 노드 개수
    static int max;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            map[i]= new ArrayList<>();
        }

        memo=new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken()); //신뢰하는 주체
            int x =Integer.parseInt(st.nextToken()); //신뢰하는 대상
            map[y].add(x);
        }
        solution();
        print();
    }

    //memo 배열을 순회하면서 max 값과 일치하는 index를 출력
    //작은 열 번호부터 순회하기 때문에 정렬하지 않아도 됨.
    static void print() {
        
       for(int y=1;y<=N;y++){
           if(max==memo[y]){
               System.out.print(y+" ");
           }
       }
    }

    static void solution() {

        for (int y = 1; y <= N; y++) {
            visited=new boolean[N+1];
            dfs(y);
        }
    }

    //DFS를 돌면서 next(다음에 갈 번호: x) 가 신뢰받는 횟수 ++ 
    //max 값 갱신
    static void dfs(int y) {
        visited[y] = true;

        for(int next:map[y]) {
            if (visited[next]) continue;
            memo[next]++;
            max = Math.max(max, memo[next]);
            dfs(next);
        }

    }
}
