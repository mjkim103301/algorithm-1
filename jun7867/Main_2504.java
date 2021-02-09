import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stackS=new Stack<Character>();
		Stack<Character> stackB=new Stack<Character>();
		boolean isValid=true;
		int curValue=1;
		int answer=0;
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(c=='(' || c=='[') {
				if(c=='(') {
					stackS.push(c);
					curValue *=2;
				} else { // c=='[' 
					stackB.push(c);
					curValue *=3;
				}
			}else { // ch => ) || ]
				if(c==')') {
					if(stackS.isEmpty()) {
						isValid=false;
						break;
					}
					if(str.charAt(i-1) == '(')
						answer+=curValue;
					stackS.pop();
					curValue/=2;
				} else { // ]
					if(stackB.isEmpty()) {
						isValid=false;
						break;
					}
					if(str.charAt(i-1)=='[')
						answer+=curValue;
					stackB.pop();
					curValue/=3;
				}
			}
			
		}		
		if(stackS.isEmpty() && stackB.isEmpty() && isValid)
			System.out.println(answer);
		else
			System.out.println(0);
	}

}
