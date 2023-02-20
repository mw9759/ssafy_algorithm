package algorithm.daily.ws0220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_색종이만들기 {

	static int arr[][]; // 색종이 색 담을 배열
	static int countW = 0; // 흰색 색종이 카운트
	static int countB = 0; // 파란 색종이 카운트
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 배열의 크기
		arr = new int[n][n];  // 배열 초기화
		
		// 배열 데이터 입력.
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(0,0,n); // 처음 확인 좌표  0,0 배열의 크기 n 
		//출력
		System.out.println(countW);
		System.out.println(countB);
	}
	
	private static void solution(int x, int y, int size) {
		int sum = 0; // 파란색종이: 1 담을 변수
		// 파란 색종이 카운트
		for(int i = x; i < x+size; i++) {
			for(int j = y; j < y+size; j++) {
				sum += arr[i][j];
			}
		}
		
		if(sum == size*size) countB++; // 만약 배열의 크기만큼 카운팅 되면 전부 파란색.
		else if( sum == 0) countW++;	// 만약 카운팅이 0이면 전부 흰색
		// 흰색 파란색이 섞여있는 경우 : 추가적으로 분리해야함. 정사각형 4분할
		else {
			solution(x, y, size/2); // 좌측 상단
			solution(x, y+size/2, size/2); // 우측 상단. 
			solution(x+size/2, y, size/2); // 좌측 하단
			solution(x+size/2, y+size/2, size/2); // 우측 하단.
		}
		
	}

}