import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] copy_map;
	static int N, M, D;
	static int max = 0;
	static int[] numbers;
	static int kill = 0;
	static int posArcher;
	static ArrayList<Node> enemy = new ArrayList<>();
	static Queue<Node> queue = new LinkedList<>(); // 궁수들 위치 저장.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M]; // 성이 제일 마지막열에 있으므로 N+1 만큼 선언해줌.
		copy_map = new int[N + 1][M];
		numbers = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0);
		System.out.println(max);

	}

	// 궁수의 위치 모든 조합.
	private static void combination(int idx, int start) {
		if (idx == 3) {
			// map, queue(궁수) 초기화.
			copy();
			queue.clear();
			// 궁수 위치 queue에 저장.
			for (int i = 0; i < 3; i++) {
				queue.add(new Node(N, numbers[i]));
			}
			kill = 0;
			// 적군을 한칸씩 내리는거보다 아처를 위로 올리는게 더 효율적이며 낭비를 줄일 수 있다.
			// N부터 시작해서 0까지 도달하면 종료하는걸로.
			posArcher = N;
			solve();
			return;
		}

		for (int i = start; i < M; i++) {
			numbers[idx] = i;
			combination(idx + 1, i + 1);
		}
	}

	private static void solve() {
		// 궁수들 위치가 한칸씩 위로 올라가서 맨 위까지 올라왔을까지.
		while (posArcher != 0) {
			enemy.clear(); // 적군 초기화.
			// 궁수 3명이 쏘기.
			for (int i = 0; i < 3; i++) {
				Node archer = queue.poll();
				int x = archer.x;
				int y = archer.y;
				int enemy_x=100;
				int enemy_y=100;
				int tmp_d;
				int min_d = D;

				// 궁수 위부터 탐색.
				for (int j = x - 1; j >= 0; j--) {
					for (int k = 0; k < M; k++) {
						// 궁수와 적군 사이의 거리.
						tmp_d = Math.abs(x - j) + Math.abs(y - k);
						// 적군이고 거리(최소) 안에 있을경우
						if (copy_map[j][k] == 1 && tmp_d <= min_d) {
							if(min_d == tmp_d) { // 최소거리가 같은 경우 k값이 더 작은걸로 선택.
								if(enemy_y > k) {
									enemy_x = j;
									enemy_y = k;
								}
							}
							// 최소거리가 있으면 
							else if(min_d > tmp_d) {
								min_d=tmp_d;
								enemy_x = j;
								enemy_y = k;
							}
						}
					}
				}
				// 최종 적군 
				queue.add(new Node(x-1,y));
				if(enemy_x !=100 && enemy_y !=100) {
                    enemy.add(new Node(enemy_x,enemy_y));
                }
			}
			// enemy update , 죽인수 ++ 
			for(int i=0;i<enemy.size();i++) {
				if(copy_map[enemy.get(i).x][enemy.get(i).y]==1) {
					copy_map[enemy.get(i).x][enemy.get(i).y]=0;
					kill++;
				}
			}
			posArcher--;
		}
		max=Math.max(max, kill);
	}

	public static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy_map[i][j] = map[i][j];
			}
		}
	}
}

class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
