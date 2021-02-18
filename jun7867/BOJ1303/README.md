# BOJ 1303 전쟁-전투

[https://www.acmicpc.net/problem/1303](https://www.acmicpc.net/problem/1303)

## 🌈 풀이 후기

- bfs 방식을 이용해서 풀었습니다.
- 처음에 문제를 제대로 읽지 않고 가로 세로를 당연히 N * M인줄 알았지만 런타임에러가 뜨고 나서야 가로 세로를 반대로 했다는걸 알았습니다. 다음에는 문제를 정확히 보고 풀도록 하겠습니다.
- 함수를 여러개로 나눌때 method의 위치 설정을 어떻게 해야되는지 아시는분 있나요?? 예를 들어 main은 제일 밑으로 bfs는 main보다 위에, 새로 설정한 class는 위로 올리고... 이런 것을 어떤 위치에 둬야할지 모르겠네요...

## 👩‍🏫 문제 풀이

1. 매 i,j를 돌면서 bfs를 해줍니다. 
2. 이때, Visit boolean 배열 함께 사용하여 지난간 길인지 체크해줍니다. 만약 지나간 길이라면 바로 다음으로 넘어갑니다.
3. check라는 변수를 두어 지금 확인하는 팀이 아군인지(W) 적군인지(B) 저장합니다.
4. 상하좌우를 돌면서 범위내에 있으며 방문하지 않고 현재 확인하는 팀이 같은경우 방문처리와 count를 1 증가시키고 Queue에 넣어줍니다.

## 핵심 코드

```java
private static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(r, c));
		visit[r][c] = true;
		char check = map[r][c];
		int cnt = 1;

		while (!q.isEmpty()) {
			Node node = q.poll();

			// 상하좌우
			for (int i = 0; i < 4; i++) {
				nr = node.r + dx[i];
				nc = node.c + dy[i];
				// W
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc] && map[nr][nc] == check) {
					visit[nr][nc] = true;
					cnt++;
					q.offer(new Node(nr, nc));
				}
			}
		}
		if (check == 'W')
			sumW += cnt * cnt;
		else
			sumB += cnt * cnt;
}
```
