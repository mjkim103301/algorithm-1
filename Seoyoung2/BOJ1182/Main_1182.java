package Baekjoon;

import java.util.Scanner;

// 1182. 부분수열의 합
public class Main_1182 {
	static int N, S, ans;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		if(S == 0)	ans--;
		
		num = new int[N];
		for (int i = 0; i < N; i++)
			num[i] = sc.nextInt();
		
		solve(0, 0);
		System.out.println(ans);
	}
	
	static void solve(int idx, int sum) {
		if(idx == N) {
			if(sum == S)	ans++;
			return;
		}
		solve(idx+1, sum+num[idx]);
		solve(idx+1, sum);
	}
}
