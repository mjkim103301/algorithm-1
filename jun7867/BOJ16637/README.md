# BOJ 16637 괄호 추가하기

[https://www.acmicpc.net/problem/16637](https://www.acmicpc.net/problem/16637)

## 🌈 풀이 후기

- 재귀를 이용해서 풀었습니다.
- 처음에는 전체 케이스를 어떻게 나눌까 생각하다가 결국 괄호가 있냐 없느냐만 재귀적으로 돌려주면 될것 같아서 재귀로 풀게 되었습니다.

## 👩‍🏫 문제 풀이

**변수**

```tsx
static int N; // 길이
static char[] equation; // 수식을 저장한 배열 
static int computeNum = 0, temp = 0; // 중간 계산 결과 
static int max = Integer.MIN_VALUE; // 2^-31승이 최소값이므로 MIN_VALUE 사용.
```

1. 괄호가 없이 순차적으로 계산된 경우 
2. 괄호가 있어 뒤에가 먼저 계산된 경우.

이 두가지 케이스를 재귀적으로 풀어줍니다.

예를 들어, 8*3+5는 두가지 방법으로 풀 수 있습니다.

1. 순차적 계산 ⇒ (8*3) + 5
2. 뒤에서 부터 계산 ⇒ 8*(3+5) 

N은 무조건 홀수이기 때문에 기저조건에 의해 1개는 걸러짐으로 3개 계산은 반드시 일어납니다. 

단, 뒤에서부터 계산은 5개 이상 남아있어야 합니다.

---

계산된 결과는 다음 계산에 사용됨으로 인자로 함께 넘겨줍니다.

따라서 3개, 5개로 잘라서 재귀를 돌려줍니다.

## 핵심 코드

```java
// 순차적 계산. (계산 결과가 1개 들어가니까 recursion +2만 해줌)
computeNum = compute(result, equation[idx + 2] - '0', equation[idx + 1]);
recursion(idx + 2, computeNum);

// 뒤에 먼저 계산하고 앞에 계산.(5개 이상 남아있어야함) - 0 1 2 3 4
if (idx + 4 < N) {
		temp = compute(equation[idx + 2] - '0', equation[idx + 4] - '0', equation[idx + 3]);
		computeNum = compute(result, temp, equation[idx + 1]);
		recursion(idx + 4, computeNum);
}
```
