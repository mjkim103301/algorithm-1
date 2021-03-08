import java.math.BigInteger;
import java.util.Scanner;

public class Tiling {

	private static BigInteger dp[] = new BigInteger[251];

	private static BigInteger f(int depth) {
		if (depth == 0)
			return new BigInteger("1");

		if (dp[depth] != null)
			return dp[depth];

		BigInteger sum = new BigInteger("0");

		if (depth >= 2)
			sum = sum.add(f(depth - 2)).multiply(new BigInteger("2"));

		sum = sum.add(f(depth - 1));

		dp[depth] = sum;

		return dp[depth];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				System.out.println(f(scanner.nextInt()));
			} catch (Exception e) {
				scanner.close();
				break;
			}
		}
	}
}
