package com.Boj.seoul8.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Pair {
	int l;
	int r;
	public Pair(int l, int r) {
		super();
		this.l = l;
		this.r = r;
	}	
}

public class BOJ_G3_2370_시장선거포스터 {
	static int n;
	static int[] board;
	static int max=0;
	static int cnt;
	static Pair[] p;
	static Set<Integer> set = new HashSet<Integer>();
	static List<Integer> setList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		p = new Pair[n];
		StringTokenizer st =null;
		int pl,pr;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			pl=Integer.parseInt(st.nextToken());
			pr=Integer.parseInt(st.nextToken());
			p[i] = new Pair(pl,pr);
			set.add(pl);
			set.add(pr);
		}
		// 사이 값들을 다 채워줄 필요가 없이 경계값들만 체크해주면 됨. 안그러면 시간초과가 남..
		// set을 sort해주기 위해 List로 변경. 
		setList=new ArrayList<>(set);
		Collections.sort(setList);
		
		poster();
		count();
		System.out.println(cnt);
		
	}
	private static void poster() {
		board=new int[setList.size()];
		
		for(int i=0;i<n;i++) {
			Arrays.fill(board, setList.indexOf(p[i].l) , setList.indexOf(p[i].r)+1, i+1);
		}
	}
	
	// ex ) board [1, 2, 4, 4, 2, 5, 5, 5]
	// 다른 것들의 개수 세기
	private static void count() {
		cnt=0;
		int[] used= new int[n+1];
		for(int id : board) {
			if(used[id]==0) {
				cnt++;
				used[id]=1;
			}
		}
		
	}
}


