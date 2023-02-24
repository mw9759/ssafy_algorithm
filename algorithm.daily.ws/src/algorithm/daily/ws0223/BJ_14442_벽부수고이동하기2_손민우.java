package algorithm.daily.ws0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14442_벽부수고이동하기2_손민우 {
	// 이동된 지점 좌표와 해당지점에 도달하며 부순 벽의 개수 담을 객체
	static class Point{
		int x;
		int y;
		int count;
		Point(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	static int n, m, k;
	static int arr[][];
	static int visited[][][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());// 세로 길이
		m = Integer.parseInt(st.nextToken());// 가로 길이
		k = Integer.parseInt(st.nextToken());// 벽을 부실수 있는 개수
		arr = new int[n+1][m+1]; // 전체 맵
		visited = new int[n+2][m+2][k+1]; // 벽을 몇개 부시고 해당지점에 도달했는지 여부 체크
		// 데이터 입력.
		for(int i = 1; i<=n; i++) {
			String str = br.readLine();
			for(int j = 1; j<=m; j++) {
				arr[i][j] = str.charAt(j-1)-'0';
			}
		}
		//메서드 호출
		bfs();
		
	}
	
	private static void bfs() {
		Queue<Point> que = new LinkedList<Point>(); // 다음 출발지점+부순 벽의 수 담을 큐
		que.add(new Point(1,1,0)); // 큐에 초기 지점+부순개수0개 담기.
		int answer = 1; //최소 이동칸
		while(!que.isEmpty()) {
			
			int size = que.size();
			for(int i = 0; i<size; i++) { // 한 턴에 일어날 모든 경우의 수만큼 반복.
				int pointX = que.peek().x; // 세로축 좌표
				int pointY = que.peek().y; // 가로축 좌표
				int count = que.poll().count; // 해당 지점에 오면서 부순 벽의 수
				
				if(pointX == n && pointY == m) { // 만약 도착지에 도착하면
					System.out.println(answer); // 이동칸 출력하고 리턴 -> 첫 리턴이 최소 이동.
					return;
				}
				
				//오른쪽 이동
				//벽 없을때
				if(pointY<m &&visited[pointX][pointY+1][count] == 0 &&  arr[pointX][pointY+1]==0) { 
					visited[pointX][pointY+1][count] = 1;
					que.add(new Point(pointX, pointY+1, count));
				}
				//벽이고 부술수 있으면 부수기
				else if(pointY<m &&count<k &&visited[pointX][pointY+1][count+1] == 0 && arr[pointX][pointY+1]==1) {
					visited[pointX][pointY+1][count+1] = 1;
					que.add(new Point(pointX, pointY+1, count+1));
				}
				
				//아래쪽 이동
				//벽 없을때
				if(pointX<n && visited[pointX+1][pointY][count] == 0 && arr[pointX+1][pointY]==0) {
					visited[pointX+1][pointY][count] = 1;
					que.add(new Point(pointX+1, pointY, count));
				}
				//벽이고 부술수 있으면 부수기
				else if(pointX<n &&count<k&& visited[pointX+1][pointY][count+1] == 0 &&arr[pointX+1][pointY]==1) {					
					visited[pointX+1][pointY][count+1] = 1;
					que.add(new Point(pointX+1, pointY, count+1));
				}
				
				//왼쪽 이동
				//벽 없을때
				if(pointY>1 && visited[pointX][pointY-1][count] == 0 && arr[pointX][pointY-1]==0) {
					visited[pointX][pointY-1][count] = 1;
					que.add(new Point(pointX, pointY-1, count));
				}
				//벽이고 부술수 있으면 부수기
				else if(pointY>1&&count<k &&visited[pointX][pointY-1][count+1] == 0 &&  arr[pointX][pointY-1]==1) {
					visited[pointX][pointY-1][count+1] = 1;
					que.add(new Point(pointX, pointY-1, count+1));
				}
				
				//윗쪽 이동
				//벽 없을때
				if(pointX>1 &&visited[pointX-1][pointY][count] == 0 &&  arr[pointX-1][pointY]==0) {
					visited[pointX-1][pointY][count] = 1;
					que.add(new Point(pointX-1, pointY, count));
				}
				//벽이고 부술수 있으면 부수기
				else if(pointX>1&&count<k &&visited[pointX-1][pointY][count+1] == 0 &&  arr[pointX-1][pointY]==1) {
					visited[pointX-1][pointY][count+1] = 1;
					que.add(new Point(pointX-1, pointY, count+1));
				}
				
			}
			answer++; // 턴 추가: 아직 도착 못함.
		}System.out.println(-1); // 위의 while문에서 리턴하지 못하면 도착 불가능한 상황: -1출력.
	}

}
/*
문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 
당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 
이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
만약에 이동하는 도중에 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 K개 까지 부수고 이동하여도 된다.
한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.
맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000), K(1 ≤ K ≤ 10)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.

출력
첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.

예제 입력 1 
6 4 1
0100
1110
1000
0000
0111
0000

예제 출력 1 
15
*/