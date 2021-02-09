# BOJ 1182번 부분 수열의 합

## 🌈 풀이 후기
수업시간에 배웠던 부분집합을 활용하였습니다.<br>
Bitmask를 실제 문제에 활용해서 푼 첫 문제여서 헷갈린 점이 있었습니다.<br>
모든 부분집합을 구하는것과 공집합을 제외하는 것이 핵심입니다<br>


## 👩‍🏫 문제 풀이
<br>

### 변수
- N(int): 데이터의 개수
- M(int): 원하는 합
- data(int[]): N개의 데이터
- subset(boolean[]): 부분집합 저장

### 원리
1. 모든 부분집합의 경우의 수를 제작
2. 부분집합을 만들때 마다 해당되는 데이터의 합을 구함



<br>
i가 1부터 시작 하면서 공집합의 경우의 수는 제외시켰습니다

```java
for (int i = 1, end = 1 << N; i < end; i++) {
    for (int j = 0; j < N; j++) {
        if ((i & 1 << j) != 0) {
            subset[j] = true;
        } else{
            subset[j] = false;
        }
    }
    // Subset 완성
    implement();
}
```
