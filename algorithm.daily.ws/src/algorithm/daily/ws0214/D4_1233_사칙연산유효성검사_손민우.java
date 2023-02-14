package algorithm.daily.ws0214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1233_사칙연산유효성검사_손민우 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) { //테스트 케이스
			int n = Integer.parseInt(br.readLine()); //n값 초기화 총 노드 수
			String s = "-+*/"; // 사칙연산 조회용 문자열 
			int answer = 1; // 문제 없는 구조이면 1
			for(int i = 0; i<n; i++) { // n번만큼 돌면서
				StringTokenizer st = new StringTokenizer(br.readLine());
				int top = Integer.parseInt(st.nextToken()); // 노드 번호
				if(top*2<=n) { // 자식이 있는 경우이면
					if(!s.contains(st.nextToken())) { // 사칙연산이 없다면 => 문제
						answer = 0; // 0출력
					}
				}
				else {   		//자식이 없는 경우이면
					if(s.contains(st.nextToken())) { // 사칙연산이 있다면 => 문제 
						answer = 0;	// 0출력
					}
				}
			}
			// 출력.
			System.out.println("#"+tc+" "+answer);
		}
	}

}
