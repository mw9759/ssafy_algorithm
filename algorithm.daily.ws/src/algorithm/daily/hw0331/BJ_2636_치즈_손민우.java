package algorithm.daily.hw0331;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2636_치즈_손민우 {
	static int n,m;
	static int map[][], dx[] = {-1,0,1,0}, dy[] = {0,1,0,-1};
	static int answer = 0, hour = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num == 1) answer++;
			}
		}
		
		//초기값 세팅
		//공기중: 2 || 치즈테두리: 3 || 치즈내의 구명 : 0 || 치즈 내부: 1
		map[0][0] = 2;
		while(answer > 0) {
			
			// 치즈 밖의 공기를 2로 바꾸기
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(map[i][j] == 2) spread(i,j);
				}
			}
			
			// 공기와 밀접한 부분 3으로 바꾸기
			int changeCnt = 0;
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(map[i][j] == 1 && vaporization(i, j)) {
						map[i][j] =3;
						changeCnt++;
					}
				}
			}
			
			// 증발한 치즈부분 다시 공기로 3->2
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(map[i][j]==3) map[i][j]=2;
				}
			}
			
			//시간 추가
			hour++;
			
			// 남은 치즈 부분 새기.
			answer -= changeCnt;
			if(answer == 0) {
				System.out.println(hour);
				System.out.println(changeCnt);
			}
			
		}
		
	}
	

	private static boolean vaporization(int x, int y) {
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
			if(map[nx][ny] == 2) {
				return true;
			}
		}
		return false;
	}

	private static void spread(int x, int y) {
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
			if(map[nx][ny] == 0) {
				map[nx][ny] = 2;
				spread(nx,ny);
			}
		}
	}

}
