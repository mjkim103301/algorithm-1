package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 16918. 봄버맨
public class Main_16918 {
	static int R, C, N;
	static LinkedList<int[]> bomb = new LinkedList<>();
	static int[][] dxdy = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if(line.charAt(j) == 'O')	map[i][j] = true;
				if(map[i][j])	bomb.add(new int[] {i, j});
			}
		}
		
		// 1 0 2 0 1 0 2 0 반복
		if(N % 2 == 0) {
			fillBomb();
		} else if(N > 2) {
			fillBomb();
			removeBomb();
			if(N % 4 == 1) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(map[i][j])	bomb.add(new int[] {i, j});
					}
				}
				fillBomb();
				removeBomb();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (boolean[] boo : map) {
			for (boolean b : boo) {
				if(b)	sb.append("O");	
				else	sb.append(".");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void fillBomb() {
		for (int i = 0; i < R; i++) {
			Arrays.fill(map[i], true);
		}
	}
	static void removeBomb() {
		int  x, y, nx, ny;
		while(!bomb.isEmpty()) {
			x = bomb.peek()[0];
			y = bomb.poll()[1];
			map[x][y] = false;
			for (int i = 0; i < 4; i++) {
				nx = x + dxdy[i][0];
				ny = y + dxdy[i][1];
				if(nx<0 || nx>=R || ny<0 || ny>=C || !map[nx][ny])	continue;
				map[nx][ny] = false;
			}
		}
	}
}