import java.io.*;
import java.util.*;

public class BOJ16973_직사각형탈출 {
    static int N, M, answer = -1;
    static int[][] map;
    static int H, W, sr, sc, fr, fc;
    static int[][] dydx = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };

    static class Node {
        int y, x;
        int cnt;

        Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static Queue<Node> queue = new ArrayDeque<>();
    static ArrayList<int[]> wall = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 1) {// 벽은 arraylist에 저장
                    wall.add(new int[]{y, x});
                }
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        fr = Integer.parseInt(st.nextToken()) - 1;
        fc = Integer.parseInt(st.nextToken()) - 1;
        init();
        solution();
        System.out.println(answer);
    }

    static void init() { // 직사각형이 갈 수 없는 곳은 2로 초기화
        for (int i = 0, end = wall.size(); i < end; i++) {
            int[] now = wall.get(i);
            for (int y = now[0]; y > now[0] - H; y--) {
                for (int x = now[1]; x > now[1] - W; x--) {
                    if (x < 0 || y < 0) break;
                    map[y][x] = 2;
                }
            }
        }
    }

    static void solution() {
        if (sr == fr && sc == fc) {
            return;
        }
        map[sr][sc] = 2;
        queue.offer(new Node(sr, sc, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int y = now.y + dydx[i][0];
                int x = now.x + dydx[i][1];
                if (!isValid(y, x)) continue;
                if (y == fr && x == fc) {
                    answer = now.cnt + 1;
                    return;
                }
                map[y][x] = 2;
                queue.offer(new Node(y, x, now.cnt + 1));

            }
        }
    }

    static boolean isValid(int y, int x) {
        // 직사각형이 범위를 벗어나면 return false
        if (y < 0 || x < 0 || y + H - 1 >= N || x + W - 1 >= M) {
            return false;
        }
        
        // 직사각형이 갈 수 없는 곳이면 return false
        if(map[y][x]>0){
            return false;
        }
        return true;
    }
}
