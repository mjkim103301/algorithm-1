package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1303. 전쟁 - 전투
public class Main_1303 {
	static int[][] dxdy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] map;
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();	// col
		N = sc.nextInt();	// row
		
		map = new char[N][M];	// 우리팀 W, 적군 B, 체크했으면 X
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int me = 0, you = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'W') {
					me += bfs(i, j, 'W');
				}else if(map[i][j] == 'B') {
					you += bfs(i, j, 'B');
				}
			}
		}
		System.out.println(me + " " + you);
	}
	
	private static int bfs(int px, int py, char ch) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {px, py});

		int score = 1;
		map[px][py] = 'X';

		int x, y, nx, ny;
		while(!q.isEmpty()) {
			x = q.peek()[0];
			y = q.poll()[1];
			for (int i = 0; i < 4; i++) {
				nx = x + dxdy[i][0];
				ny = y + dxdy[i][1];
				if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] != ch)	continue;
				
				score += 1;
				map[nx][ny] = 'X';
				q.offer(new int[] {nx, ny});
			}
		}
		return score*score;
	}
}
