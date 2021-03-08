# BOJ 17144번 [미세먼지 안녕!](https://www.acmicpc.net/problem/17144)



## 🌈 풀이 후기

이런 구현문제가 제일 재밌는 듯 하다,,, 근데 풀고나니 정답은 나오는데 코드가 뭔가 지저분해 보임,,

## 👩‍🏫 문제 풀이

- 입력받을 때, -1이면 공기청정기이기 때문에 air 변수에 저장 (무조건 1열이기 때문에 행번호 저장, 연속된 두 수이기 때문에 아래 인덱스 저장)

- T번만큼 반복을 돌면서 <code>spread()</code> 와 <code>clean()</code> 호출

- <code>spread()</code> 

  - 2차원 배열을 순회하면서 미세먼지가 있는 구역의 위치와 양을 큐에 저장한다.

  - 큐에서 하나씩 빼가면서 상하좌우 검사 후 미세먼지를 퍼뜨린다.

  - 주요 코드

    ```java
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
    ```

- <code>clean()</code>
  - 공기가 순환되는 순서로 계산하면 임시변수를 두어 저장해놓고 복구하는 등 복잡해지기 때문에 반대방향으로 계산을 하면서 구현했다.
  - 위아래로 4방향이어서 코드가 상당히 복잡한거같다. 근데 다른 방법은 생각 안났다..