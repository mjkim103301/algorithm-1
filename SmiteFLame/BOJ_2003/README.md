# BOJ 2003번 수들의 합

## 🌈 풀이 후기
투 포인터를 활용하여서 문제를 풀었습니다.<br>
많이 풀어본 알고리즘이 아니여서 조건문을 설정하는 것이 오래 걸렸습니다<br>



## 👩‍🏫 문제 풀이
<br>

### 변수
- N(int): 데이터의 개수
- M(int): 원하는 합의 수
- data(int[]) : 입력 받은 데이터


### 핵심코드
```
int L = 0, R = 0, sum = 0;
	while(true) {
		if(sum < M) {
			if(R == N) return;		
			sum += data[R++];
		} else {
			sum -= data[L++];
		}
		if(sum == M) ans++;	
	}
```