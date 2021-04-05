# BOJ 1182 부분 수열의 합

## 🌈 풀이 후기

SSAFY 알고리즘 시간에 배웠던 subset을 활용해서 풀었습니다.

요즘 subset , 조합, 순열을 많이 사용하다보니 많이 익숙해져서 관련 문제를 푸는데 이전보다 훨씬 빠른속도로 풀고 있습니다.

## 👩‍🏫 문제 풀이

**핵심 원리**

1. isSelected를 한번은 true, 한번은 false로 하여 모든 부분 집합을 찾는다.
2. 찾은 부분 집합을 사용하여 더했을때 S와 같은지 비교한다.

*주의사항 : S가 0일때 공집합이 포함될 수도 있기 때문에 count를 따로 하던가 S가 0일때 -1을 해주면 된다.

**핵심 코드**

```java
private static void subset(int idx) {
		if(idx==N) {
			int sum=0;
			int selectedCnt=0;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					sum+=numbers[i];
					selectedCnt++;
				}
			}
			if(sum==S && selectedCnt >0)
				total++;
			return;
		}
		isSelected[idx]=true;
		subset(idx+1);
		isSelected[idx]=false;
		subset(idx+1);
	}
```
