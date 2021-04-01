# BOJ 17609번 [회문](https://www.acmicpc.net/problem/17609)

## 🌈 풀이 후기
* 생각보다 어려웠습니다. 체크 변수를 많이 두면서 코드가 복잡해진 것 같습니다.

## 👩‍🏫 문제 풀이
* left=0, right=문장길이-1 로 변수를 저장합니다.
* left 인덱스의 단어와 right 인덱스의 단어를 검사합니다.
* 단어가 같다면 left++, right-- 해줍니다.
* 단어가 다를 때 왼쪽 문자부터 삭제합니다.
* 왼쪽 문자를 삭제해도 단어가 다르면 다시 돌아와서 오른쪽 문자를 삭제합니다.
* 이 때도 문자가 다르면 2를 answer에 저장하고 return 합니다.

### change 변수와 checkLeft 변수를 따로 생성한 이유
* 왼쪽 문자를 없앤 후 left 문자와 right 문자가 다르다면 return 후 right 문자를 없애러 가야합니다.
* 이때, change 변수 1개로만 체크하면 change가 2번 일어나서 answer=2 로 저장됩니다.
* 그래서 왼쪽 문자를 없애면 checkLeft를 true 하고, 오른쪽 문자를 없앨 때 check를 true 했습니다.
