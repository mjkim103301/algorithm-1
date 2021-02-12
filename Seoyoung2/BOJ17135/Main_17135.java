package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 17135. 캐슬 디펜스
public class Main_17135 {
	static int N, M, D;
	static int[][] map, t_map;
	static int ans;
	static int[][] dxdy = {{0, -1}, {-1, 0}, {0, 1}};
	static int[] our = new int[3];

	static class Node{
		int x, y, dist;
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.dist = d;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		map = new int[N+1][M];
		t_map = new int[N+1][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		for (int i = 0; i < M; i++)
			map[N][i] = 5;	// 성은 5로 설정
		
		// 궁수 3명 배치
		combi(0, 0);
		System.out.println(ans);
	}
	
	static void combi(int idx, int start) {
		if(idx == 3) {
			// map 복사본 만들기 (t_map)
			for (int i = 0; i < N+1; i++)
				System.arraycopy(map[i], 0, t_map[i], 0, M);
			// 궁수가 있는 자리: 2
			for (int o : our)
				t_map[N][o] = 2;
			
			ans = Math.max(ans, shoot());
			return;
		}
		for (int i = start; i < M; i++) {
			our[idx] = i;
			combi(idx+1, i+1);
		}
	}
	
	static int shoot() {
		int nx, ny, cnt=0;
		boolean[][] visit;
		while(true) {
			LinkedList <Node> kill = new LinkedList<>();	// 없앨 수 있는 적 저장
			for (int i = 0; i < M; i++) {
				if(t_map[N][i] != 2)	continue;
				
				// 궁수일때 거리계산 시작 (궁수위치 : N,i)
				visit = new boolean[N+1][M];
				Queue<Node> q = new LinkedList<Node>();
				q.offer(new Node(N, i, 0));
				top:
				while(!q.isEmpty()) {
					Node no = q.poll();
					if(no.dist+1 > D) break;

					for (int j = 0; j < 3; j++) {
						nx = no.x + dxdy[j][0];
						ny = no.y + dxdy[j][1];
						if(nx<0 || ny<0 || ny>=M)	continue;
							
						// 아무것도 없다면
						if(!visit[nx][ny] && t_map[nx][ny] == 0) {
							q.offer(new Node(nx, ny, no.dist+1));
							visit[nx][ny] = true;
						}
						// 적을 만났다면
						else if(t_map[nx][ny] == 1) {
							kill.add(new Node(nx, ny, no.dist+1));
							break top;
						}
					}
				}
			}
			// 적 죽이기
			for (Node node : kill) {
				if(t_map[node.x][node.y] == 1) {
					t_map[node.x][node.y] = 0;
					cnt++;
				}
			}
			
			// 남은 적이 있는지 검사
			boolean again = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(t_map[i][j] == 1)	again = true;
				}
			}
			if(!again)	break;
			
			// 한칸씩 내려옴
			for (int i = N-2; i >= 0; i--)
				System.arraycopy(t_map[i], 0, t_map[i+1], 0, M);
			for (int i = 0; i < M; i++)
				t_map[0][i] = 0;
		}
		return cnt;
	}
}
