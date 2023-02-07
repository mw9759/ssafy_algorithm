package algorithm.daily.ws0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_2805_농작물수확하기_손민우 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력값 받을 뤼더 생성.
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for(int tc = 1; tc<=t; tc++) { //테케만큼 반복한다.
			int n = Integer.parseInt(br.readLine()); // n값 초기화.
			int arr[][] = new int[n][n]; // n*n크기의 배열 생성.
			
			for(int i = 0; i<n; i++) { //n번만큼 돌면서
				String s = br.readLine(); // 입력 한줄 받아오면.(5자리 정수형을 string으로 받아온다.->쪼개서 2차원배열에 넣어줘야함.)
				for(int j = 0; j<n; j++) { // 다시n번만큼 돌면서 스트링을 쪼개서 다시 정수형으로 형변환해 2차원 배열에 초기화.
					arr[i][j] = s.charAt(j)-'0'; //정수형 char - '0' => 정수형.
				}
			}
			System.out.println(solution(n, arr)); // 메서드 호출.
			
		}
	}
	
	private static int solution(int n, int[][] arr) {
		int x = 0; // 인덱스 슬라이싱 할 기준 변수.
		int answer = 0; // 정답 
		for(int i =0; i<n; i++) { // 농경지의 행별로 확인.
			if(i<n/2) { // 농경지의 상단부분일경우: 수확  농경지 점점 증가.
				for(int j = n/2-x; j<=n/2+x;j++) { // n/2-x: x초기값은 0이기에 정중앙이다. 
					answer += arr[i][j];		//그렇다면 n/2+x도 정중앙이기에 한곳에서만 수확을 가져올수있다.
				}
				x++;// 다음행으로 이동하기에 수확할 부분이 증가-> x를 1 증가시킴으로서 다음행에서 좌/우측 한곳씩 더 수확한다.
			} else { // 농경지의 중앙행+하단부분: 수확농경지 점점 감소.
				for(int j = n/2-x; j<=n/2+x;j++) { //x값에 따라서 수확칸이 달라진다.
					answer+= arr[i][j];
				}
				x--; //중간을지나면서 행이 증가함에 따라 x는 감소해야 좌/우측 한곳씩 덜 수확한다.
			}
		}
		return answer;
	}

}
