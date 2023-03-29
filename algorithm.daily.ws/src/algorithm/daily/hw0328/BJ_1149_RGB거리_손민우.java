package algorithm.daily.hw0328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리_손민우 {
	static int arr[][], dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1][3]; // 집별 rgb 컬러별 비용을 담을 배열
		dp = new int[n+1][3]; // n번째 집까지 각 색을 선택했을 때의 최솟값들을 담을 배열
		// 입력값 담기.
		for(int i = 1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i<=n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+arr[i][0]; //i번째 집이 0번컬러(R)을 선택했을 때의 최솟값 : 이전 집의 색이 R이 아닌것중에 최솟값
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+arr[i][1]; //i번째 집이 1번컬러(G)을 선택했을 때의 최솟값 : 이전 집의 색이 G가 아닌것중에 최솟값
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+arr[i][2]; //i번째 집이 1번컬러(B)을 선택했을 때의 최솟값 : 이전 집의 색이 B가 아닌것중에 최솟값
		}
		
		System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2])); // n번째 집까지 다 칠하고, n번째집이 r색g색b색 을 선택 했을 경우중에 최솟값 출력
		
	}

}
