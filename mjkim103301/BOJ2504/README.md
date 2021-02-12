# BOJ 0000번 [문제이름]()

## 🌈 풀이 후기
* stack에서 peek() 하거나 pop() 해야 할 때는 반드시 스택이 비어있는지 확인해야 합니다.  while문 위에서 1번만 확인했어서 런타임 오류가 발생했었습니다.


## 👩‍🏫 문제 풀이
    
* 스택을 1개만 활용하기위해 숫자도 문자열로 저장했습니다.
* 계산할때만 int로 바꾼후 스택에 넣을 때는 다시 문자열로 저장했습니다.

### 메서드

* input 문자열을 0번 index부터 순회하며 ch 변수에 저장합니다.
* ch 가 여는 활호면 무조건 스택에 넣습니다.
* ch가 닫는괄호면 괄호에 해당하는 값과 반드시 만나야 하는 여는 괄호를 calc() 메서드를 통해 보냅니다.
* isValid에는 괄호가 유효한지 boolean값으로 저장합니다.  만약 유효하지 않다면 바로 return 0을 해서 종료합니다.

* 문자열을 모두 순회 후 스택에 숫자가 있는지 검사합니다.  만약 괄호가 있다면 return 0을 하고 숫자라면 숫자를 반환합니다.
    * 숫자를 문자열로 저장했기 때문에 불필요한 or연산을 많이 한 것 같습니다.  pop 한 값의 charAt(0) 번지가 '0' 부터 '9' 사이값인지 확인하면 좋을 것 같습니다.
 ```java
 static int solution(String input){
        boolean isValid=true;
        stack=new Stack<>();
        int size=input.length();
        for(int i=0;i<size;i++){
            char ch=input.charAt(i);
            switch(ch){
                case')':
                    isValid=calc("2", "(");
                    break;
                case ']':
                    isValid=calc("3", "[");
                    break;
                default:
                    stack.push(ch+"");
                    break;
            }
            if(!isValid){
                return 0;
            }
        }
        int answer=0;
        while(!stack.isEmpty()){
            String peek=stack.peek();
            if(peek.equals("(")||peek.equals(")")||peek.equals("[")||peek.equals("]")){
                return 0;
            }else{
                answer+=Integer.parseInt(peek);
                stack.pop();
            }

        }
        return answer;
    }

```


* calc 메서드는 괄호값을 계산하는 메서드입니다.  num은 해당 괄호값을의미하고, target은 종료조건인 여는괄호를 의미합니다.
* 스택이 비어있지 않고, 스택의 맨 위가 종료조건이 아니면 num을 temp 변수에 더합니다.  이 때, 스택의 맨 위가 알맞지 않은 괄호이면 바로 return false 하면서 종료합니다.
* while문이 끝난 후, 스택이 비어있으면 알맞지 않은 괄호이므로 false를 리턴합니다.
* 정상적인 괄호문이라면 스택의 맨 위에는 여는 괄호가 있어야하므로 pop을 해서 제거합니다.
* temp가 0 이라면 괄호 사이에 아무 숫자도 없었다는 의미이므로 num값을 바로 넣어줍니다.
* temp가 0 이 아니라면 temp(괄호 사이에 있었던 값)* num(괄호값) 연산을 해줍니다.  그 후 스택에 넣어주고 true를 리턴합니다.


```java
 static boolean calc(String num, String target){
        int temp=0;
        while(!stack.isEmpty()&&!stack.peek().equals(target)){
            String peek=stack.peek();
            if(peek.equals("(")||peek.equals(")")||peek.equals("[")||peek.equals("]")){
                return false;

            }else{
                temp+=Integer.parseInt(peek);
                stack.pop();
            }
        }
        if(stack.isEmpty())return false;
        stack.pop();//여는 괄호 제거
        if(temp==0){
            stack.push(num);
        }else{
            temp=temp*Integer.parseInt(num);
            stack.push(temp+"");
        }
        return true;
    }

```