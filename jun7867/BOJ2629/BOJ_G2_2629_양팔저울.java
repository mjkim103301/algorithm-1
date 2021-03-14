package com.Boj.seoul8.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G2_2629_양팔저울 {
	static int N, M;
	static int[] weight, marble;
	static boolean[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		weight = new int[N];
		int sum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
			sum += weight[i];
		}
		
		M = Integer.parseInt(br.readLine());
		marble = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			marble[i] = Integer.parseInt(st.nextToken());
		}

		
		dp = new boolean[N + 1][sum + 40000];

		subset(0, 0);

		StringBuilder sb = new StringBuilder();
		for (int m : marble) {
			if (dp[N][m]) {
				sb.append("Y ");
			} else {
				sb.append("N ");
			}
		}

		System.out.println(sb.toString());

	}

	private static void subset(int idx, int w) {
		// 기저조건 1
		if (dp[idx][w]) // idx에서 weight를 가지고 있는가?
			return;
		dp[idx][w] = true;

		// 기저조건 2
		if (idx == N)
			return;

		subset(idx + 1, w + weight[idx]); // 추 더하기
		subset(idx + 1, w); // 추 pass
		subset(idx + 1, Math.abs(w - weight[idx])); // 추 빼기
	}

}

