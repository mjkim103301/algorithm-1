package SmiteFLame.BOJ_16918;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16918 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb;

	static final int[][] NEWS = { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static int R, C, N;
	static boolean[][] data;

	private static void init() throws IOException {

		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		data = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = in.readLine();
			if (N % 2 == 0) {
				for (int j = 0; j < C; j++) {
					data[i][j] = true;
				}
			} else {
				for (int j = 0; j < C; j++) {
					data[i][j] = s.charAt(j) == 'O';
				}
			}
		}

	}

	private static boolean canMove(int X, int Y) {
		if (X < 0 || Y < 0 || X >= R || Y >= C) {
			return false;
		}
		return true;
	}

	private static boolean[][] makeFullTrue() {
		boolean[][] temp = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				temp[i][j] = true;
			}
		}
		return temp;
	}

	private static void implement() {
		for (int n = 0, end = N / 2; n < end; n++) {
			boolean[][] temp = makeFullTrue();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (!data[i][j])
						continue;
					for (int x = 0; x < 5; x++) {
						int nx = i + NEWS[x][0];
						int ny = j + NEWS[x][1];
						if (!canMove(nx, ny))
							continue;
						temp[nx][ny] = false;
					}
				}
			}
			data = temp;
		}
	}

	private static void print() throws IOException {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ot.write(data[i][j] ? "O" : ".");
			}
			ot.write("\n");
		}

		ot.flush();
		ot.close();
	}

	public static void main(String[] args) throws IOException {
		init();
		if (N % 2 != 0)
			implement();
		print();
	}

}