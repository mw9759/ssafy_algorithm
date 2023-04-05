package algorithm.daily.ws0404;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3055_탈출_손민우 {
	
	static int r, c, visited[][];
	static char map[][];
	static int dx[] = {-1,0,1,0}, dy[] = {0,1,0,-1}; // 4방 탐색용 배열
	static Queue<Point> que;
	static Queue<Point> waterQue;
	static boolean answer = false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); // 행의길이
		c = Integer.parseInt(st.nextToken()); // 열의길이
		map = new char[r][c]; // 입력값을 받을 배열 초기화
		visited = new int[r][c]; // 방문여부를 체크할 배열 초기화
		int sx = 0, sy = 0; // 시작좌표 초기화 S
		waterQue = new ArrayDeque<Point>();// 물인 지역의 좌표를 담을 큐 초기화
		
		// 입력값 담기.
		for(int i = 0; i<r; i++) { // 행의 길이만큼
			String str = br.readLine(); // 입력값 한줄 받아서 string변수에 담기.
			for(int j = 0; j<c; j++) { // 열의 길이만큼
				char ch = str.charAt(j); // j인덱스에 해당하는 문자 뽑아서 char변수에 담기.
				map[i][j] = ch; // map의 해당인덱스에 char변수 담기.
				if(ch == 'S') { // 근데 만약 char문자가 S라면 
					sx = i; sy = j; // 시작좌표이기에 따로 담아두기.
				}
				// 만약 char문자가 *이라면 물이기에=> 물인 지역의 좌표를 담을 큐에도 추가.
				else if(ch == '*') waterQue.add(new Point(i,j)); 
			}
		}
		
		//초기값 세팅
		int count = 0; // 몇번 이동했는지 카운팅할 변수.
		visited[sx][sy] = 1; // 출발지 방문체크
		que = new ArrayDeque<Point>();// 두더지의 좌표를 담을 큐 초기화
		que.add(new Point(sx, sy)); // 큐에 출발지 좌표담기.
		outStation:// break 탈출 지점.
		while(!que.isEmpty()) {
			int size = que.size(); // n번째 턴에 검증해야할 지역의 개수
			//  n번째 턴에 이동가능한 모든 동선들 검증.
			for(int i = 0; i<size; i++) {
				Point p = que.poll();
				int x = p.x; // 현재 두더지의 x
				int y = p.y; // 현재 두더지의 y
				
				// 두더지가 이동할 동선 탐색
				for(int k = 0; k<4; k++) {
					int nx = x + dx[k]; // 다음 탐색지의 x
					int ny = y + dy[k]; // 다음 탐색지의 y
					if(nx<0 || ny<0 || nx>=r || ny >=c) continue; //인덱스 범위 벗어나면 패스
					
					// 만약 동굴에 도착했다면 도착신호 true하고, for문 탈출
					if(map[nx][ny] == 'D') {
						answer = true; 
						count++;// 카운트 증가
						break outStation; // 마크한 부분으로 탈출.=> 모든 반복문 탈출.
					}
					if(visited[nx][ny] == 1) continue; // 방문했던 공간이라면
					if(map[nx][ny] == 'X') continue; // 돌이면 패스
					if(map[nx][ny] == '*') continue; // 물이면 패스
					if(isWater(nx, ny)) continue; // 물이 찰 예정지면 패스
					
					
					// 옮겨갈 수 있는 공간이라면
					visited[nx][ny] = 1; // 방문체크
					que.add(new Point(nx, ny)); // 큐에 다음 이동지 담기.
				}
			}
			// 물 번짐 시키기.
			waterSpread();
			
			count++;// 이동횟수 증가.
		}
		// 출력
		System.out.println(answer ? count:"KAKTUS");
	}

	private static void waterSpread() {
		int size = waterQue.size(); // 물이 있는 좌표가 들어있는 큐의 사이즈
		for(int i = 0; i<size; i++) { // 초기 큐의 사이즈만큼 반복.
			int x = waterQue.peek().x; // 현재 x좌표
			int y = waterQue.poll().y; // 현재 y좌표
			
			// 현재 x,y 좌표의 4방에 물 번지기.
			for(int j = 0; j<4; j++) {
				int nx = x + dx[j]; // 4방좌표
				int ny = y + dy[j]; // 4방좌표
				if(nx<0 || ny<0 || nx>=r || ny >=c) continue; //인덱스 범위 벗어나면 패스
				if(map[nx][ny] == '*') continue; // 이미 물이면 패스
				if(map[nx][ny] == 'X') continue; // 돌이면 패스
				if(map[nx][ny] == 'D') continue; // 동굴은 물에 잠기지 않는다.
				map[nx][ny] = '*'; // 해당지역 물뿌리기
				waterQue.add(new Point(nx, ny)); // 물이 뿌려진 새로운 지역 큐에 담기.
			}
		}
	}

	private static boolean isWater(int x, int y) {
		boolean flag = false; // 초기값 설정
		
		// 근처 4방 좌표에 물이 있는지 없는지 확인하기
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i]; // 확인할지역의 x
			int ny = y+dy[i]; // 확인할 지역의 y
			
			if(nx<0 || ny<0 || nx>=r || ny >=c) continue; //인덱스 범위 벗어나면 패스
			if(map[nx][ny] == '*') return true; // 만약 x,y근처에 물이 있다면 true리턴
		}
		return flag; // for문에서 탈출 못하면 false리턴
	}

}
