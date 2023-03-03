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
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		Queue<Dust> que = new LinkedList<Dust>();
		
		for(int i = 0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<c; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x>0) {// 먼지 전부 큐에 담기.
					que.add(new Dust(i, j, x));
				}
				else if(x<0) map[i][j] = -1;
			}
		}
		
		for(int[] i: map) {
			System.out.println(Arrays.toString(i));
		}
		
		while(t>0) {
			 
			int size = que.size();
			
			for(int i = 0; i<size; i++) {
				Dust d = que.poll();
				int x = d.x;
				int y = d.y;
				int w = d.w;
				
				int amount = map[x][y]/5; //확산되는 양
				int count = 0;
				
				for(int j = 0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
					if(map[nx][ny] == -1) continue;
					
					count++;
					map[nx][ny] += amount;
					que.add(new Dust(nx, ny, amount));
				}
				
				map[x][y] = w - (count*amount);
			}
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