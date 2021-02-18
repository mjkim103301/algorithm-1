import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class War {

	private static final int[] dx = { 1, 0, -1, 0 };
	private static final int[] dy = { 0, 1, 0, -1 };
	private static int N, M, troop;
	private static char battlefield[][];

	private static boolean dfs(int x, int y, char team) {
		battlefield[x][y] = 'X';
		troop++;

		for (int i = 0; i < 4; ++i) {
			int X = x + dx[i];
			int Y = y + dy[i];

			if (X < 0 || Y < 0 || X >= N || Y >= M)
				continue;

			if (battlefield[X][Y] != team)
				continue;

			dfs(X, Y, team);
		}

		return team == 'W';
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		battlefield = new char[N][M];
		int ally = 0, enemy = 0;

		for (int i = 0; i < N; ++i) {
			battlefield[i] = reader.readLine().toCharArray();
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (battlefield[i][j] == 'X')
					continue;

				troop = 0;

				if (dfs(i, j, battlefield[i][j]))
					ally += (troop * troop);
				else
					enemy += (troop * troop);
			}
		}

		System.out.println("" + ally + " " + enemy);
	}
}
