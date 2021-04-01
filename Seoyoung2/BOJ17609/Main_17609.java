package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 17609. 회문
public class Main_17609 {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String str = br.readLine();
			
			int res = 0;	// 0:회문, 1:유사회문, 2:실패
			int l = 0, r = str.length()-1;
			while(l < r) {
				if(str.charAt(l) == str.charAt(r)) {
					l++; r--;
					continue;
				} else if(str.charAt(l+1) != str.charAt(r) && str.charAt(l) != str.charAt(r-1)) {
					res = 2;
					break;
				}
				for (int i = 0; i < 2; i++) {
					res = 1;
					int tl = l, tr = r;
					if(i==0)	tl++;	else	tr--;
					
					while(++tl < --tr) {
						if(str.charAt(tl) != str.charAt(tr)) {
							res = 2;
							break;
						}
					}
					if(res == 1)	break;
				}
				break;
			}
			System.out.println(res);
		}
	}
}
// abcbab
