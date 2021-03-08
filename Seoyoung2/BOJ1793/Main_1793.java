package Baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

// 1793. 타일링
public class Main_1793 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger[] dp = new BigInteger[251];
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		
		BigInteger two = new BigInteger("2");
		for (int i = 2; i < 251; i++) {
			// dp[i] =  dp[i-1] + 2*dp[i-2]
			dp[i] = dp[i-1].add(dp[i-2].multiply(two));
		}

		while(sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}
