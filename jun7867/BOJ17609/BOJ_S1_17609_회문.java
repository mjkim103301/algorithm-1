import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_17609_회문 {
	static int T;
	static String str;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int resultL = 0, resultR = 0, result;
		for (int i = 0; i < T; i++) {
			str = br.readLine();
			resultL = findRRL();
			resultR = findRRR();
			result = Math.min(resultL, resultR);
			if (result == 0) {
				sb.append(0 + "\n");
			} else if (result == 1) {
				sb.append(1 + "\n");
			} else {
				sb.append(2 + "\n");
			}
		}
		System.out.println(sb.toString());

	}

	private static int findRRR() {
		int start = 0;
		int end = str.length() - 1;
		int failCnt = 0;
		while (start <= end) {
			if (str.charAt(start) != str.charAt(end)) {
				end -= 1;
				failCnt++;
			} else {
				start += 1;
				end -= 1;
			}
		}
		return failCnt;
	}

	private static int findRRL() {
		int start = 0;
		int end = str.length() - 1;
		int failCnt = 0;
		while (start <= end) {
			if (str.charAt(start) != str.charAt(end)) {
				start += 1;
				failCnt++;
			} else {
				start += 1;
				end -= 1;
			}
		}
		return failCnt;
	}

}

