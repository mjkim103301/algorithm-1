# BOJ 1327번 [소트 게임](https://www.acmicpc.net/problem/1327)

## 🌈 풀이 후기
* StringBuilder에서 equals메서드를 쓸 때에는 toString()으로 변경해야한다는 사실을 알았습니다.
    ``` java
    StringBuilder sb1 = new StringBuilder("Hello");
    StringBuilder sb2 = new StringBuilder("Hello");
    sb1.toString().equals(sb2.toString()) -> true
    sb1.equals(sb2) -> false 😂
    ```
## 👩‍🏫 문제 풀이
* `String target` 에 미리 정렬한 순열을 저장합니다.
* 입력받은 문자열이 target과 일치하는지 확인합니다.
* 같다면, min=0 -> 종료
* 다르다면, bfs
    * 큐에서 Node를 꺼냅니다. Node에는 문자열, 변경횟수, 뒤집기 시작한 index(changedIndex)가 저장됐습니다.
    * for문을 돌면서 i가 현재 노드의 changedIndex와 같으면 continue합니다.
    * 조건에 맞춰 변경한 문자열이 set에 이미 저장됐다면 continue합니다.
    * target과 문자열이 일치하는지 확인 후, 같다면 종료, 다르다면 큐에 넣고 계속 진행합니다.

