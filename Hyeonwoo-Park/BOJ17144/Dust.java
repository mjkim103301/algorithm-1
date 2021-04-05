import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dust {

	private static int dx[] = { 0, 1, 0, -1 };
	private static int dy[] = { 1, 0, -1, 0 };

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int R, C, T;
	static int[][] room, purifiers, temp;

	private static void defuse(int x, int y, int dust) {
		for (int i = 0; i < 4; ++i) {
			int X = x + dx[i];
			int Y = y + dy[i];

			if (X < 0 || Y < 0 || X >= R || Y >= C)
				continue;
			if (room[X][Y] == -1)
				continue;

			if (i < 2)
				temp[X][Y] += dust;
			else
				room[X][Y] += dust;

			room[x][y] -= dust;
		}
	}

	private static void rotate(int purifiers[][]) {

		for (int i = 0; i < 2; ++i) {
			int x = purifiers[i][0];
			int y = purifiers[i][1];
			int dir = 2;
			int tb = i == 0 ? 1 : -1;

			int ceil = i == 0 ? 0 : x;
			int floor = i == 0 ? x + 1 : R;

			while (true) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if (nx < ceil || ny < 0 || nx >= floor || ny >= C) {
					dir += tb;

					if (dir == -1)
						dir = 3;

					dir %= 4;

					continue;
				}

				if (room[nx][ny] == -1)
					break;

				room[x][y] |= room[nx][ny];
				room[nx][ny] = 0;

				x = nx;
				y = ny;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		StringTokenizer token = new StringTokenizer(reader.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		T = Integer.parseInt(token.nextToken());
		room = new int[R][C];
		temp = new int[R][C];
		purifiers = new int[2][2];

		int tmp = 0, result = 0;

		for (int i = 0; i < R; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < C; ++j) {
				room[i][j] = Integer.parseInt(token.nextToken());

				if (room[i][j] == -1)
					purifiers[tmp++] = new int[] { i, j };
			}
		}

		for (int t = 0; t < T; ++t) {
			for (int i = 0; i < R; ++i) {
				for (int j = 0; j < C; ++j) {
					if (room[i][j] > 0)
						defuse(i, j, room[i][j] / 5);

					room[i][j] += temp[i][j];

					temp[i][j] = 0;
				}
			}

			rotate(purifiers);
		}

		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				result += room[i][j];
			}
		}

		System.out.println(result + 2);

	}

}
