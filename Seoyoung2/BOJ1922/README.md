# BOJ 1922번 [네트워크 연결](https://www.acmicpc.net/problem/1922)



## 🌈 풀이 후기

Prim 알고리즘을 연습하고 싶어 Prim으로 풀었습니다. 

## 👩‍🏫 문제 풀이

- 따로 클래스를 만들지 않고 int형 배열을 `PriorityQueue` 에 넣기 때문에 생성 시에 아래와 같이 정렬 기준을 준다.

  ``` java
  PriorityQueue<int[]> pq = new PriorityQueue<>(M, (x, y) -> x[1] - y[1]);
  ```

- 인접행렬 대신 인접 리스트 사용

  ```java
  LinkedList<int[]> list[] = new LinkedList[N];
  ```

- 나머지는 수업시간에 배운 Prim 알고리즘과 동일!