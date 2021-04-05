import java.util.Arrays;
import java.util.Scanner;

public class ColoredPaper {

	private static int min = Integer.MAX_VALUE, sum = 0;

	private static boolean fillable(int[][] board, int x, int y, int num) {
		if (x + num > 10 || y + num > 10)
			return false;

		for (int i = 0; i < num; ++i) {
			for (int j = 0; j < num; ++j) {
				if (board[x + i][y + j] != 1)
					return false;
			}
		}

		return true;
	}

	private static void fill(int[][] board, int x, int y, int num, int paper) {
		for (int i = 0; i < num; ++i) {
			for (int j = 0; j < num; ++j) {
				board[x + i][y + j] = paper;
			}
		}
	}

	private static void find(int[][] board, int[] papers, int depth) {
		if (sum == 0) {
			min = min > depth ? depth : min;
			return;
		}

		loop: for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				if (board[i][j] == 1) {
					for (int k = 1; k <= 5; ++k) {
						if (papers[k] > 0 && fillable(board, i, j, k)) {
							fill(board, i, j, k, 0);
							papers[k]--;
							sum -= k * k;

							find(board, papers, depth + 1);

							sum += k * k;
							papers[k]++;

							fill(board, i, j, k, 1);
						}
					}
					break loop;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int board[][] = new int[10][10];
		int papers[] = new int[6];
		Arrays.fill(papers, 5);

		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				board[i][j] = scanner.nextInt();
				sum += board[i][j];
			}
		}
		scanner.close();

		find(board, papers, 0);

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}