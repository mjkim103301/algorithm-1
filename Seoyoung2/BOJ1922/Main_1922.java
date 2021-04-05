package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1922. 네트워크 연결
public class Main_1922 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        LinkedList<int[]> list[] = new LinkedList[N];
        for (int i = 0; i < N; i++) {
        	list[i] = new LinkedList<>();
		}
        
        int a, b, c;
        for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken());
			
			list[a].add(new int[] {b, c});
			list[b].add(new int[] {a, c});
		}
        
        boolean[] visit = new boolean[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>(M, (x, y) -> x[1] - y[1]);
        pq.add(new int[] {0, 0});
        
        int[] cur = new int[2];
        int ans = 0, cnt = 1;
        while(!pq.isEmpty()) {
        	cur = pq.poll();
        	if(visit[cur[0]])	continue;
        	visit[cur[0]] = true;
        	
        	ans += cur[1];
        	if(cnt++ == N)	break;

        	for (int[] next : list[cur[0]]) {
				if(!visit[next[0]])	pq.add(next);
			}
        }
        
        System.out.println(ans);
	}
}
