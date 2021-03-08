package Baekjoon;

import java.util.Scanner;

// 1563. 개근상
public class Main_1563 {
	static int N;
	static int[][][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N][2][3];	// 일/지각/결

		System.out.println(prize(0, 0, 0));
	}

	static int prize(int day, int late, int abs) {
		if(late >= 2 || abs >= 3)	return 0;
		if(day == N)	return 1;
		
		if(dp[day][late][abs] != 0)	return dp[day][late][abs];
		
		// 개근상을 받을 수 없는 사람은 지각을 두 번 이상 했거나, 결석을 세 번 연속으로 한 사람이다.
		dp[day][late][abs] = (prize(day+1, late, 0) + prize(day+1, late+1, 0) + prize(day+1, late, abs+1)) % 1000000; 
		return dp[day][late][abs];
	}
}
