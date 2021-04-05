import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArraySet;

public class Scale {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer token = new StringTokenizer(reader.readLine());
		Set<Integer> s = new CopyOnWriteArraySet<>();
		s.add(0);

		for (int i = 0; i < N; ++i) {
			int inp = Integer.parseInt(token.nextToken());

			for (Integer num : s) {
				if (num - inp > 0)
					s.add(num - inp);
				else
					s.add(inp - num);

				s.add(num + inp);
			}
		}

		int M = Integer.parseInt(reader.readLine());
		token = new StringTokenizer(reader.readLine());

		for (int i = 0; i < M; ++i) {
			int inp = Integer.parseInt(token.nextToken());
			
			if (s.contains(inp))
				System.out.print("Y ");
			else
				System.out.print("N ");
		}
	}
}
