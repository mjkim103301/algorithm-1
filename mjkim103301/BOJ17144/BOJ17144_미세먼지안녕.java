import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17144_미세먼지안녕 {
    static class Node {
        int y, x;
        int origin; //원래 있던 미세먼지 양

        public Node(int y, int x, int origin) {
            this.y = y;
            this.x = x;
            this.origin = origin;
        }
    }

    static int R, C, T; //방의 행 길이, 열 길이, 시간
    static int[][] map; //방

    static Queue<Node> dust = new ArrayDeque<>(); // 초기 방의 미세먼지 저장
    static ArrayList<Integer> airCleaner = new ArrayList<>(); //공기청정기 열번호 저장
    static int answer;
    static int dydx[][] = {
            {-1, 0},//상
            {0, 1},//우
            {1, 0},//하
            {0, -1}//좌

    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int y = 0; y < R; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < C; x++) {
                int temp = Integer.parseInt(st.nextToken());
                map[y][x] = temp;
                if (temp == -1) { //공기청정기 열번호 저장
                    airCleaner.add(y);
                }
            }
        }

        solution();
        System.out.print(answer);

    }

    static void solution() {
        for (int i = 0; i < T; i++) {
            findDust(); //초기 방의 먼지를 큐에 저장
            spread(); //먼지 확산
            clean(); //공기청정기 작동
        }

        // T초 후 방의 미세먼지 총합 answer에 저장
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (map[y][x] >= 0) {
                    answer += map[y][x];
                }
            }
        }

    }

    static void findDust() {
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (map[y][x] <= 0) continue;
                dust.offer(new Node(y, x, map[y][x]));
            }
        }
    }

    static void spread() {
        while (!dust.isEmpty()) {

            Node d = dust.poll();
            int spreadAmount = d.origin / 5;
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int y = d.y + dydx[i][0];
                int x = d.x + dydx[i][1];
                if (y < 0 || x < 0 || y >= R || x >= C) {
                    continue;
                }
                if (map[y][x] == -1) continue;
                map[y][x] += spreadAmount;
                cnt++;
            }
            map[d.y][d.x] -= spreadAmount * cnt;
            if (map[d.y][d.x] <= 0) {
                map[d.y][d.x] = 0;
            }
        }
    }


    static void clean() {
        int counterC = airCleaner.get(0); // 공기청정기 위쪽 위치
        int clockwise = airCleaner.get(1); //공기청정기 아래쪽 위치

        //시계 반대방향으로 정화
        for (int y = counterC - 2; y >= 0; y--) {
            map[y + 1][0] = map[y][0];
        }
        for (int x = 1; x < C; x++) {
            map[0][x - 1] = map[0][x];
        }
        for (int y = 1; y <= counterC; y++) {
            map[y - 1][C - 1] = map[y][C - 1];
        }
        for (int x = C - 2; x > 0; x--) {
            map[counterC][x + 1] = map[counterC][x];
        }
        map[counterC][1] = 0;


        //시계방향으로 정화
        for (int y = clockwise + 2; y < R; y++) {
            map[y - 1][0] = map[y][0];
        }
        for (int x = 1; x < C; x++) {
            map[R - 1][x - 1] = map[R - 1][x];
        }
        for (int y = R - 2; y >= clockwise; y--) {
            map[y + 1][C - 1] = map[y][C - 1];
        }
        for (int x = C - 2; x > 0; x--) {
            map[clockwise][x + 1] = map[clockwise][x];
        }
        map[clockwise][1] = 0;
    }
}
