import java.util.Scanner;

public class Subsequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(), S = scanner.nextInt(), cnt = 0;
		int[] sum = new int[1 << N];

		for (int i = 0; i < N; ++i) {
			int number = scanner.nextInt();

			int cur = 1 << i;

			for (int j = 0; j < cur; ++j) {
				sum[cur + j] = number + sum[j];

				if (sum[cur + j] == S)
					cnt++;
			}
		}
		
		System.out.println(cnt);
		scanner.close();
	}
}
