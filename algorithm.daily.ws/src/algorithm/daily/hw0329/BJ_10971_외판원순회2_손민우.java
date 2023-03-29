package algorithm.daily.hw0329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10971_외판원순회2_손민우 {
	static int n;
	static int arr[][];
	static int visit[], course[];
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new int[n];
		course = new int[n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1);
	}
	
	public static void dfs(int cnt) {
		if(cnt == n) {
			for(int i = 0; i<n; i++) {
				
			}
			return;
		}
		
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
