package algorithm.daily.ws0329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1010_다리놓기_손민우 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int dp[][] = new int[30][30]; // 최대로 주어지는 수가 29이기에 길이 30으로 선언
		for(int i = 1; i<30; i++) {
			dp[i][0] = 1;// i개 중에 0개를 뽑는 경우= 1
			dp[i][i] = 1;// i개 중에 i개를 뽀는 경우= 1
		}
		
		
		for (int i = 2; i < 30; i++) {
			for (int j = 1; j < 30; j++) {
				
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];// i개중에 j개를 뽑는 경우는 => i-1개중에 j-1개를 뽑는 경우와(i개를 뽑는 상황)
															//                      + i-1개중에 i개를 뽑는 경우(i개를 안뽑는 상황)와 같다.
			}
		}
		
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 오른쪽 다리 놓을 곳
			int m = Integer.parseInt(st.nextToken()); // 왼쪽 다리 놓을 곳
			
			System.out.println(dp[m][n]); // m개중에 n개를 선택할 경우의 수
		}
	}

}
