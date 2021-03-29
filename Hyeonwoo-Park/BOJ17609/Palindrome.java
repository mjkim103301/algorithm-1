import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome {

	private static int check(String inp, int l, int r, int status) {
		int result;

		if (r <= l)
			if (inp.charAt(l) == inp.charAt(r))
				return status;
			else
				return 2;

		if (status == 1)
			if (inp.charAt(l) == inp.charAt(r))
				return check(inp, l + 1, r - 1, status);
			else
				return 2;

		if (inp.charAt(l) == inp.charAt(r) && (result = check(inp, l + 1, r - 1, 0)) < 2)
			return result;

		if ((result = check(inp, l + 1, r, 1)) < 2)
			return result;

		if ((result = check(inp, l, r - 1, 1)) < 2)
			return result;

		return 2;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		while (N-- > 0) {
			String inp = reader.readLine();

			System.out.println(check(inp, 0, inp.length() - 1, 0));
		}
	}
}
