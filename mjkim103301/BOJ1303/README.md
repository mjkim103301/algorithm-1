# BOJ 1303번 [전쟁 - 전투](https://www.acmicpc.net/problem/1303)

## 🌈 풀이 후기
* 큐를 생성할 때 ArrayDeque 를 사용해봤습니다. 검색해보면 ArrayDeque가 더 빠르다고 하는데 이 문제에서는 LinkedList가 더 빠르게 나와서 더 공부해봐야 할 것 같습니다.

## 👩‍🏫 문제 풀이
BFS를 통해 개수를 세야 하는 문자의 종류가 2개이기 때문에 bfs를 2번 돌렸습니다.
### 메서드
`static int[]solution()`  ans 배열에 답을 저장해서 메인문으로 리턴합니다.  
`static int strength(char target)`  배열을 순회하면서 target과 일치하는 좌표를 만났을 때 큐에 넣습니다.  bfs를 수행한 결과 N^2 를 계산해서 위력에 더합니다.  
`static int bfs(char target)`  큐와 visited배열을 사용해서 target과 일치하는 개수를 셉니다.
