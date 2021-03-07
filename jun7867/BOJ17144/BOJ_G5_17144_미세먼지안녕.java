package com.Boj.seoul8.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Air {
	int r, c;

	public Air(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

}

public class BOJ_G5_17144_미세먼지안녕 {
	static int R, C, T, sumDust = 0;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int nr, nc, ar, ac;
	static int[][][] map;
	static List<Air> air = new ArrayList<>(2);

	private static void moveTop(int tc) {
		int cnt = 0;
		Air airClean = air.get(0);
		ar = airClean.r; // 첫번째 제거 타켓
		ac = airClean.c;
		int diffR = ar - 1; // 세로 이동 수
		int diffC = C - 1; // 가로 이동 수
		sumDust -= map[ar - 1][ac][tc];

		while (true) {
			if (cnt < diffR) {
				ar--;
				map[ar][ac][tc] = map[ar - 1][ac][tc];
			} else if (cnt < diffR + diffC) {
				map[ar - 1][ac][tc] = map[ar - 1][++ac][tc];
			} else if (cnt < diffR * 2 + diffC + 1) {
				map[ar - 1][ac][tc] = map[ar++][ac][tc];
			} else if (cnt < diffR * 2 + diffC * 2) {
				map[ar - 1][ac][tc] = map[ar - 1][--ac][tc];
			} else {
				map[ar - 1][ac][tc] = 0;
				break;
			}
			cnt++;
		}
	}

	private static void moveDown(int tc) {
		int cnt = 0;
		Air airClean = air.get(1);
		ar = airClean.r; // 첫번째 제거 타켓
		ac = airClean.c;
		int diffR = R - ar - 2; // 세로 이동 수
		int diffC = C - 1; // 가로 이동 수
		sumDust -= map[ar + 1][ac][tc];

		while (true) {
			if (cnt < diffR) {
				ar++;
				map[ar][ac][tc] = map[ar + 1][ac][tc];
			} else if (cnt < diffR + diffC) {
				map[ar + 1][ac][tc] = map[ar + 1][++ac][tc];
			} else if (cnt < diffR * 2 + diffC + 1) {
				map[ar + 1][ac][tc] = map[ar--][ac][tc];
			} else if (cnt < diffR * 2 + diffC * 2) {
				map[ar + 1][ac][tc] = map[ar + 1][--ac][tc];
			} else {
				map[ar + 1][ac][tc] = 0;
				break;
			}
			cnt++;
		}
	}

	private static void spread(int tc) {
		// 공기청정기 위치를 복사
		map[air.get(0).r][0][tc] = -1;
		map[air.get(1).r][0][tc] = -1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 먼지가 있을 경우만 확산
				if (map[i][j][tc - 1] > 0) {
					int sum = 0; // 확산한 먼지의 합
					for (int d = 0; d < 4; d++) {
						nr = i + dr[d];
						nc = j + dc[d];
						// 범위를 초과하지 않고 공기청정기 위치가 아닐 경우만 확산
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc][tc - 1] != -1) {
							map[nr][nc][tc] += map[i][j][tc - 1] / 5;
							sum += map[i][j][tc - 1] / 5;
						}
					}
					// (기존 먼지 - 확산한 먼지) 만큼 + 업데이트
					map[i][j][tc] += map[i][j][tc - 1] - sum;
				}

			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C][T + 1];
		// step 1. 초기값 저장
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				if (map[i][j][0] == -1)
					air.add(new Air(i, j));
				else
					sumDust += map[i][j][0]; // 전체 미세먼지양 미리 구하기
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			// step 2. 미세먼지 확산
			spread(tc);
			// step 3. T초당 미세먼지 이동
			moveTop(tc);
			moveDown(tc);
		}
		// step 4. 출력
		System.out.println(sumDust);
	}

}

