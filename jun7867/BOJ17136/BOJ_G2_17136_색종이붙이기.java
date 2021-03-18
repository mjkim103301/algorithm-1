package com.Boj.seoul8.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_17136_색종이붙이기 {
	static int[][] map = new int[10][10];
	static int[] paper = { 0, 5, 5, 5, 5, 5 };
	static int cnt = 0;
	static int min = 26;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0);

		if (min == 26)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static void dfs(int r, int c, int cnt) {
		// 다 채우면
		if (r >= 9 && c > 9) {
			min = min > cnt ? cnt : min;
			return;
		}

		// backtracking
		if (min <= cnt)
			return;

		if (c > 9) {
			dfs(r + 1, 0, cnt);
			return;
		}
		if (map[r][c] == 1) {
			for (int k = 5; k > 0; k--) {
				if (paper[k] > 0 && r + k <= 10 && c + k <= 10 && isPossible(r, c, k)) {
					fillPaper(r, c, k, 0);
					paper[k]--;

					dfs(r, c + 1, cnt + 1);
					fillPaper(r, c, k, 1); // 원상복구
					paper[k]++;
				}
			}
		} else {
			dfs(r, c + 1, cnt);
		}

	}

	// 종이 붙이기, 떼기 (0 or 1)
	private static void fillPaper(int r, int c, int k, int value) {
		for (int i = r; i < r + k; i++) {
			for (int j = c; j < c + k; j++) {
				map[i][j] = value;
			}
		}
	}

	// k*k 색종이를 붙일 수 있는가?
	private static boolean isPossible(int r, int c, int k) {
		for (int i = r; i < r + k; i++) {
			for (int j = c; j < c + k; j++) {
				if (map[i][j] != 1)
					return false;
			}
		}
		return true;
	}

}

