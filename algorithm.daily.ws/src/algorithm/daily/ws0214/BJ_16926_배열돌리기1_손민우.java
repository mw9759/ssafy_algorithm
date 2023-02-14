package algorithm.daily.ws0214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1_손민우 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 세로 길이
		int M = Integer.parseInt(st.nextToken()); // 가로 길이
		int R = Integer.parseInt(st.nextToken()); // 반복횟수
		int arr[][] = new int[N][M]; // nm크기의 배열 생성.
		//입력 저장.
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k<=Integer.min(N, M)/2 -1; k++) {
			for(int r = 1; r <= R % (2*(N+M-4*k-2)); r++) {
				
				int tmp = arr[k][k]; //옮기면서 덮이기에 미리 뺴준다.
				// 위: 해당위치 다음 인덱스 값-가로축: +1
				for(int i = k; i<M-k-1; i++) {
					arr[k][i] = arr[k][i+1];
				}
				// 오: 해당위치에 다음 인덱스 값- 세로축 : +1
				for(int i = k; i<N-k-1; i++) {
					arr[i][M-k-1] = arr[i+1][M-k-1];
				}
				// 하 : 해당위치에 이전 인덱스 값 - 가로축: -1
				for(int i = M-k-1; i>k; i--) {
					arr[N-k-1][i] = arr[N-k-1][i-1];
				}
				// 좌 : 해당위치에 이전 인덱스값 - 세로축:-1
				for(int i = N-k-1; i>k; i--) {
					arr[i][k] = arr[i-1][k];
				}
				arr[k+1][k] = tmp; // 미리 빼놨던 값 해당위치에 이전 인덱스값- 세로축: -1값
			
			}
		}
		//출력문
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}
}
