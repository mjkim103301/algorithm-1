package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 16637. 괄호 추가하기
public class Main_16637 {
	static int N;
	static int[] num;
	static char[] op;
	static boolean[] check;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt() / 2;
		num = new int[N+1];
		op = new char[N];
		check = new boolean[N+1];	// visit check
		
		String str = sc.next();
		for (int i = 0; i < 2*N+1; i++) {
			if(i % 2 == 0)	num[i/2] = str.charAt(i) - '0';
			else			op[i/2] = str.charAt(i);
		}

		subset(0);
		System.out.println(ans);
	}
	
	static void subset(int idx) {
		if(idx > N + 1)	return;
		if(idx >= N) {
			ans = Math.max(ans, cal());
			return;
		}
		
		// 괄호 X -> 다음 연산자로
		subset(idx+1);
		
		// 괄호 O -> 다다음 연산자로
		check[idx] = true;
		subset(idx+2);
		check[idx] = false;
	}
	
	static int cal() {
		List<Integer> res = new ArrayList<>();
		
		// 괄호 계산
		for (int i = 0; i <= N; i++) {
			if(!check[i])	res.add(num[i]);
			else	res.add(eval(num[i], op[i], num[++i]));
		}
		
		// 남은 수식 계산
		for (int i = 0; i < N; i++) {
			if(check[i])	continue;
			int tmp = eval(res.remove(0), op[i], res.remove(0));
			res.add(0, tmp);
		}
		return res.get(0);
	}
	
	static int eval(int x, char op, int y) {
		switch (op) {
		case '+':
			return x+y;
		case '-':
			return x-y;
		case '*':
			return x*y;
		}
		return 0;
	}
}
