package algorithm.daily.ws0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660_구간함구하기5_손민우 {
	private static int n;//주어질 숫자의 개수
	private static int m; //합을 구해야하는 횟수
	private static int[][] arr2; // m*4  배열 -> 시작좌표(x1,y1)+도착좌표(x2,y2)를 m개만큼 담을 배열.
	private static int[][] sum;//구간합 담을 배열 선언.
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // n값 초기화 
		m = Integer.parseInt(st.nextToken()); // m값 초기화
		arr2 = new int[m][4]; // 배열 초기화
		sum = new int[n][n+1]; //배열 초기화
		
		//슬라이싱 된 값을 누적하여 더한다. sum에 초기화
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int sum_ = 0;//데이터 받아오면서 같이 구간합 구해서 sum[][]에 바로 초기화
			for(int j = 1; j<=n; j++) {
				sum_ += Integer.parseInt(st.nextToken());
				sum[i][j] = sum_;
			}
		}
		//슬라이싱 된 값을 arr2에 초기화
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<4; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution();
		System.out.println(sb);
	}
	
	private static void solution() {
		
		for(int i = 0; i < m; i++) {// 2, 2 =>  3,  4
			int answer = 0;			//1 1    4 4
			int x1 = arr2[i][0];
			int y1 = arr2[i][1];
			int x2 = arr2[i][2];
			int y2 = arr2[i][3];
			for(int j = x1-1; j<x2; j++) {
//				if(minY-1-1<0)
//					answer += sum[j][maxY-1];
//				else
				answer += sum[j][y2]-sum[j][y1-1]; 
			}											   
			sb.append(answer).append("\n");
		}
	}

}
