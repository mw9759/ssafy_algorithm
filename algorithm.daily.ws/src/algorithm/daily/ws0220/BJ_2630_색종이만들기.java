package algorithm.daily.ws0220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_색종이만들기 {

	static int arr[][];
	static int countW = 0;
	static int countB = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(0,0,n);
		System.out.println(countW);
		System.out.println(countB);
	}
	
	private static void solution(int x, int y, int size) {
		int sum = 0;
		for(int i = x; i < x+size; i++) {
			for(int j = y; j < y+size; j++) {
				sum += arr[i][j];
			}
		}
		
		if(sum == size*size) countB++;
		else if( sum == 0) countW++;
		else {
			solution(x, y, size/2);
			solution(x, y+size/2, size/2);
			solution(x+size/2, y, size/2);
			solution(x+size/2, y+size/2, size/2);
		}
		
	}

}