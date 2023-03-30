package algorithm.daily.ws0330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14502_연구소_손민우 {
	static int map[][], copy_map[][];
	static int n,m, answer = 0;
	static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		copy_map = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//벽 세우기-> 첫번째 벽을 세우고 넘겨주는 느낌이다!
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 0) { // 0이면 빈칸이기에 빈칸일때 벽을 세운다.
					map[i][j] = 1;
					wall(1);
					map[i][j] = 0;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	
	private static void wall(int cnt) {
		if(cnt == 3) {
			// 배열 복사해서 사용하기=> 바이러스 핸들링을 위해. (깊은복사)
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					copy_map[i][j] = map[i][j];
				}
			}
			// 복사한 배열에서 바이러스 퍼트리기.
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					//바이러스일때 퍼트리기 시작.
					if(copy_map[i][j] == 2) {
						infection(i,j);
					}
				}
			}
			
			//바이러스가 전파되지 않은 공간 카운팅
			int count = 0;
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(copy_map[i][j] == 0) count++;
				}
			}
			answer = Math.max(answer, count);
			return;
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					wall(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}


	private static void infection(int x, int y) {
		for(int i = 0; i<4; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
			
			if(copy_map[nx][ny] == 0) {
				copy_map[nx][ny] = 2;
				infection(nx, ny);
			}
		}
	}

}
