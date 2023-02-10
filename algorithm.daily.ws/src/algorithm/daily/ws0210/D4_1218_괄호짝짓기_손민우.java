package algorithm.daily.ws0210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1218_괄호짝짓기_손민우 {
	static Stack<Character> stack; //char형 스택 선언
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1; i<=10; i++) {
			int n = Integer.parseInt(br.readLine());
			
			String s = br.readLine();
			
			System.out.println("#"+i+" "+solution(n, s));//출력
		}
	
		
	}

	private static int solution(int n, String s) {
		int answer = 0;
		stack = new Stack<>();//스택 초기화
		String open = "({[<"; //여는 괄호
		String close = ")}}>"; //닫는 괄호
		if(open.contains(Character.toString(s.charAt(n-1)))) return 0; // 맨앞이 닫는 괄호면 바로 0리턴
		if(close.contains(Character.toString(s.charAt(0)))) return 0;	// 맨뒤가 여는 괄호면 바로0리턴

		for(int i = 0; i<n; i++) {
			if(stack.isEmpty() && close.contains(Character.toString(s.charAt(i)))) return 0;// 스택이 비었지만 들어온게 닫는괄호면 0리턴.
			else if(stack.isEmpty() || open.contains(Character.toString(s.charAt(i)))) stack.push(s.charAt(i));// 만약 스택이 비어있으면 
			
			else if(s.charAt(i) == ')') { //닫는게 나오면
				if(stack.peek()=='(') stack.pop(); //자기 짝궁이 스택바로위에 있는게 아니면 다 0리턴.
				else return 0;
			}
			
			else if(s.charAt(i) == ']') {
				if(stack.peek()=='[') stack.pop();
				else return 0;
			}
			
			else if(s.charAt(i) == '}') {
				if(stack.peek()=='{') stack.pop();
				else return 0;
			}
			
			else if(s.charAt(i) == '>') {
				if(stack.peek()=='<') stack.pop();
				else return 0;
			}
		}
		if(stack.isEmpty()) return 1; //스택이 비었으면 짝을 다 찾았다.
		else return 0;				//남아있는게 있으면 0리턴.
	}

}
/*
8
()()()()
*/
