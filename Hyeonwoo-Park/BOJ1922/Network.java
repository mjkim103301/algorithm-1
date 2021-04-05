import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Network {

	private static int f(int[] p, int a) {
		if (p[a] == 0 || p[a] == a)
			return a;

		return (p[a] = f(p, p[a]));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
		int sum = 0, cnt = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		int[] parents = new int[N + 1];

		for (int i = 0; i < M; ++i) {
			token = new StringTokenizer(reader.readLine());
			int st = Integer.parseInt(token.nextToken());
			int ed = Integer.parseInt(token.nextToken());
			int cost = Integer.parseInt(token.nextToken());

			pq.add(new int[] { cost, st, ed });
		}

		while (cnt < N - 1) {
			int cur[] = pq.poll();

			int ra = f(parents, cur[1]);
			int rb = f(parents, cur[2]);

			if (ra == rb)
				continue;
			
			cnt++;
			parents[ra] = rb;
			sum += cur[0];
		}

		System.out.println(sum);
	}
}
