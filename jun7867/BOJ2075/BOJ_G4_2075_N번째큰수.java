package com.Boj.seoul8.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// PriorityQueue O(NLogN)
public class BOJ_G4_2075_N번째큰수 {
	static int N;
	static PriorityQueue<Integer> q;

	private static int sol() {
		int cnt = 1;
		while (!q.isEmpty()) {
			if (cnt == N)
				return q.poll();
			else
				q.poll();
			cnt++;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		q = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++)
				q.add(Integer.parseInt(st.nextToken()));

		}

		int result = sol();
		System.out.println(result);
	}

}

