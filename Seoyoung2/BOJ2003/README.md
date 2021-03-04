# BOJ 2003번 [수들의 합 2](https://www.acmicpc.net/problem/2003)



## 🌈 풀이 후기

어떻게하면 더 깔끔하게 풀까 고민하면서 푼 문제. 재밌었다 :smiley:

## 👩‍🏫 문제 풀이

- 수열의 연속적인 수들의 합을 고려하는 문제로 더하기 시작하는 값을 가리키는 <code>start</code> 변수를 두어 합을 계산하였다.

- 입력받는 크기 N짜리 배열을 두어 입력받는 동시에 연산을 하였다. 
- 입력받은 수를 <code>sum</code> 변수에 더해 M과 크거나 같으면 while문을 돈다. 
- while문을 돌때마다 sum 에서 start 인덱스가 가리키는 값을 하나씩 빼주면서 M과 같으면 ans++하고 M보다 작아지면 break한다.

```java
int start = 0, sum = 0;
for (int i = 0; i < N; i++) {
  nums[i] = Integer.parseInt(st.nextToken());
  sum += nums[i];
  if (sum >= M) {
    do {
      if (sum == M)	ans++;
      sum -= nums[start++];
    } while (sum >= M);
  }
}
```



