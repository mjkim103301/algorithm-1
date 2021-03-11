package com.Boj.seoul8.week5;

import java.math.BigInteger;
import java.util.Scanner;

// DP
// 자바 범위 초과...
public class BOJ_S1_1793_타일링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger[] dp = new BigInteger[251];

		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");

		// dp[i-1]에서 세로 한줄 + dp[i-2]에서 2*2 정사각형 경우와 가로로 자른경우 2가지
		for (int i = 3; i <= 250; i++)
			dp[i] = dp[i - 1].add(dp[i - 2].multiply(new BigInteger("2")));

		while (sc.hasNextInt()) {
			System.out.println(dp[sc.nextInt()]);
		}

	}

}

