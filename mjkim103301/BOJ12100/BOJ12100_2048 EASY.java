import java.io.*;
import java.util.*;

public class BOJ12100_2048Easy_2 {
    static int N;
    
    static class Node {
        int num; //블럭 숫자
        int level; // 합쳐진 level

        Node() {
        }

        Node(int num, int level) {
            this.num = num;
            this.level = level;
        }
    }

    static int[] arr = new int[5];
    static Node[][] map, copyMap;
    static int[][] dydx = {
            {-1, 0}, // 상
            {1, 0}, // 하
            {0, -1}, // 좌
            {0, 1} // 우
    };
    static ArrayList<Node> temp = new ArrayList<>();
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new Node[N][N];
        copyMap = new Node[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = new Node(Integer.parseInt(st.nextToken()), 0);
            }
        }

        solution();
        System.out.println(max);
    }

    static void solution() {
        copy();
        permutation(0);
    }

    static void permutation(int level) { // 중복순열
        if (level == 5) {
            for (int i = 0; i < 5; i++) {
                moveBoard(arr[i], i + 1);
            }
            getMax();
            copy();
            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[level] = i;
            permutation(level + 1);
        }
    }

    static void moveBoard(int d, int level) {
        int size = 0;
        if (d == 0) {//상
            for (int x = 0; x < N; x++) {
                temp.clear();
                for (int y = 0; y < N; y++) {
                    add(copyMap[y][x], level);
                    copyMap[y][x] = new Node();
                }

                //위쪽부터 재배치
                size = temp.size();
                for (int y = 0; y < N; y++) {
                    if (size == y) break;
                    copyMap[y][x] = temp.get(y);
                }

            }

        } else if (d == 1) {//하
            for (int x = 0; x < N; x++) {
                temp.clear();
                for (int y = N - 1; y >= 0; y--) {
                    add(copyMap[y][x], level);
                    copyMap[y][x] = new Node();
                }

                //밑에서부터 재배치
                size = temp.size();
                for (int y = N - 1; y >= 0; y--) {
                    if (size == N - 1 - y) break;
                    copyMap[y][x] = temp.get(N - 1 - y);
                }

            }

        } else if (d == 2) {//좌
            for (int y = 0; y < N; y++) {
                temp.clear();
                for (int x = 0; x < N; x++) {
                    add(copyMap[y][x], level);
                    copyMap[y][x] = new Node();
                }

                //왼쪽부터 재배치
                size = temp.size();
                for (int x = 0; x < N; x++) {
                    if (size == x) break;
                    copyMap[y][x] = temp.get(x);
                }

            }

        } else if (d == 3) {//우
            for (int y = 0; y < N; y++) {
                temp.clear();
                for (int x = N - 1; x >= 0; x--) {
                    add(copyMap[y][x], level);
                    copyMap[y][x] = new Node();
                }

                //오른쪽부터 재배치
                size = temp.size();
                for (int x = N - 1; x >= 0; x--) {
                    if (size == N - 1 - x) break;
                    copyMap[y][x] = temp.get(N - 1 - x);
                }

            }
        }
    }

    static void add(Node now, int level) {
        if (now.num > 0) {
            int size = temp.size();

             //블럭 2개가 값이 같고 이전에 변경되지 않았다면, (노드의 레벨값이 현재 레벨값보다 작다면)
             //temp에 들어있는 노드의 num을 2배해주고, level을 현재 level로 갱신한다.
            if (size > 0 && temp.get(size - 1).num == now.num && temp.get(size - 1).level < level) {
                temp.get(size - 1).num = now.num * 2;
                temp.get(size - 1).level = level;
            } else {// 블럭값이 다르거나, 이전에 변경된 블럭이라면, temp에 바로 넣는다.
                temp.add(now);
            }
        }
    }


    static void getMax() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (copyMap[y][x].num > max) {
                    max = copyMap[y][x].num;
                }
            }
        }
    }

    static void copy() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                copyMap[y][x] = new Node(map[y][x].num, map[y][x].level);
            }

        }
    }
}
