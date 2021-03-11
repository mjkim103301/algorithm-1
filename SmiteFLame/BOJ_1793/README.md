# BOJ 1793번 타일링

## 🌈 풀이 후기
백준이나 프로그래머스에서 타일링 문제를 몇 번 풀어본적이 있어서 쉽게 풀릴줄 알았는데<br>
문제 잘못 읽고 범위 파악도 잘못해서 힘들었습니다. <br>
2 * 2을 추가해서 1부터 10까지 계속 구해보고 점화식 만들어서 풀었습니다.

BigInteger 변수를 사용해서 풀었는데<br>
생각보다 일반 변수로 사용 못하고 거의 함수처럼 사용해야 되서 오래걸렸습니다

## 👩‍🏫 문제 풀이
<br>

### 변수
- max(int): 입력 받은 값들 중에서 최대의 값
- data(ArrayLisy<Integer>): 데이터들을 계속 저장
- fibonacci(Integer[]) : 피보나치 함수(인줄 알았던) 데이터의 저장 값

### 점화식
fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2] * 2;

### 핵심코드
``` java
fibonacci[0] = BigInteger.valueOf(1);
fibonacci[1] = BigInteger.valueOf(1);
for (int i = 2; i <= max; i++) {
	fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2].multiply(BigInteger.valueOf(2)));
}
```