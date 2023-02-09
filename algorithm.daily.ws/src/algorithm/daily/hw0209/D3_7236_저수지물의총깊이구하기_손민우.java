package algorithm.daily.hw0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_7236_저수지물의총깊이구하기_손민우 {
	
	static int n;
	static char arr[][];
	static int drc[][] = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
				// 방향 :     좌상 		상	  	우상	  우		우하	    하		좌하		좌	  
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());//테스트 케이스 개수
		
		for(int t = 1; t<=tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new char[n+2][n+2];// n+2 * n+2 크기 배열 초기화
			
			for(int i = 1; i <=n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=n; j++) {
					arr[i][j] = st.nextToken().charAt(0); //배열에 G W 담기.
				}
			}
			
			//출력
			System.out.println("#"+t+" "+solution());
		}
	}
	
	private static int solution() {
		int answer = 0;
		for(int i = 1; i<=n; i++) { 
			for(int j = 1; j<=n; j++) {
				if(arr[i][j] == 'W') { 
					int depth = 0; // w일때 깊이
					for(int k = 0; k<8; k++) { //8방면 만큼 반복
						depth += arr[i+drc[k][0]][j+drc[k][1]] == 'W' ? 1:0; //인근이w면 깊이+1
					}
					if(depth == 0) depth+=1;// 깊이가0이면 사방이 G이기에 깊이=1
					answer = Math.max(answer, depth); // 더 큰값 저장.
				}
			}
		}
		return answer;
	}
}
/*
1
3
G G W
G W W
W W W
*/