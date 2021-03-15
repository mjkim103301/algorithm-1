package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2629. 양팔저울
public class Main_2629 {
	static int N;
	static int[] W;
	static boolean[][] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W = new int[N];
		check = new boolean[N+1][40001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			W[i] = Integer.parseInt(st.nextToken());
		}
		
		checkWeight(0, 0);
		
		int M = Integer.parseInt(br.readLine());
		int n;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			n = Integer.parseInt(st.nextToken());
			if(check[N][n])	System.out.print("Y ");
			else			System.out.print("N ");
		}

	}

	static void checkWeight(int cnt, int weight) {
		if(check[cnt][weight])	return;
		check[cnt][weight] = true;
		
		if(cnt == N)	return;
		
		if(weight + W[cnt] <= 40000) {
			checkWeight(cnt+1, weight+W[cnt]);
		}
		checkWeight(cnt+1, weight);
		checkWeight(cnt+1, Math.abs(weight-W[cnt]));
		
	}
}
	


