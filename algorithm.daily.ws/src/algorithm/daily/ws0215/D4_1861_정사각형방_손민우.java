package algorithm.daily.ws0215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1861_정사각형방_손민우 {
	static int n; // 배열 길이           
	static int arr[][];	// nn 배열 
	static int max;	// 최대 이동방
	static int num; // 최대 이동방의 초기 값
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			//초기화
			max = 0; 
			num = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n+2][n+2];
			//arr 배열에 방번호 넣기
			for(int i = 1; i<=n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			//메서드 호출
			solution();
			//출력
			System.out.println("#"+tc+" "+num+" "+max);
		}
	}
	
	private static void solution() {
		//방 이동 가능한지 한방씩 확인
		for(int i = 1; i<=n; i++) { 
			for(int j = 1; j<=n; j++) {
				//해당방이 이동가능한지 재귀. 반환값: 방 이동횟수
				int sum = dfs(i,j);
				
				if(max<sum) { // 만약 이동횟수가 기존 횟수보다 크다면 횟수와 해당 방번호 저장.
					max = sum;
					num = arr[i][j];
				}
				else if(max == sum) { // 만약 이동 횟수가 같다면 방번호는 최저값을 구해야함
					num = num<arr[i][j] ? num:arr[i][j]; // 만약 기존 방번호가 더 작다면 기존 방번호.
				}
			}
		}
	}
	
	private static int dfs(int x, int y) {
		if(arr[x][y] == arr[x-1][y]-1) { // 윗방향 이동 가능하다면
			return 1+dfs(x-1,y);		// 윗방 기준으로 이동 가능성 확인. // 1은 현재방이 가능하니 카운팅.
		}
		else if(arr[x][y] == arr[x][y+1]-1) { //오른쪽 이동가능하다면
			return 1+dfs(x,y+1);			// 오른쪽방 기준으로 이동 가능성 확인.
		}
		else if(arr[x][y] == arr[x+1][y]-1) { // 아랫방향 이동 가능하다면
			return 1+dfs(x+1,y);			// 아랫방 기준으로 이동 가능성 확인
		}
		else if(arr[x][y] == arr[x][y-1]-1) { // 왼쪽으로 이동 가능하다면
			return 1+dfs(x,y-1);				//왼쪽방 기준으로 이동 가능성 확인
		}
		else return 1;	//이동불가하면 본인방 한개 리턴.
	}

}
