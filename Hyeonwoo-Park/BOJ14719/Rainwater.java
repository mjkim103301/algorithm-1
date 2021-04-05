import java.util.Scanner;

public class Rainwater {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int H = scanner.nextInt(), W = scanner.nextInt();
		int sum = 0, maximum = 0;
		int[] blocks = new int[W];
		int[] leftMaximum = new int[W];

		for (int i = 0; i < W; ++i) {
			blocks[i] = scanner.nextInt();

			maximum = maximum < blocks[i] ? blocks[i] : maximum;

			leftMaximum[i] = maximum;
		}

		maximum = 0;

		for (int i = W - 1; i >= 0; --i) {
			maximum = maximum < blocks[i] ? blocks[i] : maximum;

			sum += (maximum < leftMaximum[i] ? maximum : leftMaximum[i]) - blocks[i];
		}

		System.out.println(sum);
		scanner.close();
	}
}