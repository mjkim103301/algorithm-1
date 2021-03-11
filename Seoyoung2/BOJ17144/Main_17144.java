package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 17144. 미세먼지 안녕!
public class Main_17144 {
	static int R, C;
	static int[][] map;
    static int air;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1)	air = i;
			}
		}
        
        while(T-- > 0) {
        	spread();
        	clean();
        }
        
        int ans = 0;
        for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += map[i][j];
			}
		}
        System.out.println(ans+2);
	}
	
	static void spread() {
		Queue<int[]> dust = new LinkedList<int[]>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0)	dust.offer(new int[] {i, j, map[i][j]});
			}
		}
		
		int[][] dxdy = {{-1,0}, {1,0}, {0,-1}, {0,1}};
		while(!dust.isEmpty()) {
			int[] tmp = dust.poll();
			int x = tmp[0], y = tmp[1];
			int cnt = tmp[2]/5;
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = x + dxdy[i][0];
				ny = y + dxdy[i][1];
				if(nx<0 || nx>=R || ny<0 || ny>=C || map[nx][ny] == -1)	continue;
				map[nx][ny] += cnt;
				map[x][y] -= cnt;
			}
		}
	}
	
	static void clean() {
		// 공기청정기 위치 : map[air-1][0], map[air][0] 
		
		for (int i = air-2; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		for (int i = 0; i < C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		for (int i = 0; i < air-1; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for (int i = C-1; i > 1; i--) {
			map[air-1][i] = map[air-1][i-1];
		}
		map[air-1][1] = 0;
		
		for (int i = air+1; i < R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for (int i = 0; i < C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		for (int i = R-1; i > air; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for (int i = C-1; i > 1; i--) {
			map[air][i] = map[air][i-1];
		}
		map[air][1] = 0;
	}
}
