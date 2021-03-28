# BOJ 17609번 [회문](https://www.acmicpc.net/problem/17609)



## 🌈 풀이 후기

투포인터로 회문인지 구하는 문제. 

left를 제거하고 계속 진행해서 실패가 나온 경우, left 대신 right를 제거하는 것을 고려하지 않아 실패했다. (예 : abcbab)

## 👩‍🏫 문제 풀이

- 변수 l, r 을 두어서 l++, r-- 하면서 검사
- l == r 이면 continue,
- l != r 이고 l+1, r-1 값 모두 다르다면 그냥 실패이므로 break
- 그것도 아니면 유사회문 가능성이 있으므로 l++, r-- 경우를 고려해 2번 돌아가는 for문을 만들었다.
  -> 한번 돌고 유사회문이라면 break, 실패했다면 다음 경우 고려

```java
for (int i = 0; i < 2; i++) {
  res = 1;
  int tl = l, tr = r;
  if(i==0)	tl++;	 else	tr--;

  while(++tl < --tr) {
    if(str.charAt(tl) != str.charAt(tr)) {
      res = 2;
      break;
    }
  }
  if(res == 1)	break;
}
```



