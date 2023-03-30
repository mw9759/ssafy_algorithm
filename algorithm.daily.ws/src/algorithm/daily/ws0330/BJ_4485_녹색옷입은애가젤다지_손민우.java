package algorithm.daily.ws0330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// que에 담을 객체
class Point{
	int x; // 행값
	int y; // 열값
	int cost; // 여태까지 든 최소비용.
	
	Point(int x, int y, int cost){ // 생성자.
		this.x = x;
		this.y = y; 
		this.cost = cost;
	}
	
}

public class BJ_4485_녹색옷입은애가젤다지_손민우 {
	static int n;
	static int map[][], dp[][], dx[] = {-1,0,1,0}, dy[] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1; // 테스트케이스
		while(true) { 
			n = Integer.parseInt(br.readLine()); // 배열의 길이
			if(n==0) return; // 입력값 0이 들어오면 종료
			
			map = new int[n][n]; // 초기 입력값을 담아둘 2차원배열
			dp = new int[n][n]; // 해당 좌표까지 오는데 드는 최소 비용을 담을 2차원배열
			Queue<Point> que = new LinkedList<Point>(); // 4방탐색 후 이동 가능한 조건일때 검증할 다음 좌표와 들었던 비용을 담을 배열
			
			// 입력값 담기.
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// dp배열에 최댓값으로 초기화: 최솟값을 구해야 하는데 초기값들이 0이면 안된다.
			for(int i = 0; i<n; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			
			// 초기 값 셋
			que.add(new Point(0,0,map[0][0])); // 0,0 좌표에서 발생하는 비용을 함께 담아 큐에 넣는다.
			dp[0][0] = map[0][0]; 			// dp에도 시작좌표의 초기값 넣기.
			while(!que.isEmpty()) { 		
				Point po = que.poll();
				int x = po.x;	// 현재 행값
				int y = po.y;	// 현재 열값
				int cost = po.cost; // 현재 좌표까지 오는데 들었던 최소비용.
				
				if(cost>dp[x][y]) continue; // 만약 현재dp 좌표 안의 값보다 큰 비용이라면 다음 큐의 원소로 넘어간다.
				
				for(int i = 0; i<4; i++) { // 4방 탐색
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx<0 || ny<0 || nx>=n || ny>=n) continue; // 인덱스 범위 밖이면 넘기기
					if(cost+map[nx][ny]>=dp[nx][ny]) continue;	// 현재까지 든 비용+다음 좌표의 고유비용 >= 다음 좌표까지 들었던 최소비용 ==> 최소비용이기에 이경우엔 넘기기
					
					dp[nx][ny]= cost+map[nx][ny]; // 위에서 넘어가지 않았다면 dp 다음좌표 초기화.-> 더 작은 값.
					que.add(new Point(nx,ny,cost+map[nx][ny]));// 큐에 해당 값 넣어서 다음 이동좌표 검증.
				}
			}
			System.out.println("Problem "+ (tc++) + ": " +dp[n-1][n-1]); // 출력.
		}
	}
}
/**
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
*/
