import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LineUp {

	private static int dp[], N, children[];

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
		children = new int[N];
		dp = new int[N];

		for (int i = 0; i < N; ++i)
			children[i] = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());

		for (int i = N - 1; i >= 0; --i) {
			dp[i] = 1;

			for (int j = i + 1; j < N; ++j) {
				if (children[j] > children[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}

		int max = 0;
		for (int i = 0; i < N; ++i)
			max = Math.max(max, dp[i]);

		System.out.println(N - max);
	}
}
