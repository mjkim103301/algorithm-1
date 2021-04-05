import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bomberman {

	private static final int dx[] = { -1, 0, 1, 0 };
	private static final int dy[] = { 0, -1, 0, 1 };

	private static void setBomb(int[][] board, int time) {
		for (int i = 0; i < board.length; ++i)
			for (int j = 0; j < board[0].length; ++j)
				if (board[i][j] == 0)
					board[i][j] = time;
	}

	private static void find(int[][] board, int time) {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (board[i][j] == time)
					bomb(board, i, j, time);
			}
		}
	}

	private static void bomb(int[][] board, int X, int Y, int time) {
		board[X][Y] = 0;

		for (int i = 0; i < 4; ++i) {
			int x = X + dx[i];
			int y = Y + dy[i];

			if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)
				continue;

			if (board[x][y] == time)
				continue;

			board[x][y] = 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuffer answer = new StringBuffer();
		int R = Integer.parseInt(token.nextToken()), C = Integer.parseInt(token.nextToken()),
				N = Integer.parseInt(token.nextToken());
		int board[][] = new int[R][C];

		for (int i = 0; i < R; ++i) {
			char[] inp = reader.readLine().toCharArray();

			for (int j = 0; j < C; ++j)
				if (inp[j] == 'O')
					board[i][j] = 1;
		}

		for (int i = 3; i <= N + 1; ++i) {
			if (i % 2 == 1)
				setBomb(board, i);
			else
				find(board, i - 3);
		}

		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (board[i][j] > 0)
					answer.append('O');
				else
					answer.append('.');
			}

			answer.append('\n');
		}
		
		System.out.println(answer);
	}
}
