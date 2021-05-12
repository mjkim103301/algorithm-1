# BOJ 20291번 [파일 정리](https://www.acmicpc.net/problem/20291)

## 🌈 풀이 후기

- `List<String> keyList = new ArrayList<>(map.keySet());` 이 방식으로 맵 key를 정렬하는 방법을 알게 됐습니다.

## 👩‍🏫 문제 풀이

- '.' 이후의 문자열을 잘라서 해시맵에 저장합니다.
- 해시맵의 key를 사전순으로 정렬합니다.
- 해시맵을 차례대로 탐색하면서 key와 value를 출력합니다.
