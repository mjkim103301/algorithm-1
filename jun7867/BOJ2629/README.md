# BOJ 2629: 양팔저울

## 🌈 풀이 후기

- 문제 힌트에 DP가 있어서 부분수열?(DFS?) + DP를 적용하였습니다.  부분수열을 다 만들어 주기 보다 계산하는 값들을 계속 넘겨서 찾도록 했습니다. 다시 되돌리지 않기 위해서
- ArrayIndex 에러가 계속 떠서 확인하니 dp를 생성할때 구슬의 무게를 고려 안해서 뜨더라고요.. 결국 추의 무게랑 관계없이 알고 싶은 구슬의 무게가 40000이니까 dp를 40001까지 생성해줘야 합니다.

## 👩‍🏫 문제 풀이

**알고리즘 - DP** 

-방식은 계속 찾아 주는것으로 하나 dp에 해당 값을 이미 탐색했다는 것을 알려주기 위해 저장해 놓습니다.

-만약에 이미 계산했거나 idx가 N까지 도달했다면 바로 종료시킵니다.

**핵심 코드**

```tsx
private static void subset(int idx, int w) {
		// 기저조건 1
		if (dp[idx][w]) // idx에서 weight를 가지고 있는가?
			return;
		dp[idx][w] = true;

		// 기저조건 2
		if (idx == N)
			return;

		subset(idx + 1, w + weight[idx]); // 추 더하기
		subset(idx + 1, w); // 추 pass
		subset(idx + 1, Math.abs(w - weight[idx])); // 추 빼기
}
```
