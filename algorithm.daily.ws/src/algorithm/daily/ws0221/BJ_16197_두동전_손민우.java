package algorithm.daily.ws0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x1,y1,x2,y2,count;
	Point(int x1, int y1, int x2, int y2, int count){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.count = count;
	}
}
class Coin{
	int x, y;
	Coin(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BJ_16197_두동전_손민우 {
	
	static int n,m;
	static char arr[][];
	static Coin[] coin = new Coin[2];
	static int visited[][][][];
	static int dx[] = {0,1,0,-1}, dy[] = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		visited = new int[n][m][n][m];
		int c = 0;
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<m; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'o') {
					coin[c++] = new Coin(i,j);
				}
			}
		}
		
		
		System.out.println(dropCoin());
	}
	private static int dropCoin() {
		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(coin[0].x, coin[0].y, coin[1].x, coin[1].y, 0));
		visited[coin[0].x][coin[0].y][coin[1].x][coin[1].y] = 1;
		while(!que.isEmpty()) {
			Point temp = que.poll();
			int x1 = temp.x1;
			int y1 = temp.y1;
			int x2 = temp.x2;
			int y2 = temp.y2;
			int count = temp.count;
			if(count>=10) break;
			
			for(int i = 0; i<4; i++) {
				int nx1 = x1+dx[i];
				int ny1 = y1+dy[i];
				int nx2 = x2+dx[i];
				int ny2 = y2+dy[i];
				
				// 다음 이동지가 벽인지 확인.
				//1번코인
				if(nx1>=0 && nx1<n && ny1>=0 && ny1<m && arr[nx1][ny1] == '#') {
					nx1 = x1;
					ny1 = y1;
				}
				//2번코인
				if(nx2>=0 && nx2<n && ny2>=0 && ny2<m && arr[nx2][ny2] == '#') {
					nx2 = x2;
					ny2 = y2;
				}
				// 떨어지는 동전 확인
				int drop = 0;
				if(nx1>=0 && nx1<n && ny1>=0 && ny1<m) drop++;
				if(nx2>=0 && nx2<n && ny2>=0 && ny2<m) drop++;
				// 하나만 떨어진다면 카운트+1해서 리턴
				if(drop == 1) return temp.count+1;
				// 둘다 안떨어진다면 큐에 담고 다음 이동. 다음 이동지에 방문 기록도 없을때.
				else if(drop == 2 && visited[nx1][ny1][nx2][ny2] == 0) {
					visited[nx1][ny1][nx2][ny2] = 1; // 다음 이동지 방문표시.
					que.add(new Point(nx1, ny1, nx2, ny2, count+1));
				}
			}
		}
		return -1;
	}
}
/*
6 2
..
..
..
o#
o#
##
*/