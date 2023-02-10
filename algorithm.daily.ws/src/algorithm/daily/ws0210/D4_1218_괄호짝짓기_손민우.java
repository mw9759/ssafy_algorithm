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
			
			
			System.out.println("#"+i+" "+solution(n, s));
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
			if(stack.isEmpty()) stack.push(s.charAt(0));
			if(stack.peek() == '(') {
				if(s.charAt(i) == ')') stack.pop(); //만약 열림괄호 짝인 닫힌괄호가 들어오면 stack 맨위 제거
				else if(open.contains(Character.toString(s.charAt(i)))) stack.push(s.charAt(i)); //만약 여는괄호면 stack에 새로 쌓기.
				else return 0;// 짝이아닌 닫는괄호면 0리턴.
			}
			else if(stack.peek() == '{') {
				if(s.charAt(i) == '}') stack.pop(); //만약 열림괄호 짝인 닫힌괄호가 들어오면 stack 맨위 제거
				else if(open.contains(Character.toString(s.charAt(i)))) stack.push(s.charAt(i)); //만약 여는괄호면 stack에 새로 쌓기.
				else return 0;// 짝이아닌 닫는괄호면 0리턴.
			}
			else if(stack.peek() == '[') {
				if(s.charAt(i) == ']') stack.pop(); //만약 열림괄호 짝인 닫힌괄호가 들어오면 stack 맨위 제거
				else if(open.contains(Character.toString(s.charAt(i)))) stack.push(s.charAt(i)); //만약 여는괄호면 stack에 새로 쌓기.
				else return 0;// 짝이아닌 닫는괄호면 0리턴.
			}
			else if(stack.peek() == '<') {
				if(s.charAt(i) == '>') stack.pop(); //만약 열림괄호 짝인 닫힌괄호가 들어오면 stack 맨위 제거
				else if(open.contains(Character.toString(s.charAt(i)))) stack.push(s.charAt(i)); //만약 여는괄호면 stack에 새로 쌓기.
				else return 0;// 짝이아닌 닫는괄호면 0리턴.
			}
		}
		System.out.println(stack);
		if(stack.isEmpty()) return 1;
		else return 0;
	}

}
/*
8
()()()()
*/
