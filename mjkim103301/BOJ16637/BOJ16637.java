import java.io.*;

public class BOJ16637_괄호추가하기 {
    static int N; //수식의 길이
    static String equation; //수식
    static int max=Integer.MIN_VALUE; //int의 최솟값으로 초기화 
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        equation=br.readLine();
        solution();
        System.out.println(max);
    }

    static void solution(){
        int result=equation.charAt(0)-'0'; 
        recursion(0, result); //(재귀의 레벨, 수식의 첫번째 숫자)
    }

    static void recursion(int index, int result){
        if(index==N-1){ //현재 재귀의 level 이 수식의 끝이면 
            max=Math.max(max, result); //max값 계산
            return;
        }

        int tempResult;
        if(index+4<N){//괄호계산
            tempResult=calc(equation.charAt(index+2)-'0', equation.charAt(index+3), equation.charAt(index+4)-'0');
            tempResult=calc(result, equation.charAt(index+1), tempResult);
            recursion(index+4, tempResult);
        }
        if(index+2<N){// 괄호 없이 계산
            tempResult=calc(result, equation.charAt(index+1), equation.charAt(index+2)-'0');
            recursion(index+2, tempResult);
        }
    }

    static int calc(int num1, char operator, int num2){
        switch(operator){
            case '+':
                return num1+num2;

            case '-':
                return num1-num2;

            case '*':
                return num1*num2;

            case '/':
                return num1/num2;

        }
        return 0;
    }
}

