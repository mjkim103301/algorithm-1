# BOJ 1325번 [효율적인 해킹](https://www.acmicpc.net/problem/1325)

## 🌈 풀이 후기
시간초과 메모리초과 지옥이었습니다. 😇💀  
배열 순회할 때 index 필요 없으면 웬만하면 foreach 문 써야 할 것 같습니다. -> 이거 썼더니 시간초과 탈출했어요! 👻  

### 새로운 선언 방식을 알게 됐습니다.
`ArrayList<Integer>[] map;` : 열은 배열 행은 ArrayList 

## 👩‍🏫 문제 풀이
* `map[신뢰주체]` 에 신뢰 대상 컴퓨터 번호를 add 합니다.
* `visited ` 배열은 사이클이 있는 경우 dfs를 계속 도는 것을 막기 위해 사용했습니다.
* dfs를 돌면서 memo[index]++ 합니다. 
    `index`-> 다음에 가야할 곳
* 마지막으로 max 값과 memo[i] 가 같을 때마다 답을 출력합니다.