package algorithm.daily.hw0329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10971_외판원순회2_손민우 {
	static int n;
	static int arr[][];
	static int visit[], course[];
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n]; // 도시별 이동비용.
		visit = new int[n]; // 방문여부 체크
		course = new int[n]; // 순열 담기.
		// 입력값 담기.
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1); // 호출
		System.out.println(answer); // 출력
	}
	
	public static void dfs(int cnt) {
		if(cnt == n) {
			int start = 0; // 출발지
			int sum = 0;	// 현재 순열로 돌았을떄의 비용 합.
			for(int i = 1; i<n; i++) {
				if(arr[start][course[i]]==0) {// 만약 출발지와 도착지의 값이 0이라면 길이 없는 것이기에 리턴.
					return;
				}
				sum+= arr[start][course[i]];
				start = course[i];
			}
			// 구한 순열을 순서로 다 돌고 나면 마지막 원소를 출발지로 두고 0번(처음 출발지)까지의 비용을 더해준다.
			if(arr[course[n-1]][0] == 0) { // 하지만 이 또한 비용이 0이라면 리턴. => 길이 없다.
				return;
			}
			sum+=arr[course[n-1]][0];// 마지막으로 첫 출발지로 돌아오는 값을 더한다.
			answer = Math.min(answer, sum); // 기존 값과 현재 순열대로 돌았을 떄의 값을 비교하여 더 바용이 적은 걸로 초기화!
			return;
		}
		
		// 순열 구하기!! 시작 점은 0이기에 1~n사이의 순열을 구한다.
		for(int i = 1; i<n; i++) {
			if(visit[i] == 0) {
				visit[i] = 1;
				course[cnt] = i;
				dfs(cnt+1);
				visit[i] = 0;
			}
		}
	}

}
