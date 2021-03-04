# BOJ 2003 수들의 합2

## 🌈 풀이 후기

- 전형적인 투 포인터 문제입니다. 투 포인터 개념을 익히기에 좋은 문제인것 같습니다. 
[https://www.youtube.com/watch?v=rI8NRQsAS_s&ab_channel=동빈나](https://www.youtube.com/watch?v=rI8NRQsAS_s&ab_channel=%EB%8F%99%EB%B9%88%EB%82%98)

    제가 좋아하는 동빈나에서 자세히 알려주고 있습니다 ㅎㅎ 심심하면 봐보세요!

- 비슷하게 잘 나오는 문제로 누적합 문제가 있는데 백준 11659 입니다. 한번 풀어보세요!

## 👩‍🏫 문제 풀이

**알고리즘 -** 투 포인터

```java
static int N, M;
static int[] A; // 수들을 배열에 저장
static int cnt = 0; // 합이 M인 경우의 수
```

1. start와 end를 초기에 0을 잡는다.
2. start와 end 사이의 값이 M보다 작다면 end를 1 증가시킨다. (end는 배열의 끝까지 검사한다.)
3. 만약 start와 end의 합이 M보다 크거나 같다면 M과 같은지 검사한다.
3-1. 같다면 경우의 수를 1 증가시킨다. 
4. start와 end의 합에서 start값을 빼준다. 그리고 start를 1 증가시켜준다.

**핵심 코드**

```java
private static void twoPointer() {
		int sum = 0;
		int end = 0;
		for (int start = 0; start < N; start++) {
			while (sum < M && end < N)
				sum += A[end++];

			if (sum == M)
				cnt++;

			sum -= A[start];
		}
}
```
