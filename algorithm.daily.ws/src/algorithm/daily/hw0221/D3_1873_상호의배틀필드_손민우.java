package algorithm.daily.hw0221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1873_상호의배틀필드_손민우 {
	static char arr[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr = new char[h][w];
			int x = 0;
			int y = 0;
			
			for(int i = 0; i<h; i++) {
				String str = br.readLine();
				for(int j = 0; j<w; j++) {
					arr[i][j] = str.charAt(j);
					// 전차 초기 위치 받아오기!
					if(arr[i][j]=='^' || arr[i][j] =='<'||arr[i][j] =='v'||arr[i][j]=='>') {
						x = i; y = j;
					}
						
				}
			}
			int n = Integer.parseInt(br.readLine());
			String order = br.readLine();
			// n개의 명령 실행.
			for(int i = 0; i<n; i++) {
				// 위로이동명령
				if(order.charAt(i) == 'U') {
					if(x>0 && arr[x-1][y] == '.') { //이동가능하면 방향틀고 올라가기.
						arr[x][y] = '.'; //기존 위치 평치로 초기화
						arr[x-1][y] = '^'; // 도착지역 방향표시
						x--; //탱크 위치 조정
					}else { //방향만틀기
						arr[x][y] = '^';
					}
				}
				// 아래로이동명령
				else if(order.charAt(i) == 'D') {
					if(x<h-1 && arr[x+1][y] == '.') { //이동가능하면방향틀고 내려가기
						arr[x][y] = '.'; //기존 위치 초기화
						arr[x+1][y] = 'v'; //도착지역에 방향표시
						x++; //탱트위치 조정
					}else { //방향만 틀기
						arr[x][y] = 'v';
					}
				}
				// 오른쪽으로 이동명령
				else if(order.charAt(i) == 'R') {
					if(y<w-1 && arr[x][y+1] == '.') {//이동가능하면방향틀고 오른쪽가기.
						arr[x][y] = '.'; //기존 위치 초기화
						arr[x][y+1] = '>'; // 도착지형에 방향표시
						y++; // 탱크위치 조정
					}else { //방향만 틀기/
						arr[x][y] = '>';
					}
				}
				//왼쪽으로 이동명령
				else if(order.charAt(i) == 'L') {
					if(y>0 && arr[x][y-1] == '.') { //이동가능하면 방향틀고 왼쪽가기
						arr[x][y] = '.';	// 기존 위치 초기화
						arr[x][y-1] = '<'; // 도착지형에 방향표시
						y--; //탱크위치 조정
					}else { //방향만 틀기
						arr[x][y] = '<';
					}
				}
				// 대포발사 명령수행
				else if(order.charAt(i) == 'S') {
					if(arr[x][y] == '^') { // 탱트방향이 윗방향일때
						int bomb = x-1; // 대포 초기 도착 지점.
						while(bomb>=0) { // 대포의 이동 범위
							if(arr[bomb][y] =='#') break; //강철벽이면 탈출
							if(arr[bomb][y] == '*') { // 벽돌벽이면 
								arr[bomb][y] = '.';   // 평지로 만든다.
								break;
							}
							bomb--; // 대포 위치 조정.
						}
					}
					if(arr[x][y] == '>') {
						int bomb = y+1;
						while(bomb<w) {
							if(arr[x][bomb] =='#') break;
							if(arr[x][bomb] == '*') {
								arr[x][bomb] = '.';
								break;
							}
							bomb++;
						}
					}
					if(arr[x][y] == 'v') {
						int bomb = x+1;
						while(bomb<h) {
							if(arr[bomb][y] =='#') break;
							if(arr[bomb][y] == '*') {
								arr[bomb][y] = '.';
								break;
							}
							bomb++;
						}
					}
					if(arr[x][y] == '<') {
						int bomb = y-1;
						while(bomb>=0) {
							if(arr[x][bomb] =='#') break;
							if(arr[x][bomb] == '*') {
								arr[x][bomb] = '.';
								break;
							}
							bomb--;
						}
					}
				}
			}
			//출력
			System.out.print("#"+tc+" ");
			for(char[] c: arr) {
				for(char ch: c) {
					System.out.print(ch);
				}System.out.println();
			}
		}
	}

}
