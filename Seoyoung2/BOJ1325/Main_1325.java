package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//1325. 효율적인 해킹
public class Main_1325 {
	
	static int[] hack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] depend = new ArrayList[N+1];
		for (int i = 1; i <= N; i++)	depend[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			depend[a].add(b);
		}
		
		hack = new int[N+1];
		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N + 1];
			dfs(i, visited, depend);
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, hack[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (hack[i] == max)	bw.write(i + " ");
		}
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int idx, boolean[] visited, ArrayList<Integer>[] depend) {
		visited[idx] = true;
		for (int tmp : depend[idx]) {
			if (!visited[tmp]) {
				hack[tmp]++;
				dfs(tmp, visited, depend);
			}
		}
	}

}