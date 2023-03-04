package algorithm.daily.ws0303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_16236_아기상어_손민우 {
	// 상어 정보 담을 클래스
	static class Shark implements Comparable<Shark>{
		int x, y, time;
		Shark(int x, int y, int time){
			this.x = x; // 상어의 행 좌표
			this.y = y; // 상어의 열 좌표
			this.time = time; // 현재까지 움직인 시간.
		}
		// 재정의
		@Override
		public int compareTo(Shark o) {
			if(this.time == o.time) { // 움직인 시간이 같으면
				if(this.x == o.x) {  // 행 좌표가 같다면
					return Integer.compare(this.y, o.y); // 열 좌표 내림차순
				}
				return Integer.compare(this.x, o.x); // 행 좌표 오름차순
			}
			return Integer.compare(this.time, o.time); // 움직인 시간 오름차순
		}
	}
	
	static int n, map[][], answer;
	static int sharkX, sharkY, sharkSize = 2;
	static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
	static int time, eatCount;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n]; // 그래프 맵.
		answer = 0; // 정답
		
		for(int i = 0; i<n; i++) { // 맵의 길이만큼
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp; // 해당좌표에 입력값 넣기.
				if(temp == 9) { // 만약 입력값이 상어라면
					map[i][j] = 0; // 상어자리 0으로
					sharkX = i; // 상어의 행좌표
					sharkY = j; // 상어의 열좌표
				}
			}
		}
		// 먹을 수 있는 물고기가 있으면 계속 움직인다.
		while(move()) {
			answer += time; // 총 걸린시간 += 한마리 먹을때 걸린시간
		}
		
		System.out.println(answer);// 출력
	}
	
	// 상어이동
	static boolean move() {
		//먹은 물고기의 수가 몸의 크기와 같아지면 몸의 크기 증가
        if(eatCount == sharkSize){
            eatCount = 0; // 몸이 커졌으므로 카운팅 0으로 초기화
            sharkSize++;
        }
        int visited[][] = new int[n][n]; // 요번 1마리를 먹을때 쓸 방문기록을 담을 배열.
        
        // 상어의 이동정보 담을 큐 : 정렬을 재정의 하여 우선순위로 먹어야할 먹이를 오름차순으로 정렬
		PriorityQueue<Shark> que = new PriorityQueue<Shark>(); 
		que.add(new Shark(sharkX, sharkY, 0));// 현재 상어의 정보 큐에 삽입.
		time = 0; // 요번 1마리를 먹기위해 걸린 시간 담을 변수
		
		while(!que.isEmpty()) { // 큐가 빌때까지
			Shark sh = que.poll(); // 상어의 현재 정보 가져온다.
			int x = sh.x; // 상어의  행 좌표
			int y = sh.y; // 상어의 열 좌표
			
			// 만약 현재 상어가 위치한 곳에 상어볻 작은 물고기가 있다면 먹는다: 탈출.
			if(map[x][y] < sharkSize && map[x][y]>0) {
				time = sh.time; // 총 걸린시간을 time에 넘겨준다.
				eatCount++; // 먹은 갯수 추가
				map[x][y] = 0; // 물고기가 있던자리는 이제 0으로
				
				// 상어의 좌표 초기화
				sharkX = x; 
				sharkY = y;
				return true;
			}
			// 4방탐색
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i]; // 다음 행 위치
				int ny = y + dy[i]; // 다음 열 위치 
				
				if(nx<0 || nx>=n || ny<0 || ny>=n) continue; // 인덱스 범위 밖: 안간ㄷㅏ.
				if(visited[nx][ny] == 1) continue; // 왔었돈 곳이면 : 안간다
				if(map[nx][ny]>sharkSize) continue; // 상어보다 큰 물고기가 있으면 안간다.
				
				que.add(new Shark(nx, ny, sh.time+1)); // 상어의 다음 위치 큐에 담기
				visited[nx][ny] = 1; // 방문 체크
			}
		}
		return false; // while문에서 리턴하지 못하면 먹을 물고기가 없어용ㅎㅎㅎㅎ
	}
	
}
/*
3
0 0 1
0 0 0
0 9 0
*/