package algorithm.daily.hw0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1992_쿼드트리_손민우 {
	static StringBuilder sb = new StringBuilder();
	static int arr[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<n; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		solution(0,0,n);
		System.out.println(sb);
	}
	
	private static void solution(int x, int y, int n) {
		int sum = 0;
		for(int i = x; i<x+n; i++) {
			for(int j = y; j<y+n; j++) {
				sum+= arr[i][j];
			}
		}
		//전부 1이라면 1출력
		if(sum == n*n) sb.append(1);
		//전부 0이라면 0출력
		else if(sum == 0) sb.append(0);
		//0과 1이 섞여있다면
		else {
			// 다시 4등분해서 검증
			// 4등분을 해야하면 ( 추가
			sb.append('(');
			solution(x, y, n/2);//좌측상단
			solution(x, y+n/2, n/2); //우측상단
			solution(x+n/2, y, n/2); //좌측하단
			solution(x+n/2, y+n/2, n/2); //우측하단
			//4등분이 끝났다면 ) 추가
			sb.append(')');
		}
	}
}
