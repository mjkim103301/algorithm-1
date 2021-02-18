import java.util.Scanner;
import java.util.Stack;

public class Bracket {
	private static final String OPEN_BRACKET = "  ([";
	private static final String CLOSE_BRACKET = "  )]";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] inp = scanner.nextLine().toCharArray();
		scanner.close();

		Stack<Character> bracketStack = new Stack<>();
		Stack<Integer> sumStack = new Stack<>();
		sumStack.add(0);

		for (int i = 0; i < inp.length; ++i) {
			if (bracketStack.empty()) {
				bracketStack.add(inp[i]);
				sumStack.add(0);
				continue;
			}

			if (OPEN_BRACKET.indexOf(inp[i]) != -1) {
				bracketStack.add(inp[i]);
				sumStack.add(0);
			} else {
				int bracketVal = OPEN_BRACKET.indexOf(bracketStack.pop());
				int sum = sumStack.pop();
				sum = sum == 0 ? 1 : sum;

				if (bracketVal == CLOSE_BRACKET.indexOf(inp[i])) {
					sumStack.add(sumStack.pop() + sum * bracketVal);
				} else {
					System.out.println(0);
					return;
				}
			}
		}

		if (bracketStack.empty()) {
			System.out.println(sumStack.pop());
		} else {
			System.out.println(0);
		}
	}
}
