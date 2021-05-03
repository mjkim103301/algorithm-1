# BOJ 12100번 [2048 Easy](https://www.acmicpc.net/problem/12100)

## 🌈 풀이 후기
* 중복순열 다 만든 후 돌려야하는데 시간아낀다고 만들면서 돌려서 실수했습니다.
* `copy()` 에서 Node를 `Arrays.copyOf()`로 복사하면 노드 주소가 복사돼서 오류가 났습니다.   
하나하나 복사해서 문제를 해결했습니다.
```java
    static void copy() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                copyMap[y][x] = new Node(map[y][x].num, map[y][x].level);
            }

        }
    }
```
## 👩‍🏫 문제 풀이
1. 중복순열로 4가지 방향 중 1가지 방향을 5번 뽑는다. -> arr배열에 저장
2. `moveBoard(d: 방향, level: 몇 번째 블록 이동인지)` 메서드에서 
    * 상, 하 방향은 각각 열마다 / 좌, 우 방향은 각각 행마다 `add(현재 원소, 몇 번째 블록 이동인지)`
        * copyMap[y][x] 값이 0보다 크면,
        * temp에 이미 넣어진 값이랑 같고, temp의 level이 현재 level과 다르면 -> temp값을 2배로 만들고, 현재 level로 변경한다.
        * temp에 이미 넣어진 값이랑 같고, temp의 level이 현재 level과 같으면 -> 이미 이번 방향에서 합쳐진 블럭이므로 `Node now` 값을 temp에 넣는다.
        * temp에 이미 넣어진 값이랑 다르면 바로 temp에 넣는다.
        * copyMap[y][x] 초기화

    * 각 방향대로 temp에 저장된 Node를 copyMap에 다시 배치한다.

3. 최대값을 구한다.
4. map배열을 copyMap배열에 복사한다.