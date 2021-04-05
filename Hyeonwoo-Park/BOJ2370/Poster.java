import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Poster {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		int N = Integer.parseInt(reader.readLine());
		int posters[][] = new int[N][2];
		int count = 0;

		for (int i = 0; i < N; ++i) {
			token = new StringTokenizer(reader.readLine());
			posters[i][0] = Integer.parseInt(token.nextToken());
			posters[i][1] = Integer.parseInt(token.nextToken());
		}

		loop: for (int i = N - 1; i >= 0; --i) {
			int st = posters[i][0];
			int ed = posters[i][1];

			for (int j = i + 1; j < N; ++j) {
				if (posters[j][0] <= posters[i][0] && posters[i][0] - 1 <= posters[j][1])
					posters[i][0] = posters[j][0];

				if (posters[j][0] <= posters[i][1] + 1 && posters[i][1] <= posters[j][1])
					posters[i][1] = posters[j][1];

				if (posters[j][0] <= st && ed <= posters[j][1])
					continue loop;
			}

			count++;
		}

		System.out.println(count);
	}
}
