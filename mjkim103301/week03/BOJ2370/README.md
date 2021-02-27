# BOJ 2370번 [시장선거 포스터](https://www.acmicpc.net/problem/2370)

## 🌈 풀이 후기
UnionFind, LinkedList 로 풀이를 시도했지만 설계에 어려움을 겪었습니다.
 
02.23  
동혁님 풀이방법 읽고 다시 풀어봤습니다!  
감사합니다~
## 👩‍🏫 문제 풀이
### 전역변수

* `static class Node{}` // 포스터의 왼쪽, 오른쪽 좌표 
* ` static int N;` //포스터 총 수
* ` static Node[] posters;` //입력으로 주어지는 포스터 정보
* ` static Set<Integer> set=new HashSet<>();` // HashSet: 중복제거O, 정렬X
* `static int[] attach;` // 중복제거한 페이지 저장하는 배열
* ` static int[] overlap; `// 부착된 페이지 기록하는 배열
