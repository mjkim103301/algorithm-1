import java.util.Scanner;

public class AttendanceAward {

	private static int dp[][][];

	private static int func(int depth, int late, int absence) {
		if (depth == 0)
			return 1;

		if (dp[depth][absence][late] != 0)
			return dp[depth][absence][late];

		int sum = 0;

		if (late == 0)
			sum += func(depth - 1, 1, 0);

		if (absence < 2)
			sum += func(depth - 1, late, absence + 1);

		sum += func(depth - 1, late, 0);

		dp[depth][absence][late] = sum % 1000000;

		return sum % 1000000;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();

		dp = new int[N + 1][3][2];

		System.out.println(func(N, 0, 0));
	}
}
