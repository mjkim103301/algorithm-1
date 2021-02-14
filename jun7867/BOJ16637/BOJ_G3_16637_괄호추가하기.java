package com.Boj.seoul8.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G3_16637_괄호추가하기 {
	static int N;
	static char[] equation;
	static int computeNum = 0, temp = 0;
	static int max = Integer.MIN_VALUE;
	
	private static void recursion(int idx, int result) {
		// 기저조건.
		if (idx == N - 1) {
			max = Math.max(max, result);
			return;
		}
		
		// 순차적 계산. (계산 결과가 1개 들어가니까 recursion +2만 해줌)
		computeNum = compute(result, equation[idx + 2] - '0', equation[idx + 1]);
		recursion(idx + 2, computeNum);

		// 뒤에 먼저 계산하고 앞에 계산.(5개 이상 남아있어야함) - 0 1 2 3 4
		if (idx + 4 < N) {
			temp = compute(equation[idx + 2] - '0', equation[idx + 4] - '0', equation[idx + 3]);
			computeNum = compute(result, temp, equation[idx + 1]);
			recursion(idx + 4, computeNum);
		}

	}

	private static int compute(int n1, int n2, char op) {
		int num = 0;
		switch (op) {
		case '+':
			num = n1 + n2;
			break;
		case '-':
			num = n1 - n2;
			break;
		case '*':
			num = n1 * n2;
			break;
		}

		return num;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		equation = br.readLine().toCharArray();
		recursion(0, equation[0]-'0');
		System.out.println(max);
	}

	

}

