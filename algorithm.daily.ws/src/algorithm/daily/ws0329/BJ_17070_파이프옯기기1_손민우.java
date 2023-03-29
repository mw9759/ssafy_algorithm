package algorithm.daily.ws0329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_파이프옯기기1_손민우 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+1][n+1]; // 집의 구조 담을 배열 +1 을 해줘 인덱스 접근에 용이하게 함.
		int dp[][][] = new int[n+1][n+1][3]; // 경우의 수 누적해서 더해줄 dp , 3차원 배열로 0,1,2 가로세로대각선 3가지 경우의 수를 각각 구해 더해준다.
		for(int i = 1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][0] = 1;// 초기값.
		//0 = 가로 | 1 = 세로 | 2 = 대각선
		for(int i = 1; i<=n; i++) {
			for(int j = 3; j<=n; j++) {
				if(arr[i][j] == 0) {// 벽이 없을때 올 수 있다.
					// 가로로 누워있는 경우 = 대각선에서 받기 + 가로에서 받기
					dp[i][j][0] = dp[i][j-1][2] + dp[i][j-1][0];
					// 세로로 누워있는 경우 = 대각선에서 받기 + 세로에서 받기 
					dp[i][j][1] = dp[i-1][j][2] + dp[i-1][j][1];

					// 대각선으로 누워있는 경우 = 모든 방면에서 받기 가능 and 경로에 벽이 없을때만.
					if(arr[i][j-1] == 0 && arr[i-1][j] == 0 && arr[i-1][j-1] == 0) {
						dp[i][j][2] = dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
					}
				}
			}
		}
		
		System.out.println(dp[n][n][0]+dp[n][n][1]+dp[n][n][2]); // 가로 세로 대각선 3방면의 경우의 수를 모두 더해준다.
		
	}
}
