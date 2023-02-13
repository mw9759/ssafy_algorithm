package algorithm.daily.ws0213;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1158_요세푸스문제_손민우 {
	
	static int n; // n정수 
	static int k; // k정수 
	static Queue<Integer> q = new LinkedList<Integer>(); // 1~n까지의 정수담을 큐
	static StringBuilder sb = new StringBuilder(); //출력문 담을 스트링빌더
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		n = sc.nextInt(); // 초기화
		k = sc.nextInt(); // 초기화
		
		sb.append("<"); // 출력 양식 입력 : 출력시 "<" 로 시작
		solution();  	// 메서드 호출
		System.out.println(sb);	 // 출력
	}
	private static void solution() {
		for(int i = 1; i<=n; i++) q.add(i); //먼저 1부터 n까지의 수를 모두 큐에 넣어준다
		for(int i = 0; i<n; i++) { // n번만큼 돌면서 => 결국엔 n개의 숫자가 제거되야 하기 때문
			for(int j =0; j<k-1; j++) q.add(q.poll()); // k번째 숫자가 제거되기에 k-1번만큼 돌면서 k-1까지의 수는 재등록
			if(q.size() == 1) sb.append(q.poll()).append(">"); // 만약 큐의 마지막 요소라면 출력양식 추가 : > -->출력시 마지막에 ">"요구.
			else sb.append(q.poll()).append(", "); // 마지막 요수가 아니라면 출력양식 추가: , -> 숫자와 숫자 사이에 , 요구.
		}
	}

}
