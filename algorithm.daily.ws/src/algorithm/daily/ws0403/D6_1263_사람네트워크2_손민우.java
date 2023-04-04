package algorithm.daily.ws0403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D6_1263_사람네트워크2_손민우 {
	
	static int arr[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 사람 수
			arr = new int[n][n]; // 사람 수만큼 인접행렬 생성
			// 입력값 넣기
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 0) arr[i][j] = 1000000; // 만약 0이라면 간선이 없음으로 큰 값 넣기.
				}
				arr[i][i] = 0; // 만약 0인 이유가 자기 자신이라면 다시 0
			}
			
			// 플로이드 워샬
			for(int k = 0; k<n; k++) {
				for(int i = 0; i<n; i++) {
					for(int j = 0; j<n; j++) {
						if(i==j) continue;
						arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
					}
				}
			}
			
			// 최소 cc 값 출력
			int minCC = Integer.MAX_VALUE;
			for(int i = 0; i<n; i++) {
				int sum = 0;
				for(int j = 0; j<n; j++) {
					sum += arr[i][j];
				}
				minCC = Math.min(minCC, sum);
			}
			
			System.out.println("#"+t+" "+minCC);
		}
	}

}
/**
1
5 0 1 1 0 0 1 0 1 1 1 1 1 0 0 0 0 1 0 0 0 0 1 0 0 0
 * */
