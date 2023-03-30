package algorithm.daily.ws0330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865_평범한배낭_손민우 {

	static int n, limit; // 물건의 갯수와 가방의 무게제한.
	static int weight[],value[]; //물건의 무게와 가치를 담을 배열
	static int dp[][]; // n개의 물건을 담았을때 최대 가치를 저장할 배열. 정답은 dp[n][limit]에 있는 셈이다.
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());
		weight = new int[n+1];
		value = new int[n+1];
		dp = new int[n+1][limit+1];
		
		//물건의 무게와 가치 초기화.
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		//dp[][]구현: n개의 물건을 사용했을때 최대 가치 담기.
		for(int i = 1; i<=n; i++) { // I = 현재 물건 번호
			
			for(int j = 1; j<=limit; j++) { // J = 현재 가방의 제한무게
				
				if(j-weight[i] >=0) { // 만약 현재 가방의 제한 무게보다 가벼운 물건일때만 
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]); // 이전 물건일때의 최대 가치 OR 현재물건까지 넣었을 때의 최대 가치중 더 큰값.
				}
				else dp[i][j] = dp[i-1][j]; // 더 무거운 물건이라면 이전 물건일때의 최대가치로 삽입.
			}
		}
		System.out.println(dp[n][limit]); // 출력. n개의 물건 중에서 limit 만큼의 무게 이내의 물건을 담을 수 있을때의 최대 가치 출력 
	}

}
