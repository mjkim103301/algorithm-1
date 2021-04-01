package com.Boj.seoul8.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_S1_16918_봄버맨 {
	static class Boom {
		int r, c;

		public Boom(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int R, C, N;
	static char map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Boom> boomArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'O') {
					map[i][j] = '0'; // 폭탄의 시간초 계산을 위해 0으로 바꿔줌		
				}

			}
		}

		// 초만큼 반복
		boomArr = new ArrayList<Boom>();
		for (int t = 1; t <= N; t++) {

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (t % 2 == 0) {
						if (map[i][j] == '.')
							map[i][j] = '0' - 1; // 바뀐 폭탄은 설치되자마자 1초가 되면 안돼서 -1 로 해줬다. 순서때문에 ...
					}
					// 폭탄인 경우 +1초
					if (map[i][j] != '.') {
						map[i][j] += 1;
					}
					if (map[i][j] == '3') {
						boomArr.add(new Boom(i, j));
					}
				}
			}
			// 폭탄들 다 터트리기
			for (Boom boom : boomArr) {
				boomboom(boom.r, boom.c);
			}
			boomArr.clear();

		}
		changeMap(); // 폭탄은 다 'O'으로 통일하기 위해

		print();

	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void changeMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '.')
					map[i][j] = 'O';
			}
		}

	}

	private static void boomboom(int r, int c) {
		int nr, nc;
		map[r][c] = '.';
		for (int i = 0; i < 4; i++) {
			nr = dr[i] + r;
			nc = dc[i] + c;
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != '3') {
				map[nr][nc] = '.';
			}
		}

	}

}

