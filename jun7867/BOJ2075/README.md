# BOJ 2075 N번째 큰 수

## 🌈 풀이 후기

- 우선순위큐를 이용하면 정말 쉽게 풀 수 있습니다.
- 우선순위 큐를 그냥 사용하면 내림차순으로 정렬되기 때문에 생성할때 Collections.reverseOrder()를 넣어주면 오름차순으로 정렬된 상태로 queue에 저장되어 쉽게 사용할 수 있습니다.
- 알고리즘은 O(NLogN) 입니다.

## 👩‍🏫 문제 풀이

**알고리즘 - 우선순위 큐**

1. 우선순위 큐를 생성하고 하나씩 넣는다. 이때 우선순위 큐에 Collections.reverseOrder()를 넣어 오름차순으로 우선순위를 설정한다.
2. Queue가 빌때까지 poll 하는데 N번째 poll값을 return 해준다.

**핵심 코드**

```java
private static int sol() {
		int cnt = 1;
		while (!q.isEmpty()) {
			if (cnt == N)
				return q.poll();
			else
				q.poll();
			cnt++;
		}
		return -1;
}
```
