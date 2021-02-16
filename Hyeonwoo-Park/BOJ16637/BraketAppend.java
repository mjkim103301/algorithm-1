import java.util.Arrays;
import java.util.Scanner;

public class BraketAppend {

	private static int N;

	private static boolean valid(int selected) {
		int flag = selected & 1;
		for (selected = selected >> 1; selected > 0; selected = selected >> 1) {
			if (flag == 1 && (selected & 1) == 1) {
				return false;
			}

			flag = selected & 1;
		}

		return true;
	}

	private static int calc(int a, int b, char command) {
		int result = 0;

		switch (command) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		default:
			result = a;
			break;
		}

		return result;
	}

	private static int solve(int selected, int[] numbers, char[] commands) {
		for (int i = 0; i < N / 2; ++i) {
			if ((selected >> i & 1) == 1) {
				numbers[i] = calc(numbers[i], numbers[i + 1], commands[i]);
				commands[i] = ' ';
			}
		}

		for (int i = 0; i < N / 2; ++i) {
			numbers[0] = calc(numbers[0], numbers[i + 1], commands[i]);
		}

		return numbers[0];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = Integer.parseInt(scanner.nextLine());
		String input = scanner.nextLine();
		scanner.close();

		int[] numbers = new int[N / 2 + 1];
		char[] commands = new char[N / 2];
		int maximum = Integer.MIN_VALUE;

		for (int i = 0; i < N; i += 2)
			numbers[i / 2] = input.charAt(i) - '0';

		for (int i = 1; i < N; i += 2)
			commands[i / 2] = input.charAt(i);

		for (int i = 0, end = 1 << (N / 2); i < end; ++i) {
			if (!valid(i))
				continue;

			maximum = Integer.max(maximum, solve(i, Arrays.copyOf(numbers, N / 2 + 1), Arrays.copyOf(commands, N / 2)));
		}

		System.out.println(maximum);
	}
}