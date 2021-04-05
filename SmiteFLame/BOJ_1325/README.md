# BOJ 1325번 효율적인 해킹

## 🌈 풀이 후기
몇일 동안 계속 다양한 아이디어를 생각하면서 풀었습니다...<br>
BFS로 맨 처음에 풀었다가 안되서 DFS로 바꾸고<br>
DFS도 접근 방법을 바꿔서 역으로 계산해나가는 방법을 사용했습니다. <br>
그래도 시간초과 나서 좀 쉬다가 다시 봤는데<br>
```
visited[i] = true;
```
이 한줄 안 쓴거 겨우 알아서 통과했습니다...ㅠㅠㅠㅠㅠㅠ<br>
코드를 작성하면서 실수가 없는지 계속 확인하면서 작성해야될거 같습니다


## 👩‍🏫 문제 풀이
<br>

### 변수
- N(int): 컴퓨터의 개수
- M(int): 해킹할 수 있는 컴퓨터의 조사
- hackList(ArrayLisy<Integer>): 각 컴퓨터가 신뢰하는 컴퓨터
- maxList(int[]) : 해킹할 수 있는 컴퓨터의 술

### 원리
1. 모든 원소별로 DFS를 통해서 신뢰하는 컴퓨터를 접속합니다.
2. DFS에 들어가게 되면 자신을 신뢰하는 컴퓨터가 존재하는 것이기 때문에 +1을 해줍니다.
3. 모든 컴퓨터를 조사한 후에 최대값을 찾습니다.
4. 최대값하고 일치한 컴퓨터들을 출력합니다.

### 핵심코드
```
	private static void DFS(int idx) {
		for(int i : hacklist[idx]) {
			if(visited[i]) continue;
			visited[i] = true;
			maxList[i]++;
			DFS(i);
			max = maxList[i] > max ? maxList[i] : max;
		}
	}

	private static void implement() {
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			visited[i] = true;
			DFS(i);
		}
	}
```