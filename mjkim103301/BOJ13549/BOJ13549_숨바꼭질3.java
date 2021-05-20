import java.util.*;

public class BOJ13549_숨바꼭질3 {
    static class Node implements Comparable<Node> {
        int num;
        int time;

        Node(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static int N, M;
    static int answer;
    static PriorityQueue<Node> queue = new PriorityQueue<>();
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        solution();
        System.out.println(answer);
    }

    static void solution() {
        queue.offer(new Node(N, 0));
        bfs();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            visit[now.num] = true;
            if (now.num == M) {
                answer = now.time;
                return;
            }

            if (now.num * 2 <= 100000 && !visit[now.num * 2]) {
                queue.offer(new Node(now.num * 2, now.time));
            }
            if (now.num + 1 <= 100000 && !visit[now.num + 1]) {
                queue.offer(new Node(now.num + 1, now.time + 1));
            }

            if (now.num - 1 >= 0 && !visit[now.num - 1]) {
                queue.offer(new Node(now.num - 1, now.time + 1));
            }
        }
    }


}
