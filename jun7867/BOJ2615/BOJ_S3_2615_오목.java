package com.Boj.seoul8.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2615_오목 {
	final static int N = 19;
	static int[][] map = new int[21][21];
	static boolean[][][] visit = new boolean[21][21][4];
	static int[] dr = { 0, 1, -1, 1 }; // 오른쪽 , 아래 , 오른쪽 위 대각선, 오른쪽 아래 대각선 4가지 경우.
	static int[] dc = { 1, 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// i,j 순으로 진행할 경우 왼쪽 대각선으로 이어진 오목을 먼저 발견하기 때문에 가장 왼쪽의 수를 출력할때 문제가 생깁니다. 
		// 따라서 j,i 순으로 변경하여 아래부터 탐색하도록 하여 왼쪽 대각선 경우를 제외시켜줬습니다.
		for (int j = 1; j <= N; j++) {
			for (int i = 1; i <= N; i++) {
				if (map[i][j] == 0)
					continue;
				for (int k = 0; k < 4; k++) {
					if (!visit[i][j][k])
						if (dfs(i, j, k, map[i][j]) == 5) {
							System.out.println(map[i][j]);
							System.out.println(i + " " + j);
							return;
						}
				}
			}
		}
		System.out.println(0);

	}

	// 탐색할때 방향에 따라서 체크를 달리 해줘야 하니까 [d]도 visit에 추가
	private static int dfs(int r, int c, int d, int check) {
		visit[r][c][d] = true;
		int nr = r + dr[d];
		int nc = c + dc[d];
		
		// 이 부분 때문에 여러번 틀렸습니다....  범위를 초과할때 0을 리턴하게 했는데 테스트 케이스에서는 문제가 없었지만 이게 계산에 영향을 미쳤습니다... 그래서 상하좌우에 1칸씩 추가해줘서 범위 초과 경우를 막았습니다.
		// 조금 어색해서 주석처리 했더니 정답이 됐습니다. 정확히 이 부분이 이해가 되지 않는데 설명해주실분 있나요..?
//		if (nr > N  || nc > N)
//			return 0;

		if (map[nr][nc] == check)
			return dfs(nr, nc, d, check)+1;

		return 1;
	}

}

