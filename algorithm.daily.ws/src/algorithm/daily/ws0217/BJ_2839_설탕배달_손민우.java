package algorithm.daily.ws0217;

import java.util.Scanner;

public class BJ_2839_설탕배달_손민우 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 배달해야할 무게
		int arr[] = {0,3,5};  // 설탕봉지 종류 3키로, 5키로
		int dp[][]= new int[2+1][n+1]; // 쓰인 봉지 종류 i개, n키로일때 쓰인 최소 봉지
		
		// 3키로 한개 내에서 쓰였을때, 3,5키로 두개 내에서 쓰였을때
		for(int i = 1; i<=2; i++) { 
			// 1~n키로 일때 
			for(int j = 1; j<=n; j++) {
				
				if(j-arr[i] >=0) { //주어진 무게에 해당 설탕종류가 들어갈 수 있을 때.
					if(j%arr[i] ==0) { // 나우어 떨어진다면: 현재 사용할 설탕무게에 최적화된 개수.
						dp[i][j] = j/arr[i]; // 해당 자리에 저장 몫저장 : 쓰일 설탕봉지의 개수.
					}
					else {
						//만약 이전 설탕봉지로도 무게를 맞출수없고, 현재 설탕봉지무게를 뺀 이전 설탕봉지 무게일때도 0개이고, 
						//나우어 떨어지지도 않는다면 채울수 없음.: 0;
						if(dp[i-1][j-arr[i]] == 0 && dp[i-1][j] == 0 && dp[i][j]%arr[i] !=0) dp[i][j] = 0;
						else {
							 // 위의 경우가 아니라면 1개이상의 설탕봉지를 쓸 수 있다.
							int a = j/arr[i]; // 현재 주어진 무게/현재설탕봉지무게의 몫
							for(int k = a; k>=1; k--) { //몫이 클수록 현재 쓸수 있는 설탕봉지의 개수가 커짐: 총 쓰일 설탕봉지 개수는 작아짐.: 내림반복
								if(dp[i-1][j-arr[i]*k]>0) {// 만약 [이전설탕봉지까지만 쓰였을때][현재주어진무게-현재설탕봉지무게*몫]>0 
									//ㄴ>나머지가 다른 설탕봉지 무게로 커버될때
									dp[i][j] = dp[i-1][j-arr[i]*k]+k;//커버된 갯수+몫
									break;
								}
								else dp[i][j] = dp[i-1][j];//커버가 안되면 그냥 이전 설탕봉지까지의 갯수
							}
						}
					}
				}
				else dp[i][j] = dp[i-1][j];//주어진 무게에 해당 설탕종류가 들어갈 수 없을때 이전 설탕봉지까지의 갯수
			}
		}
		System.out.println(dp[2][n]==0 ? -1: dp[2][n]); //0이면 불가능하니 -1출력
		
	}

}
