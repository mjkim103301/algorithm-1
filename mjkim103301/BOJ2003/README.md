# BOJ 2003번 [수들의 합2](https://www.acmicpc.net/problem/2003)

## 🌈 풀이 후기
* 누적합으로 풀린 간단한 문제였습니다.
## 👩‍🏫 문제 풀이
* `accum` 배열에 누적합을 저장합니다.
* `find(int i)` 메서드에서 i번째 값이 M 이면 바로 `return true;` 합니다.
* 아니라면 `accum[i]- accum[j]` 값이 M이라면 `return true;` M 보다 작다면 바로 `return false;`를 합니다.
* 배열을 다 돌아도 M 값을 못찾았다면 `return false; `합니다.
