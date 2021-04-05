package com.Boj.seoul8.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 크루스칼
public class BOJ_G4_1922_네트워크연결 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int N, M;
	static Edge[] edgeList;
	static int[] parents;

	private static void make() {
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parents[aRoot] = b;
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edgeList = new Edge[M];
		int from, to, w;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, w);
		}
		Arrays.sort(edgeList);

		parents = new int[N + 1];
		make();

		int result = 0;
		for (Edge edge : edgeList) {
			// 사이클 형성 ㄴㄴ
			if (union(edge.from, edge.to)) {
				result += edge.weight;
			}
		}
		System.out.println(result);

	}

}

