# BOJ 17609: 회문

## 🌈 풀이 후기

- 투포인터를 응용해서 풀었습니다.
- 유사회문을 찾기 위해 불필요한 중복 코드가 들어간거 같아서 썩 좋은 코드는 아닌거 같지만 이렇게 풀어도 시간초과가 안나네요

## 👩‍🏫 문제 풀이

**알고리즘 - 투포인터**

1. 문자열의 맨 처음과 끝을 start, end로 잡습니다.
2. 만약 문자열의 start번째 값과 end번째 값이 같다면 start는 +1 , end는 -1 해주면서 범위를 줄여줍니다.
3. 만약 같지 않다면 두가지 경우로 나눠서 카운트 해줍니다.
3-1 . start만 1증가하는 경우
3-2. end만  1 감소하는 경우
4. 두 가지 경우중 가장 카운트가 작은값을 사용해 회문을 구분해줍니다.

**핵심코드**

```jsx
private static int findRRR() {
  int start = 0;
  int end = str.length() - 1;
  int failCnt = 0;
  while (start <= end) {
    if (str.charAt(start) != str.charAt(end)) {
      end -= 1;
      failCnt++;
    } else {
      start += 1;
      end -= 1;
    }
  }
  return failCnt;
}

private static int findRRL() {
  int start = 0;
  int end = str.length() - 1;
  int failCnt = 0;
  while (start <= end) {
    if (str.charAt(start) != str.charAt(end)) {
      start += 1;
      failCnt++;
    } else {
      start += 1;
      end -= 1;
    }
  }
  return failCnt;
}
```
