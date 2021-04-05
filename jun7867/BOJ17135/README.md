# BOJ 17135  캐슬 디펜스

## 🌈 풀이 후기

- 함수를 최대한 나누고 싶었는데 문제가 복잡해서 세분하게 나누지 못했습니다.. 다음에는 조금 더 잘 나눠서 하고 싶습니다.
- 처음에 적군을 한칸씩 내리는 방법을 사용했는데 궁수를 한칸씩 위로 올리는 방법이 더 괜찮을것 같아서 바꿨습니다.
- 아직 시물레이션 문제를 많이 안풀어봐서 더 연습해야 겠다고 느꼈습니다.

## 👩‍🏫 문제 풀이

**핵심 원리**

1. 조합을 이용해서 궁수의 위치를 구한다. (궁수 3명)
2. 시작하기 전에 map과 queue를 초기화 시켜준다. 
3. 궁수를 queue에 저장한다. (하나씩 뽑아서 처리하려고) 꼭 queue를 사용한 이유는 없음. (왼쪽부터 검사) 
4. 매 조합마다 solve method를 호출한다. 

**핵심 코드 - combination method**

```java
// 궁수의 위치 모든 조합.
	private static void combination(int idx, int start) {
		if (idx == 3) {
			// map, queue(궁수) 초기화.
			copy();
			queue.clear();
			// 궁수 위치 queue에 저장.
			for (int i = 0; i < 3; i++) {
				queue.add(new Node(N, numbers[i]));
			}
			kill = 0;
			// 적군을 한칸씩 내리는거보다 아처를 위로 올리는게 더 효율적이며 낭비를 줄일 수 있다.
			// N부터 시작해서 0까지 도달하면 종료하는걸로.
			posArcher = N;
			solve();
			return;
		}

		for (int i = start; i < M; i++) {
			numbers[idx] = i;
			combination(idx + 1, i + 1);
		}
	}
```

**핵심 원리 solve**

1. 궁수의 위치(posArcher가 0이 될때까지 반복한다) - 궁수의 위치가 끝까지 올라왔을때
2.  적군을 초기화 시켜주고 궁수 3명이 적군을 쏘는 것을 확인.

 3.   최소 사정 거리에 있는 적군을 찾아주고 만약에 최소 거리가 같은 경우 더 왼쪽에 있는 적군의 위치를 저장한다.

4.  궁수 3명이 같은 적을 중복해서 죽일 수 있기 때문에 죽인 적은 궁수 3명을 모두 확인하고 업데이트 한다.

5. 조합에 따른 가장 많이 죽인 적군의 수(kill) max를 찾는다. 

**핵심 코드 - combination method**

```java
private static void solve() {
		// 궁수들 위치가 한칸씩 위로 올라가서 맨 위까지 올라왔을까지.
		while (posArcher != 0) {
			enemy.clear(); // 적군 초기화.
			// 궁수 3명이 쏘기.
			for (int i = 0; i < 3; i++) {
				Node archer = queue.poll();
				int x = archer.x;
				int y = archer.y;
				int enemy_x=100;
				int enemy_y=100;
				int tmp_d;
				int min_d = D;

				// 궁수 위부터 탐색.
				for (int j = x - 1; j >= 0; j--) {
					for (int k = 0; k < M; k++) {
						// 궁수와 적군 사이의 거리.
						tmp_d = Math.abs(x - j) + Math.abs(y - k);
						// 적군이고 거리(최소) 안에 있을경우
						if (copy_map[j][k] == 1 && tmp_d <= min_d) {
							if(min_d == tmp_d) { // 최소거리가 같은 경우 k값이 더 작은걸로 선택.
								if(enemy_y > k) {
									enemy_x = j;
									enemy_y = k;
								}
							}
							// 최소거리가 있으면 
							else if(min_d > tmp_d) {
								min_d=tmp_d;
								enemy_x = j;
								enemy_y = k;
							}
						}
					}
				}
				// 최종 적군 
				queue.add(new Node(x-1,y));

				// 처음 설정한 크기와 같지 않다면 적군을 찾은것.
				if(enemy_x !=100 && enemy_y !=100) {
                    enemy.add(new Node(enemy_x,enemy_y));
                }
			}
			// enemy update , 죽인수 ++ 
			for(int i=0;i<enemy.size();i++) {
				if(copy_map[enemy.get(i).x][enemy.get(i).y]==1) {
					copy_map[enemy.get(i).x][enemy.get(i).y]=0;
					kill++;
				}
			}
			posArcher--;
		}
		max=Math.max(max, kill);
	}
```
