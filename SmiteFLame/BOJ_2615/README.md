# BOJ 2629번 양팔저울

## 🌈 풀이 후기
처음에는 부분집합 문제로 파악해서 3개의 부분집합을 만들어서 풀었습니다<br>
시간이 너무 오래걸려서 다른 방법을 생각하다가 주제가 DP인걸 보고 DP를 추가했습니다.<br>

전에 계산한 결과를 확인하는 subsetData[i]를 추가해서 바로 통과했습니다.

## 👩‍🏫 문제 풀이
<br>

## 변수
- N, T(int) - 데이터의 개수, 문제의 개수
- data(int[]) - 입력받은 데이터의 수
- subsetData(boolean[][]) - 각 단계에서 가능한 저울의 무게
- set(Set<Integer>) - 가능한 모든 저울


## 원리

1. 처음에 부분집합으로 풀었을 때 시간초과했던 풀이입니다.<br>
좌, 우, 포함X를 3가지로 나눠서 3가지의 부분집합을 만들고 문제를 풀었는데 시간초과나왔습니다.
```java
private static void subset(int idx) {
    if(idx == N) {
        int left = 0, right = 0;
        for(int i = 0; i < N; i++) {
            if(subsetData[i] == 1) left += data[i];
            else if(subsetData[i] == -1) right += data[i];
        }
        set.add(Math.abs(left - right));
        return;
    }
    subsetData[idx] = 1;
    subset(idx + 1);
    subsetData[idx] = 0;
    subset(idx + 1);
    subsetData[idx] = -1;
    subset(idx + 1);
}
```

2. subsetData를 boolean으로 바꿔서 각각의 단계를 저장했습니다<br>
그리고 sum값이 계속 필요해서 파라미터로 넘겨줘서 풀었습니다

``` java
private static void subset(int idx, int sum) {
	if (idx == N) {
		set.add(sum);
		return;
	}
	
	if (subsetData[idx][sum])
		return;
	
	subsetData[idx][sum] = true;
	subset(idx + 1, sum + data[idx]);
	subset(idx + 1, sum);
	subset(idx + 1, Math.abs(sum - data[idx]));
}

```