package algorithm.daily.ws0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11659_구간합구하기4_손민우 {
	private static int arr[];
	private static int n;//주어질 숫자의 개수
	private static int m; //합을 구해야하는 횟수
	private static int range[][]; // 합을 구해야하는 개수만큼 , 범위좌표
	private static StringBuilder sb = new StringBuilder();
	
	static int arr2[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // n값 초기화 
		m = Integer.parseInt(st.nextToken()); // m값 초기화
		
		arr = new int[n+1];//n+1의 길이로 초기화 => 0번인덱스 안씀.
		arr2 = new int[n+1]; // 누적합 저장할 배열 초기화=> 0번인덱스 안씀.
		range = new int[m+1][2];//m,2의 길이로 초기화 ->마지막 인덱스 안씀.
		
		
		st = new StringTokenizer(br.readLine(), " "); // n개의 숫자 슬라이싱.
		for(int i = 1; i<=n; i++) { // n번만큼 반복해서 arr에 슬라이싱된 숫자로 초기화.
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i< m; i++) {
			st = new StringTokenizer(br.readLine()); // m개의 줄의 합을 구할 구간 i j
			range[i][0] = Integer.parseInt(st.nextToken());
			range[i][1] = Integer.parseInt(st.nextToken());
		}
		
		solution();
		System.out.println(sb);
		
	}
	
	static int sum;
	private static void solution() {
		for(int i = 1; i <= n; i++) {
			sum+=arr[i];
			arr2[i] = sum;
		}
		
		for(int i = 0; i < m; i++) {
			int start = range[i][0];
			int end = range[i][1];
			
			System.out.println(arr2[end]-arr2[start-1]);
		}
		
	}

}
