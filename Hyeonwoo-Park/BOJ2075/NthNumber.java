import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NthNumber {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		int N = Integer.parseInt(reader.readLine());
		int[] numbers = new int[N * N];

		for (int i = 0; i < N; ++i) {
			token = new StringTokenizer(reader.readLine(), " ");
			for (int j = 0; j < N; ++j)
				numbers[i * N + j] = Integer.parseInt(token.nextToken());
		}

		Arrays.sort(numbers);

		System.out.println(numbers[N * N - N]);
	}
}