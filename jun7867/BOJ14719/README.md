# BOJ 14719 빗물

[https://www.acmicpc.net/problem/14719](https://www.acmicpc.net/problem/14719)

## 🌈 풀이 후기

- 이전에 수업때 풀었던 탑 문제를 생각했고 동일하지는 않지만 이전 높이보다 크면 높이를 업데이트 해주는 방식을 사용하였습니다.
- left와 right의 방식이 거의 유사하고 범위만 다른데 어떤식으로 함수를 나눠주는게 가독성이 좋을지 고민하였지만 잘 모르겠습니다. 이에 대해서 조언해주시면 감사하겠습니다!

## 👩‍🏫 문제 풀이

![image](https://user-images.githubusercontent.com/36908476/107851595-7edf4d00-6e4e-11eb-9c42-34ad7cf9fcf7.png)

가장 높은곳(max)을 찾아서 맨 왼쪽부터 높은곳까지, 오른쪽부터 높은곳까지 총 두번 검사한다.

빗물의 양은 결국 빗물이 들어가는 높이의 합에서 실제 블록 높이의 합을 빼면 된다. 

핵심은 검사하는 동안 가장 높은 블록의 높이를 더해주면서, 현재 지나온 블록의 최대 높이보다 높다면 업데이트해준다.

이 예시에서 블록의 높이가 2 4 3 4 1 1 5 1 1 3 4 이라고 했을때 

2+4(update)+4+4+4+4+5+4+4+4+4 에서 블록 높이의 합(29)을 빼주면 14가 빗물의 총 양이다.

<br>

## 핵심 코드 

```java
private static void leftCal() {
		int temp=0;
		for(int i=0;i<=maxIndex;i++) {
			// 현재 블록이 이전 가장 큰 블록보다 더크면 update해줌 
			if(block[i] > temp)
				temp=block[i];
			total+=temp;
		}
		
	}
	private static void rightCal() {
		int temp=0;
		for(int i=W-1;i>maxIndex;i--) {
			// 현재 블록이 이전 가장 큰 블록보다 더크면 update해줌 
			if(block[i] > temp)
				temp=block[i];
			total+=temp;
		}
		
	}
```

⇒ 문제를 풀고 Readme를 작성하면서 maxIndex만 구하면 되는데 굳이 Max를 구할 필요가 없다는걸 알았습니다. 

```tsx
if(max < height) {
				max=height; // 이건 필요없음.
				maxIndex=i;
}
```
