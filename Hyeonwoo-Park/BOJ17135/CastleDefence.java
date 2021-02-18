import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CastleDefence {

	private static int N, M, D;
	private static int[][] board;
	private static int[][] visit;

	private static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	private static int attack(int[] archers, int line) {
		int[][] nearest = new int[][] { { D + 1, 0, 0 }, { D + 1, 0, 0 }, { D + 1, 0, 0 } };
		int cnt = 0;

		for (int i = 0; i < N - line; ++i) {
			for (int j = 0; j < M; ++j) {
				int enemy = board[i][j];
				if (enemy == 0)
					continue;
				if (visit[i][j] == 1)
					continue;

				for (int k = 0; k < 3; ++k) {
					int archer = archers[k];
					int distance = dist(i, j, N - line, archer);

					if (distance > D)
						continue;

					if ((nearest[k][0] == distance && nearest[k][2] > j) || (nearest[k][0] > distance)) {
						nearest[k] = new int[] { distance, i, j };
						
						continue;
					}
				}
			}
		}

		for (int i = 0; i < 3; ++i) {
			if (nearest[i][0] > D)
				continue;
			
			int x = nearest[i][1];
			int y = nearest[i][2];

			if (visit[x][y] == 1)
				continue;

			visit[x][y] = 1;
			cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		D = Integer.parseInt(input[2]);

		board = new int[N][M];
		int maximum = 0;

		for (int i = 0; i < N; ++i) {
			board[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(v -> Integer.parseInt(v)).toArray();
		}

		for (int i = 0; i < M - 2; ++i) {
			for (int j = i + 1; j < M - 1; ++j) {
				for (int k = j + 1; k < M; ++k) {
					int tmp = 0;
					visit = new int[N][M];

					for (int l = 0; l < N; ++l) {
						tmp += attack(new int[] { i, j, k }, l);
					}

					maximum = maximum < tmp ? tmp : maximum;
				}
			}
		}

		System.out.println(maximum);
	}
}
