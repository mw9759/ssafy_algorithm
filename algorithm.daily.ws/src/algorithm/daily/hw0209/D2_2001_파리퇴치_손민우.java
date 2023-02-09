package algorithm.daily.hw0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_2001_파리퇴치_손민우 {

	static int n; //배열 크기
	static int m; //파리채크기
	static int arr[][]; //nn크기의 배열 파리수담음.
	static int count; // 잡은 파리수
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());//테스트 케이스 개수
		
		for(int t = 1; t<=tc; t++) {
			count = 0;// 파리수 테케마다 초기화.
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); //n값 = 배열 크기
			m = Integer.parseInt(st.nextToken()); //m값 = 파리채 크기
			
			//파리수 배열 n*n
			arr = new int[n][n]; //nn크기의 배열 초기화
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//[0][0] 시작점.
			solution(0,0);
			System.out.println(count);//최댓값 출력
		}
	}
	
	static void solution(int startX, int startY) { // startX: x좌표 시작점
		if(startY>n-m) {//y좌표가 배열 길이를 넘으면               // startY: y좌표 시작점.
			solution(startX+1,0);//y좌표 0으로 초기화하고 x좌표 더해줘서 한칸 내려간다.
			return;
		}
		if(startX>n-m) return; //만약 x좌표가 배열 길이를 넘으면 재귀탈출.
			
		
		int sum = 0; // 파리채 구간 총 잡은 파리수
		//파리채 구간 파리 수 
		for(int i = startX; i<startX+m; i++) {
			for(int j = startY; j<startY+m; j++) {
				sum+= arr[i][j];
			}
		}
		count = Math.max(count, sum); // 더 큰 값 저장.
		solution(startX, startY+1); // y축 시작점을 옆으로 한칸 이동.
	}
}
/*
1
5 2
1 3 3 6 7
8 13 9 12 8
4 16 11 12 6
2 4 1 23 2
9 13 4 7 3
*/