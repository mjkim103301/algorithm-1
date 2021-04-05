package com.Boj.seoul8.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1303_전쟁전투 {
	static int N, M;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static int max = 0;
	static int sumW = 0, sumB = 0;
	static int nr, nc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = ch[j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {
					bfs(i, j);
				}

			}
		}
		System.out.println(sumW + " " + sumB);
	}

	private static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(r, c));
		visit[r][c] = true;
		char check = map[r][c];
		int cnt = 1;

		while (!q.isEmpty()) {
			Node node = q.poll();

			// 상하좌우
			for (int i = 0; i < 4; i++) {
				nr = node.r + dx[i];
				nc = node.c + dy[i];
				// W
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc] && map[nr][nc] == check) {
					visit[nr][nc] = true;
					cnt++;
					q.offer(new Node(nr, nc));
				}
			}
		}
		if (check == 'W')
			sumW += cnt * cnt;
		else
			sumB += cnt * cnt;

	}
}

class Node {
	int r;
	int c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

