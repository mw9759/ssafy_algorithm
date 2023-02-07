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
		int x = 0;
		int answer = 0;
		for(int i =0; i<n; i++) { 
			if(i<n/2) {
				for(int j = n/2-x; j<=n/2+x;j++) {
					answer += arr[i][j];
				}
				x++;
			} else {
				for(int j = n/2-x; j<=n/2+x;j++) {
					answer+= arr[i][j];
				}
				x--;
			}
		}
		return answer;
	}

}
