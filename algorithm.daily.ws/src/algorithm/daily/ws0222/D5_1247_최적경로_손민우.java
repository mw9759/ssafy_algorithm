package algorithm.daily.ws0222;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D5_1247_최적경로_손민우 {
	
	static int n;
	static int com[] = new int[2],home[] = new int[2],cus[][];
	static boolean visited[]; // 방문여부 체크
	static int number[]; // 순서다음을 배열
	static int minDis;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			com[0] = Integer.parseInt(st.nextToken());
			com[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			minDis = Integer.MAX_VALUE;
			
			number = new int[n];
			visited = new boolean[n];
			cus = new int[n][2];
			for(int i = 0; i<n; i++) {
				cus[i][0] = Integer.parseInt(st.nextToken());
				cus[i][1] = Integer.parseInt(st.nextToken());
			}
			
			//System.out.println(Arrays.deepToString(cus));
			solution(0);
			System.out.println("#"+tc+" "+minDis);
		}
		
	}
	private static void solution(int cnt) {
		if(cnt == n) {
			int sum = Math.abs(com[0]-cus[number[0]][0]) + Math.abs(com[1]-cus[number[0]][1]);// 회사에서 첫번째 방문지까지의 거리
			for(int i = 0; i<n-1; i++) {
				sum += Math.abs(cus[number[i]][0]-cus[number[i+1]][0]) + Math.abs(cus[number[i]][1]-cus[number[i+1]][1]);
			}
			sum += Math.abs(home[0]-cus[number[n-1]][0]) + Math.abs(home[1]-cus[number[n-1]][1]);
			
			minDis = Math.min(minDis, sum);
		}
		
		for(int i = 0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				number[cnt] = i;
				solution(cnt+1);
				visited[i] = false;
			}
		}
	}

}
/*
1
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
*/