package algorithm.daily.ws0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15683_감시_손민우 {
	// cctv정보를 담을 객체
	static class Point{
		int x;
		int y;
		int type;
		Point(int x, int y, int type){
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	
	static int n,m;
	static int arr[][], direcs[];
	static ArrayList<Point> list = new ArrayList<Point>();
	static int min0 = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 가로열길이
		m = Integer.parseInt(st.nextToken()); // 세로열길이
		arr = new int[n][m]; // 사무실
		
		// 사무실 내의 cctv 배치 입력받기.
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				if(num>0 && num <5) { // 1번부터 4번의cctv만 담는다. : 5번은 회전의 의미가 없기에 미리 담아둔다.
					list.add(new Point(i,j,num));// cctv좌표 , cctv번호
				}
			}
		}
		// 방향 수열을 담을 배열 : cctv 개수만큼 방향이 1~4중에 담긴다. 중복 가능.순서도 의미있다.
		direcs = new int[list.size()];
		//5번 cc티비는 각도별 차이가 없기에 선작업 해준다.
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(arr[i][j] == 5) {
					//5번cctv 윗부분
					arr = cctvMove(1,arr,i,j);
					//5번cctv 아랫부분
					arr = cctvMove(3,arr,i,j);
					//5번 cctv 오른쪽부분
					arr = cctvMove(2,arr,i,j);
					//5번 cctv 왼쪽부분
					arr = cctvMove(4,arr,i,j);
					
				}
			}
		}
		//메서드 호출
		solution(0);
		//최소 사각지대 출력
		System.out.println(min0);
	}
	
	private static void solution(int cnt) { // 확인한 cctv개수
		// cctv방향 수열별 사각지대를 확인하기 위해 초기 5번cctv 감시구혁까지 담은 배열을 복사.
		int maps[][] = new int[n][];
		for(int i = 0; i<n; i++) {
			maps[i] = arr[i].clone();
		}
		// cctv 방향수열을 cctv 개수만큼 뽑았다면
		if(cnt == list.size()) {
			for(int i = 0; i<list.size(); i++) {
				int direc = direcs[i]; // cctv방향
				int x = list.get(i).x; // cctv세로좌표
				int y = list.get(i).y; // 가로좌표
				int type = list.get(i).type; // cctv 번호
				//2번의 경우: 양방향 13 or 24
				if(type == 2) {
					//상하
					if(direc ==1 || direc == 3) { //1또는 3일때 13 모두 확인
						maps = cctvMove(1,maps,x,y);
						maps = cctvMove(3,maps,x,y);
					}
					//좌우
					else { // 24확인
						maps = cctvMove(2,maps,x,y);
						maps = cctvMove(4,maps,x,y);
					}
					
				}
				// 1번 카메라의 경우
				else if(type == 1) {
					// 윗방향
					if(direc == 1)
						maps = cctvMove(1,maps,x,y);
					// 오른쪽
					else if(direc == 2)
						maps = cctvMove(2,maps,x,y);
					// 아래
					else if(direc == 3)
						maps = cctvMove(3,maps,x,y);
					// 왼쪽
					else if(direc == 4)
						maps = cctvMove(4,maps,x,y);
				}
				// 3번 cctv일 경우
				else if(type == 3) {
					// 상
					if(direc == 1) {
						maps = cctvMove(1,maps,x,y);
						maps = cctvMove(2,maps,x,y);
					}
					
					// 우
					else if(direc == 2) {
						maps = cctvMove(2,maps,x,y);
						maps = cctvMove(3,maps,x,y);	
					}
					
					// 하
					else if(direc == 3) {
						maps = cctvMove(3,maps,x,y);
						maps = cctvMove(4,maps,x,y);
					}
					// 좌
					else if(direc == 4) {
						maps = cctvMove(4,maps,x,y);
						maps = cctvMove(1,maps,x,y);
					}
				}
				//4번 cctv
				else if(type == 4) {
					// 상
					if(direc == 1) {
						maps = cctvMove(4,maps,x,y);
						maps = cctvMove(1,maps,x,y);
						maps = cctvMove(2,maps,x,y);
					}
					// 우
					else if(direc == 2) {
						maps = cctvMove(1,maps,x,y);
						maps = cctvMove(2,maps,x,y);
						maps = cctvMove(3,maps,x,y);
					}
					// 하
					else if(direc == 3) {
						maps = cctvMove(2,maps,x,y);
						maps = cctvMove(3,maps,x,y);
						maps = cctvMove(4,maps,x,y);
					}
					// 좌
					else if(direc == 4) {
						maps = cctvMove(3,maps,x,y);
						maps = cctvMove(4,maps,x,y);
						maps = cctvMove(1,maps,x,y);
					}
				}
			}
			// 사각지대 개수 확인
			int count = 0;
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(maps[i][j] == 0) {
						count++;
					}
				}
			}
			// 최솟값을 정답으로 초기화.
			min0 = Math.min(min0, count);
			return;
		}
		
		
		for(int i = 1; i<=4; i++) {
			//현재 cctv의 방향 담기
			direcs[cnt] = i;
			// 다음 cctv의 방향 뽑으러 가기
			solution(cnt+1);
		}
		
		
	}
	//현재 cctv의 감시구역을 체크할 메서드
	private static int[][] cctvMove(int direc, int[][] maps, int x, int y){
									// 방향(1,2,3,4), 감시구역을입력할배열, cctv의 x,y좌표
		int count = 0;
		//상
		if(direc == 1) { // 방향이 1이라면 : 윗쪽이라면
			for(int j = x-1; j>=0; j--) { // 해당 범위에
				if(maps[j][y] == 6) break;	// 6이라면 중단: 벽
				if(maps[j][y] == 0) maps[j][y] = 9; count++; // 감시가능 구역이면 9를 입력.
			}
		}
		//우
		else if(direc == 2) {
			for(int j = y+1; j<m; j++) {
				if(maps[x][j] == 6) break;
				if(maps[x][j] == 0) maps[x][j] = 9; count++;
			}
		}
		//하
		else if(direc == 3) {
			for(int j = x+1; j<n; j++) {
				if(maps[j][y] == 6) break;
				if(maps[j][y] == 0) maps[j][y] = 9; count++;
			}
		}
		//좌
		else if(direc == 4) {
			for(int j = y-1; j>=0; j--) {
				if(maps[x][j] == 6) break;
				if(maps[x][j] == 0) maps[x][j] = 9; count++;
			}
		}
		
		return maps;
	}

}