import java.util.*;
import java.io.*;

public class BOJ16918_봄버맨 {
    static class Node {
        char ch;
        int bombTime;

        public Node(char ch, int bombTime) {
            this.ch = ch;
            this.bombTime = bombTime;
        }
    }

    static int[][] dydx = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    static int R, C, T;
    static Node[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new Node[R][C];
        for (int y = 0; y < R; y++) {
            String input = br.readLine();
            for (int x = 0; x < C; x++) {
                char ch = input.charAt(x);
                map[y][x] = new Node(ch, ch == 'O' ? 3 : 0); //폭탄인 경우: 폭탄이 터지는 시간인 3초를 저장
            }
        }
        solution();
        System.out.println(sb);
    }

    static void solution() {
        int time = 1;
        while (time < T) {
            time++;
            for (int y = 0; y < R; y++) {
                for (int x = 0; x < C; x++) {
                    if (map[y][x].ch == 'O' && map[y][x].bombTime == time) {// 폭탄 터짐
                        for (int i = 0; i < 4; i++) {
                            int yy = y + dydx[i][0];
                            int xx = x + dydx[i][1];
                            if (yy < 0 || xx < 0 || yy >= R || xx >= C) continue;

                            //지금 터트필 폭탄보다 나중에 설치된 폭탄 제거
                            if (map[yy][xx].ch == 'O' && map[yy][xx].bombTime > time) {
                                map[yy][xx] = new Node('.', time); // 현재 시간으로 변경
                            }
                        }
                        map[y][x] = new Node('.', time); // 현재 폭탄 제거

                    } else if (map[y][x].ch == '.' && map[y][x].bombTime < time) {

                        //변경된 시간이 현재 시간보다 더 작을 경우에 폭탄 설치
                        //폭탄이 터질 시간 (time+3) 으로 저장
                        map[y][x] = new Node('O', time + 3);
                    }
                }
            }
        }

        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                sb.append(map[y][x].ch);
            }
            sb.append("\n");
        }
    }
}
