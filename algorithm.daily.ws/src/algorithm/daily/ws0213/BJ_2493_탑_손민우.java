package algorithm.daily.ws0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑_손민우 {

	static int n; //n값 입력
	static StringBuilder sb = new StringBuilder(); // 출력문 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
	static Stack<Integer> stack = new Stack<>(); // 탑의 길이를 담을 스택
	static Stack<Integer> index = new Stack<>(); // 동시에 해당 탑의 인덱스를 담을 스택
	
	public static void main(String[] args) throws Exception{
		n = Integer.parseInt(br.readLine()); //탑의 개수 초기화
		
		solution(); //메서드 호출
		System.out.println(sb); //출력
	}

	
	private static void solution() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()); //문자열 슬라이싱
		
		for(int i = 1; i<=n; i++) { // 탑의 개수만큼 반복: i=1 을 준 이유는 탑의 번호가 1번부터 시작.
			int len = Integer.parseInt(st.nextToken()); // 탑의 길이 입력받기.
			if(stack.isEmpty()) { // 스택이 만약 비어 있다면 
				sb.append(0).append(" ");	//0을출력 => 새로운 탑이 들어와도 앞에 비교할 탑이 없음.
				stack.add(len);		// stack에 탑의 길이를 넣어준다.
				index.add(i);		// stack에 탑의 번호(인덱스)를 넣어준다.
				continue;			// 바로 다음 반복문으로 아래실행할 필요 없음
			}
			if(len<stack.peek()) {					// 만약 스택의 맨위값이 현재탑의 길이보다 크다면 레이저가 닿는다.
				sb.append(index.peek()).append(" ");	// 탑의 번호를 출력해야 하기에 index스택의 맨 윗값을 출력문에 추가. 제거는 안된다. 뒤에 탑이 참고해야함.
				stack.add(len);							// 현재 탑의 길이를 stack에 더해준다.
				index.add(i);							// 현재 탑의 번호(인덱스)를 index에 더해준다.
			}
			else if(len >= stack.peek()) {			//만약 현재 탑의 길이가 stack의 맨윗값보다 크다면 ->레이저가 안닿는다.
				while(!stack.isEmpty()) {			//우선 탑의 길이를 담아둔 stack이 빌때까지 반복.
					if(len<stack.peek()) {			// 만약 stack의 맨 위가 현재 탑의 길이보다 크다면
						sb.append(index.peek()).append(" ");	// 출력문에 stack맨위 탑의 인덱스->index의 맨 윗값을 출력문에 더한다.
						stack.add(len);					//다음 뒤의 탑이 현재탑의 길이와 번호를 참고해야 하므로 stack과 index에 더해준다.
						index.add(i);
						break;							//만약 위의 과정을 거치면 반복문 탈출.
					}else {								// 만약 stack의 맨 위가 현재 탑의 길이보다 작다면
						stack.pop();					// stack과 index의 스택에서 하나씩 빼서 버려준다
						index.pop();						//  ㄴ>> 나 자신보다 작은 탑은 뒤에 탑들에겐 의미없는 탑이다. 또한 그 앞의 탑을 조회해야한다.
					}
				}
				if(stack.isEmpty()) {			//반복문 탈출 뒤에 만약에 stack이 비었다면 -> 납은 탑이 없다면
					sb.append(0).append(" ");	// 0을 출력문에 더한다.--> 현재 탑의 레이저가 닿을 탑이 앞에 없었다.
					stack.add(len);				// 현재탑의 길이 stack에 더한다.
					index.add(i);				// 현재탑의 번호를 index에 더한다.
				}
			}

		}
	}

}
