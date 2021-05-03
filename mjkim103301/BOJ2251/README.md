# BOJ 2251번 [물통](https://www.acmicpc.net/problem/2251)

## 🌈 풀이 후기

## 👩‍🏫 문제 풀이
* bfs 형식으로 물을 옮길수 있는 모든 경우를 큐에 넣어줬습니다.
    * A->B
    * A->C
    * B->A
    * B->C
    * C->A
    * C->B
* 큐에서 poll을 하면서 중복체크를 했고, A물통이 비어있는 경우 `boolean [] water`  배열에 체크했습니다. 
