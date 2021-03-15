# BOJ 2629번 [양팔저울](http://noj.am/2629)

## 🌈 풀이 후기
- Set을 foreach구문 안에서 변경하게 될 경우 `ConcurrentModificationException`예외가 발생합니다.
- `CopyOnWriteArraySet`를 사용해서 해결했습니다.
## 👩‍🏫 문제 풀이
- 입력을 받으면서
    - |set에 들어있는 값에 입력을 뺀값|, set에 들어있는 값에 입력을 더한값을 추가합니다.
- 이후 구슬을 입력받으면서 셋에 있는 값인지 확인합니다.
