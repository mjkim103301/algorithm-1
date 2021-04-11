# BOJ 12847번 [꿀 아프바이트]](https://www.acmicpc.net/problem/12847)

## 🌈 풀이 후기
* 자료형을 long으로 해주면 되는 간단한 문제였습니다.
## 👩‍🏫 문제 풀이
* 슬라이딩 윈도우 방식으로 풀었습니다.
* M일동안 받을 수 있는 돈(temp)을 계산하고 answer와 비교합니다.
* answer 보다 temp가 크면 answer를 갱신합니다.
* temp에서 money[i-M] 를 빼고 money[i]를 더하면서 위의 과정을 비교합니다.
