import java.util.*;
import java.io.*;

public class BOJ1922_네트워크연결 {
    static class Node implements Comparable<Node> {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static boolean[] visited;
    static int N, M;
    static int result;
    static LinkedList<Node>[] map; //인접리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        map = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            map[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            if (a == b) continue;
            map[a].addFirst(new Node(b, c));
            map[b].addFirst(new Node(a, c));
        }
        solution();
        System.out.println(result);
    }

    static void solution() {
        PriorityQueue<Node> queue = new PriorityQueue<>(); //pq로 최솟값 관리
        int[] path = new int[N];
        int connect = 0;
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0; // 0번 노드를 처음 연결시킬 컴퓨터로 설정
        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (visited[now.num]) continue;
            visited[now.num] = true; // 사용한 컴퓨터 true로 갱신
            result += now.cost; // 연결비용 갱신
            if (++connect == N) break; //연결시킨 컴퓨터 수와 N과 같으면 break;

            Iterator iter = map[now.num].iterator();
            while (iter.hasNext()) {
                Node p = (Node) iter.next();
                if (!visited[p.num] && path[p.num] > p.cost) {
                    path[p.num] = p.cost;
                    queue.offer(new Node(p.num, p.cost));
                }
            }
        }
    }
}
