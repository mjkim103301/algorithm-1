# BOJ 2075번 N번째 큰 수

## 🌈 풀이 후기
다른 분들이 푸신거 보고 문제를 정말 정말 간단한걸 알았습니다... <br>
골드 문제여서 시간 효율을 최대한 내려고 했는데 오히려 시간 효율이 떨어졌네요.. <br>
조건에 맞춰서 저장하는 것보다 그냥 우선순위 큐에 넣는게 더 이득이였네요..


## 👩‍🏫 문제 풀이
<br>

### 변수
- N(int): 배열의 크기, 원하는 수
- data(int[][]): 데이터 저장
- pQueue(PriorityQueue<dataStructure>): N개의 데이터를 우선순위에 넣고 활용

<br>

- dataStructrue(num, i, j) - 데이터와 데이터의 위치값을 가지고 있음

### 원리
1. 가장 아래에 있는 데이터들을 전부 우선순위 큐에 넣는다.
2. 우선순위가 가장 높이 있는 데이터를 뺀 후 자신보다 위의 행에 있는 데이터를 넣는다
3. 2번 과정을 N - 1번 진행을 한다.
4. 진행 후에 맨 위에 있는 데이터를 출력한다.

### 핵심코드
```java
static class dataStructure implements Comparable<dataStructure> {
	int num, i, j;

	public dataStructure(int num, int i, int j) {
		this.num = num;
		this.i = i;
		this.j = j;
	}

	public int compareTo(dataStructure o) {
		return o.num - this.num;
	}

}
```

```java
for (int i = 0; i < N - 1; i++) {
	dataStructure temp = pQueue.poll();
	if (temp.i > 0) {
		pQueue.offer(new dataStructure(data[temp.i - 1][temp.j], temp.i - 1, temp.j));
	}
}
```