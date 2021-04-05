package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2003. 수들의 합 2
public class Main_2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());
		int start = 0, sum = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];
			if (sum >= M) {
				do {
					if (sum == M)	ans++;
					sum -= nums[start++];
				} while (sum >= M);
			}
		}
		System.out.println(ans);
	}
}
