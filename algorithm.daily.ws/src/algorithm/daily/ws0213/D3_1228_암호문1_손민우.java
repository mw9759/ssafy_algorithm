package algorithm.daily.ws0213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D3_1228_암호문1_손민우 {

	static int n; // 원본 암호문의 길이
	static int c; // 명령어의 개수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// solution메서드에서도 사용하기 위해 멤버변수로 선언.
	static LinkedList<String> link;//암호문 담을 리스트
	
	public static void main(String[] args) throws Exception{
		for(int tc = 1; tc<=10; tc++) {
			n = Integer.parseInt(br.readLine());
			link = new LinkedList<>(); //링크드리스트 초기화
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 초기 암호들 넣어주기
			for(int i = 0; i< n; i++) {
				link.add(st.nextToken());
			}
			//명령어 개수 초기화
			c = Integer.parseInt(br.readLine());
			
			//메서드 호출
			solution();
			
			//출력
			System.out.print("#"+tc+" ");
			for(int i = 0; i< 10; i++) System.out.print(link.get(i)+" ");
			System.out.println();
		}
	}

	private static void solution() throws Exception{
		//수정할 암호문 불러오기
		StringTokenizer st = new StringTokenizer(br.readLine());
		//암호문의 개수만큼 돌리기
		for(int i = 0; i<c; i++) {
			st.nextToken(); //명령어 변수
			int index = Integer.parseInt(st.nextToken()); //시작 인데스 변수
			int cnt = Integer.parseInt(st.nextToken()); // 삽입할 암호 개수
			
			for(int j = index; j<index+cnt; j++) link.add(j, st.nextToken()); // 시작인덱스부터 삽입할 암호 개수만큼// 링크드리스트 해당 인덱스에 담기.
		}
	}

}
