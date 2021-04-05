# BOJ 2504번 괄호의 값

## 🌈 풀이 후기
스택을 활용하면서 어떤 방식으로 곱하기와 더하기를 계산해야 될지 고민을 많이 했습니다.<br>
Stack에 어떤 데이터를 넣고 pop을 하면서 어떤 데이터를 넣어야 되는지 정하는데 시간을 많이 투자했습니다.<br>
문자열 stack과 계산하는 stack을 분리하는 것이 핵심인 것 같습니다.<br>
스택의 값의 레벨을 분리하고 레벨에 따라 더 해야하는지 곱해야 하는지 정하는 것이 핵심입니다.

## 👩‍🏫 문제 풀이
<br>

## 변수
- answer(int): 최종 점수 값
- scoreStack(stack \<Pair\>) 점수를 지속적으로 저장하는 스택
- checkStack(stack \<Character\>) 괄호를 저장하는 스택 

<br>

- Pair: 현재 자신의 점수(Score)와 스택의 레벨(Level)을 저장하는 클래스

<br>

```java
 public static void inputStack(int score, int level){
        while(!scoreStack.isEmpty()){
            if(scoreStack.peek().level < level) break;
            else if(scoreStack.peek().level == level){
                score += scoreStack.pop().score;
            } else{
                score *= scoreStack.pop().score;
            }
        }
        scoreStack.add(new Pair(score, level));
    }
```

## 원리
스택에서 ), ]값을 통해서 데이터를 나가는 순간 최 상단 stack의 level을 확인합니다. <br>
level이 같은 경우 - 동일 선상에 있으므로 데이터를 더하고 넣는다. 레벨은 유지<br>
level이 작 경우 - 더 초기에 있던 괄호이므로 데이터를 곱한 후 넣는다. 레벨은 작은 값으로 <br>

### 테스트 케이스
( ( ) [ ] )
```
1. ( 추가

level - 1
scoreStack - 
checkStack - ( 

2. ( 추가

level - 2
scoreStack - 
checkStack - ( (

3.  ) 삭제, (2, 1) 추가

level - 1
scoreStack - (2, 1)
checkStack - (

4.  [ 추가

level - 2
scoreStack - (2, 1)
checkStack - ( [

5.  ] 삭제, (3, 1) 추가

level - 1
scoreStack - (2, 1), (3, 1)
checkStack - (

-> 레벨이 같으므로 계산 시작
(2, 1) + (3, 1) 이므로 (5, 1)로 변경


6. ) 삭제, (2, 0) 추가 

level - 0
scoreStack - (5, 1), (2, 0)
checkStack - 

-> 레벨이 크므로 계산 시작
(5, 1) + (2, 0) -> (10, 0)로 변경

최종 값 10 출력
```