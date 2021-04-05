package com.Boj.seoul8.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14719
public class BOJ_G5_14719_빗물 {
	static int H,W;
	static int max=0, maxIndex=0, sum=0,total=0;
	static int[] block;
	
	private static void leftCal() {
		int temp=0;
		for(int i=0;i<=maxIndex;i++) {
			// 현재 블록이 이전 가장 큰 블록보다 더크면 update해줌 
			if(block[i] > temp)
				temp=block[i];
			total+=temp;
		}
		
	}
	private static void rightCal() {
		int temp=0;
		for(int i=W-1;i>maxIndex;i--) {
			// 현재 블록이 이전 가장 큰 블록보다 더크면 update해줌 
			if(block[i] > temp)
				temp=block[i];
			total+=temp;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		block = new int[W];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<W;i++) {
			int height=Integer.parseInt(st.nextToken());
			block[i]=height;
			sum+=height;
			if(max < height) {
				max=height;
				maxIndex=i;
			}
		}
		
		leftCal();
		rightCal();
		System.out.println(total-sum);
	
	}
}

