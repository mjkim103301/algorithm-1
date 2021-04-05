import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wedding {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;

		int answer = 0;
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());

		boolean friends[][] = new boolean[N][N];

		for (int i = 0; i < M; ++i) {
			token = new StringTokenizer(reader.readLine());

			int st = Integer.parseInt(token.nextToken()) - 1;
			int ed = Integer.parseInt(token.nextToken()) - 1;

			friends[st][ed] = true;
			friends[ed][st] = true;

			friends[st][st] = true;
			friends[ed][ed] = true;
		}
		
		friends[0][0] = false;

		for (int i = 0; i < N; ++i) {
			if (!friends[0][i])
				continue;

			for (int j = 0; j < N; ++j) {
				if (!friends[i][j] || !friends[j][j])
					continue;

				friends[j][j] = false;
				answer++;
			}
		}

		System.out.print(answer);
	}

}
