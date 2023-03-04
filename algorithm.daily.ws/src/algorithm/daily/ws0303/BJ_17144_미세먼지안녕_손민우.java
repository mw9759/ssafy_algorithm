package algorithm.daily.ws0303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕_손민우 {
	
	static class Dust{
		int x, y, w;
		Dust(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	
	static int r,c,t;
	static int[][] map;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static int air;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		Queue<Dust> que = new LinkedList<Dust>();
		int index = 0;
		
		for(int i = 0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<c; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x>0) {// 먼지 전부 큐에 담기.
					que.add(new Dust(i, j, x));
				}
				else if(x<0) {
					map[i][j] = -1;
					air = i; // 공기 청정기의 아랫부분 세로좌표.
				}
			}
		}
//		for(int[] i: map) {
//			System.out.println(Arrays.toString(i));
//		}System.out.println();
		
		while(t>0) {
			while(!que.isEmpty()) {
				Dust d = que.poll();
				int x = d.x;
				int y = d.y;
				int w = d.w;
				
				int amount = w/5; //확산되는 양
				int count = 0;
				
				for(int j = 0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
					if(map[nx][ny] == -1) continue;
					
					count++;
					map[nx][ny] += amount;
				}
				map[x][y] += w - (count*amount);
			}
			
			공기청정기();
			
			for(int i = 0; i<r; i++) {
				for(int j = 0; j<c; j++) {
					if(map[i][j]>0) {
						que.add(new Dust(i, j, map[i][j]));// 먼지 전부 큐에 담기.
						if(t>1) {
							map[i][j] = 0; // 큐에 담은 칸은 다시 0으로.
						}
					}
				}
			}
			
			t--;
		}
		
		int answer = 0;
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) if(map[i][j]>0) answer+=map[i][j];// 먼지 전부 더해주기.
		}
		System.out.println(answer);
	}
	
	private static void 공기청정기() {
		//@@@@@ 공기청정기 윗부분
		//좌측
		for(int i = air-2; i>0; i--) {
			map[i][0] = map[i-1][0];
			map[i-1][0] = 0;
		}
		//상부
		for(int i = 0; i<c-1; i++) {
			map[0][i] = map[0][i+1];
			map[0][i+1] = 0;
		}
		//우측
		for(int i = 0; i<air-1; i++) {
			map[i][c-1] = map[i+1][c-1];
			map[i+1][c-1] = 0;
		}
		//하부
		for(int i = c-1; i>1; i--) {
			map[air-1][i] = map[air-1][i-1];
			map[air-1][i-1] = 0;
		}
		
		//@@@@@ 공기청정기 아렛부분
		//좌측
		for(int i = air+1; i<r-1; i++) {
			map[i][0] = map[i+1][0];
			map[i+1][0] = 0;
		}
		//하부
		for(int i = 0; i<c-1; i++) {
			map[r-1][i] = map[r-1][i+1];
			map[r-1][i+1] = 0;
		}
		//우측
		for(int i = r-1; i>air; i--) {
			map[i][c-1] = map[i-1][c-1];	
			map[i-1][c-1] = 0;
		}
		//상부
		for(int i = c-1; i>1; i--) {
			map[air][i] = map[air][i-1];
			map[air][i-1] = 0;
		}		
	}

}
/*
7 8 1
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
*/