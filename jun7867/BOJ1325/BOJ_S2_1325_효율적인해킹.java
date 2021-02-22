
package com.Boj.seoul8.week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_1325_효율적인해킹 {
	static int N,M;
	static boolean[] visit;
	static ArrayList<Integer>[] list;
	static int max=0;
	static int[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		visit=new boolean[N];
		list = new ArrayList[N+1];
		adj=new int[N+1];
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		for(int i=1;i<=N;i++) {
			visit=new boolean[N+1];
			dfs(i);
		}
		for(int i=1;i<=N;i++) {
			max=max < adj[i] ? adj[i] : max;
		}
		
		for(int i=1;i<=N;i++) {
			if(adj[i]==max) {
				bw.write(i+" ");
			}
		}
		
		bw.flush();
		bw.close();
	}
	private static void dfs(int v) {
		visit[v]=true;
		
		for(int vv: list[v]) {
			if(!visit[vv]) {
				adj[vv]++;
				dfs(vv);
			}
		}
		

		
	}

}
