import java.util.Scanner;
import java.util.Stack;

public class BJ_2800_괄호제거_손민우 {
	
	static String str;
	static Stack<Character> stack = new Stack<>();
	static Stack<Integer> openIndex = new Stack<>();
	static Stack<Integer> closeIndex = new Stack<>();
	static String str1 = "";
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		
		solution();
		System.out.println(sb);
	}
	
	private static void solution() {
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i)=='(') {
				stack.add(str.charAt(i));
				openIndex.add(i);
			}
			else if(str.charAt(i) == ')') {
				if(stack.peek() == '(') {
					stack.pop();
					closeIndex.add(i);
				}
			}
			else str1 += str.charAt(i);
		}
		
		for(int i = 0; i<openIndex.size(); i++) {
			
			for(int j = 0; j<str.length(); j++) {
				if(j==openIndex.peek() || j == closeIndex.peek()) {
					continue;
				}
				sb.append(str.charAt(j));
			}
			sb.append("\n");
			//openIndex.pop();
			//closeIndex.pop();
		}
		
		System.out.println(openIndex);
		System.out.println(closeIndex);
		System.out.println(str1);
	}
}
