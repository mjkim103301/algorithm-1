package com.Boj.seoul8.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// LIS(가장 긴 증가하는 수열) 
// Dp[i] = max(D[i],D[j]+1) if arr[j] < arr[i]
public class BOJ_G5_2631_줄세우기 {
	static int N;
	static int[] numbers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[N];
		Arrays.fill(dp, 1); // 각 최장거리는 1씩

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] < numbers[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = max < dp[i] ? dp[i] : max;
		}

		System.out.println(N - max);

	}

}

