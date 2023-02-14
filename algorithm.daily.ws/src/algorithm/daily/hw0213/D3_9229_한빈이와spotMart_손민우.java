package algorithm.daily.hw0213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_9229_한빈이와spotMart_손민우 {
	static int n;
	static int m;
	static int arr[];
	static int w[] = new int[2];
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t<=1; t++) {
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			solution(0,0);
			if(max == 0)  max = -1;
			System.out.println("#"+t+" " +max);
		}
	}
	private static void solution(int cnt, int start) {
		if(cnt == 2) {
			int sum = 0;
			for(int i = 0; i<2; i++) {
				sum+=w[i];
			}
			if(sum<m) max = Integer.max(max, sum);
			
			return;
		}
		
		for(int i = start; i<n; i++) {
			w[cnt] = arr[i];
			solution(cnt+1, start+1);
		}
	}
}
