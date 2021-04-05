package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2631. 줄세우기
public class Main_2631 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		int[] dp = new int[N];
		int ans = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(N-ans-1);
	}
}
