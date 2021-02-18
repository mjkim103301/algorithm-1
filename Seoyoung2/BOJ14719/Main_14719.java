package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14719. 빗물
public class Main_14719 {
	static int H, W;
	static boolean[][] block;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		int high;
		block = new boolean[H][W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			high = Integer.parseInt(st.nextToken());
			for (int j = 0; j < high; j++) {
				block[j][i] = true;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(block[i][j])	ans += goRight(i, j);
			}
		}
		System.out.println(ans);
	}
	
	private static int goRight(int px, int py) {
		int rain = 0;
		for (int y = py+1; y < W; y++) {
			if(block[px][y])	return rain;
			rain++;
		}
		return 0;
	}
}
