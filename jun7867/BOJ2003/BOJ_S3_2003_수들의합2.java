package com.Boj.seoul8.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 투 포인터 O(N) 
// 연속된 수열의 합.
public class BOJ_S3_2003_수들의합2 {
	static int N, M;
	static int[] A;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		twoPointer();
		System.out.println(cnt);
	}

	private static void twoPointer() {
		int sum = 0;
		int end = 0;
		for (int start = 0; start < N; start++) {
			while (sum < M && end < N)
				sum += A[end++];

			if (sum == M)
				cnt++;

			sum -= A[start];
		}

	}

}

