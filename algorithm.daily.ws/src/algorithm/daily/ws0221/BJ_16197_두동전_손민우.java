package algorithm.daily.ws0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BJ_16197_두동전_손민우 {
	
	static int n,m;
	static char arr[][];
	static Queue<Point> que = new LinkedList<Point>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<m; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'o') {
					que.add(new Point(i,j));
				}
			}
		}
		
	}
	private static void dropCoin() {
		
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