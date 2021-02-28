package com.Boj.seoul8.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 이분 탐색 
// Parametric Search => N*N 에서 x 이하의 수가 K개 이상이다. 
// O(logN)
public class BOJ_G3_1300_K번째수 {
	static int N, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		System.out.println(binarySearch(1, K));

	}

	// N: 3 , K : 7 (left:1)
	private static int binarySearch(int left, int right) {

		if (left > right)
			return left;

		int mid = (left + right) / 2;
		int cnt = 0;

		// 각 행별로 mid보다 작은수의 개수를 더해준다.
		for (int i = 1; i <= N; i++) {
			cnt += N > mid / i ? mid / i : N; // == Math.min(mid/i ,N)
		}
		// mid보다 작거나 같은 수의 합이 K보다 작다는 것은 mid 이하는 탐색할 필요가 없다는 것이다.
		// 같으면 K번째 수가 될 수는 있지만 최소값인지는 알 수 없다.
		if (cnt < K) {
			return binarySearch(mid + 1, right);
		} else {
			// K보다 커서 가능한 경우들. 최소값인지 모르기에 범위를 좁혀나간다.

			return binarySearch(left, mid - 1);
		}
	}

}

