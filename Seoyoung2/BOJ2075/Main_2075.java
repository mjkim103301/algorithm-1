package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 2075. N번째 큰 수
public class Main_2075 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		// 2차원 배열 생성 후 정렬 : 1516ms
//		int N2 = N*N;
//		int[] num = new int[N2];
//		for (int i = 0; i < N2; i++) {
//			if(i%N == 0) {
//				st = new StringTokenizer(br.readLine());
//			}
//			num[i] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(num);
//		System.out.println(num[N2-N]);

		// 우선순위큐 생성 후 하나씩 제거 : 2124ms
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < N; j++) {
//				pq.offer(Integer.parseInt(st.nextToken()));
//			}
//			
//		}
//		for (int i = 0, end = N*N-N; i < end; i++) {
//			pq.poll();
//		}
//		System.out.println(pq.poll());
		
		// 우선순위큐 생성 후 하나씩 제거 (max heap으로 만들어 제거하는 횟수 줄이기) : 896ms
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			
		}
		for (int i = 1, end = N; i < end; i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}
}
