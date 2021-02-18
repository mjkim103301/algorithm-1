package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

// 2504. 괄호의 값
public class Main_2504 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		Stack<String> stk = new Stack<>();
		String ch, pre;
		int round = 0, rect = 0;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i)+"";
			switch (ch) {
			case "(":
				stk.push(ch);
				round++;
				break;
			case "[":
				stk.push(ch);
				rect++;
				break;
			case ")":
				if(round-- <= 0) {
					System.out.println(0);
					return;
				}
				if(stk.peek().equals("(")) {
					stk.pop();
					stk.push("2");
				} else {	//number
					int res = 0;
                    while(!stk.isEmpty()) {
                        if(stk.peek().equals("[")) {
                            System.out.println(0);
                            return;
                        }else if(stk.peek().equals("(")) {
                            stk.pop();
                            res *=2;
                            stk.push(res+"");
                            break;
                        }else {
                            res += Integer.parseInt(stk.pop());
                        }
                    }
				}
				break;
			case "]":
				if(rect-- <= 0) {
					System.out.println(0);
					return;
				}
				if(stk.peek().equals("[")) {
					stk.pop();
					stk.push("3");
				} else {	//number
					int res = 0;
                    while(!stk.isEmpty()) {
                        if(stk.peek().equals("(")) {
                            System.out.println(0);
                            return;
                        }else if(stk.peek().equals("[")) {
                            stk.pop();
                            res *=3;
                            stk.push(res+"");
                            break;
                        }else {
                            res += Integer.parseInt(stk.pop());
                        }
                    }
				}
				break;
			}
		}
		if(round != 0 || rect != 0) {
			System.out.println(0);
			return;
		}
		int ans = 0;
		while (!stk.isEmpty())
            ans += Integer.parseInt(stk.pop());
		System.out.println(ans);
	}
}
