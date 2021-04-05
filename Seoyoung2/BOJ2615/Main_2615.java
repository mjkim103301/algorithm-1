package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2615. 오목
public class Main_2615 {
	static int[][] dxdy = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}}; // 우상, 우, 우하, 하
	static int[][] board = new int[19][19];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int who;
		int nx, ny;
		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				who = board[i][j];
				if(who == 0)	continue;
				// 주변 바둑알 탐색
				for (int k = 0; k < 4; k++) {
					nx = i + dxdy[k][0];
					ny = j + dxdy[k][1];
					if(nx<0 || nx>=19 || ny<0 || ny>=19 || board[nx][ny] != who)	continue;
					
					if(check(nx, ny, dxdy[k], who)) {
						System.out.println(who);
						System.out.println((i+1) + " " + (j+1));
						return;
					}
				}
			}
		}
		System.out.println(0);
	}

	static boolean check(int x, int y, int[] dir, int who) {
		int cnt = 2;
		int mx = x, my = y;
		while(true) {
			mx += dir[0];
			my += dir[1];
			
			if(mx>=0 && mx<19 && my>=0 && my<19 && board[mx][my] == who)	cnt++;
			else	break;
		}
		
		// 이전 바둑알 검사 필요
		if(cnt == 5) {
			mx = x - 2*dir[0];
			my = y - 2*dir[1];
			if(mx>=0 && mx<19 && my>=0 && my<19 && board[mx][my] == who)
                cnt++;
		}
		return cnt == 5;
	}
}
