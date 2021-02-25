import java.util.Scanner;

public class Omok {

	private static final int dx[] = { 1, 1, 1, 0 };
	private static final int dy[] = { -1, 0, 1, 1 };

	private static int check(int x, int y, int color, int dir, int depth, int board[][], int visit[][]) {
		int X = x + dx[dir];
		int Y = y + dy[dir];

		if (X < 0 || Y < 0 || X >= 19 || Y >= 19)
			return depth;

		if (board[X][Y] != color)
			return depth;

		if ((visit[X][Y] & (1 << dir)) != 0)
			return depth;

		visit[X][Y] |= (1 << dir);

		return check(X, Y, color, dir, depth + 1, board, visit);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int board[][] = new int[19][19];
		int visit[][] = new int[19][19];

		for (int i = 0; i < 19; ++i) {
			for (int j = 0; j < 19; ++j) {
				board[i][j] = scanner.nextInt();
			}
		}

		for (int i = 0; i < 19; ++i) {
			for (int j = 0; j < 19; ++j) {
				if (board[i][j] == 0)
					continue;

				for (int k = 0; k < 4; ++k) {
					if (check(i, j, board[i][j], k, 1, board, visit) == 5) {
						if (k == 0) {
							i += 4;
							j -= 4;
						}

						System.out.println(board[i][j]);
						System.out.println((i + 1) + " " + (j + 1));
						scanner.close();
						return;
					}

				}
			}
		}

		System.out.println(0);

		scanner.close();
	}
}
