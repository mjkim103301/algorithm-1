package com.Boj.seoul8.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//DP
public class BOJ_G4_1563_개근상 {
	static int N;
	static int[][][] dp;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][2][3]; // 지각2 , 결석3
		System.out.println(check(0, 0, 0));
	}

	private static int check(int day, int L, int A) {
		// 기저조건 1: 지각2 or 결석 3이면 불가
		if (L == 2 || A == 3)
			return 0;
		// 기저조건 2: N까지 갔다면 +1
		if (day == N)
			return 1;

		if (dp[day][L][A] != 0)
			return dp[day][L][A];

		result = check(day + 1, L, 0) + check(day + 1, L + 1, 0) + check(day + 1, L, A + 1); // 제대로 출석 or 지각 or 결석
		dp[day][L][A] = result % 1000000;
		return dp[day][L][A];

	}
}
