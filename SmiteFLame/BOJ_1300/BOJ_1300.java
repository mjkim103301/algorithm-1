package SmiteFLame.BOJ_1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300 {
	static int N, K, ans;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	private static void init() throws IOException {
		N = Integer.parseInt(in.readLine());
		K = Integer.parseInt(in.readLine());
	}

	private static void implement() {
		int L = 0, R = K;
		while(L <= R) {
			int M = (L + R) / 2;
			int count = 0;
			for(int i = 1; i <= N; i++) {
				count += N < (M / i) ? N : (M / i);  
			}
			if(count >= K) {
				ans = M;
				R = M - 1;
			} else {
				L = M + 1;
			}
		}
	}

	private static void print() {
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}

}
