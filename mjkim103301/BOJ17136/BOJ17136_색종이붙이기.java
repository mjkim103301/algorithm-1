import java.io.*;
import java.util.*;

public class BOJ17136_색종이붙이기 {
    static int[][] map = new int[10][10];
    static int[] paper = {5, 4, 3, 2, 1};
    static int[] paperCnt = {5, 5, 5, 5, 5};
    static int answer = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int y = 0; y < 10; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 10; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        dfs(0, 0);

        // answer==26 은 색종이를 모두 합한 25 보다 크므로 만들 수 없다.
        // answer= -1 저장
        if (answer == 26) {
            answer = -1;
        }
    }

    static void dfs(int level, int cnt) {
        
        // map[9][9] 까지 모두 채웠을 때
        if (level == 100) {
            if (answer > cnt) {
                answer = cnt;
            }
            return;
        }
        
        // 현재 장수(cnt) 가 최소 장수(answer) 이상일 때 return;
        if (answer <= cnt) return;
        
        // map의 좌표 구함
        int y = level / 10;
        int x = level % 10;

        if (map[y][x] == 0) {
            dfs(level + 1, cnt);
        } else {
            
            // map[y][x]==1 이므로 색종이 필요함
            for (int i = 0; i < 5; i++) {
                // 종이가 없을 때
                if (paperCnt[i] == 0) continue;
                
                // 종이로 1을 채울 수 있을 때
                if (isValid(y, x, i)) {
                    fill(y, x, i, 0);
                    paperCnt[i]--;
                    dfs(level + paper[i], cnt + 1);
                    fill(y, x, i, 1);
                    paperCnt[i]++;
                }
            }
        }
    }

    static boolean isValid(int y, int x, int i) {
        for (int yy = y; yy < y + paper[i]; yy++) {
            for (int xx = x; xx < x + paper[i]; xx++) {
                if (yy >= 10 || xx >= 10) return false;
                if (map[yy][xx] == 0) return false;
            }
        }
        return true;
    }

    static void fill(int y, int x, int i, int target) {
        for (int yy = y; yy < y + paper[i]; yy++) {
            for (int xx = x; xx < x + paper[i]; xx++) {
                map[yy][xx] = target;
            }
        }
    }
}
