import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum2 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
		int N = Integer.parseInt(token.nextToken()), M = Integer.parseInt(token.nextToken());
		int nums[] = new int[N], cnt = 0;

		token = new StringTokenizer(reader.readLine(), " ");

		for (int i = 0; i < N; ++i)
			nums[i] = Integer.parseInt(token.nextToken());

		for (int i = 0; i < N; ++i) {
			int sum = 0;
			for (int j = i; j < N; ++j) {
				sum += nums[j];

				if (sum == M)
					cnt++;

				if (sum >= M)
					break;
			}
		}
		
		System.out.println(cnt);

	}
}
