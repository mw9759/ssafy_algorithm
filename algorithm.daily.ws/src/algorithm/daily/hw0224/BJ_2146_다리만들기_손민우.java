package algorithm.daily.hw0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2146_다리만들기_손민우 {
	static int n, answer = Integer.MAX_VALUE;
	static int arr[][], dx[] = {0,1,0,-1}, dy[] = {1,0,-1,0}; //4방이동 좌표.
	static int visited[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		// 배열 데이터 입력
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 구분. 2번섬부터 x번 섬까지
		int islandNum = 2;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j] == 1) {
					marking(i,j,islandNum++);
				}
			}
		}
		
		// 다리 만들기.
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j]>0) {
					answer = Math.min(answer, build(i,j,arr[i][j])); // 정답 초기화: 가장 적은 값으로.
				}
			}
		}
		// 출력
		System.out.println(answer);
	}
	// 섬 구문하기. 2~ 마킹.
	private static void marking(int i, int j, int islandNum) {
		Queue<int[]> que = new ArrayDeque<int[]>(); // 다음 지역의 좌표를 담을 큐.
		que.add(new int[] {i,j}); // 현재좌표 추가.
		arr[i][j] = islandNum;	// 현재 좌표의 섬 번호 초기화.
		
		while(!que.isEmpty()) {//더이상 마킹할 좌표가 없을때까지.
			int x = que.peek()[0]; // 큐의 세로축 좌표 추출
			int y = que.poll()[1]; // 큐의 가로축 좌표 뽑기 : 큐에서 영구적으로.
			
			for(int k = 0; k<4; k++) {//우->하->좌->상 순의 4방 좌표확인
				int nx = x + dx[k]; // 다음 세로축좌표
				int ny = y + dy[k]; // 다음 가로축좌표
				
				// 인덱스 조건과 다음 방문지가 마킹이 안된 인접 섬이면.
				if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] == 1) { 
					arr[nx][ny] = islandNum; // 다음 방문지에 섬 번호 마킹.
					que.add(new int[] {nx, ny}); // 다음 방문지 큐에 담기.
				}
			}
		}
	}
	// 다리 만들기
	private static int build(int i, int j, int islandNum) {
		// 새로운 시작지로 시작될 때마다 방문기록 배열 초기화.
		visited = new int[n][n]; // 좌표의 방문 여부를 담을 배열.: 0이면 방분x, 1이상이면 방문: 몇번째 이동해서 온건지 기록.
		Queue<int[]> que = new ArrayDeque<int[]>(); // 다음 방문 지역의 좌표 담을 큐.
		que.add(new int[] {i,j}); // 큐에 시작지 좌표 담기.
		visited[i][j] = 1; // 시작 좌표 방문표시.
		
		while(!que.isEmpty()) {
			int x = que.peek()[0]; //큐의 세로축 좌표 추출.
			int y = que.poll()[1]; // 큐의 가로축 좌표 뽑기.: 큐에서 영구적으로.
			
			for(int k = 0; k<4; k++) {//우->하->좌->상 순의 4방 좌표확인
				int nx = x + dx[k]; // 다음 세로축좌표
				int ny = y + dy[k]; // 다음 가로축좌표
				
				//탈출조건: 만약 다음 좌표가 현재 섬이 아닌 새로운 섬이라면.
				
				
				// 인덱스 조건과 다음 방문지가 동일 섬이 아니라면
				if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] != islandNum && visited[nx][ny] == 0) { 
					// 다음 방문지가 다른 섬이라면 : 탈출.
					if(arr[nx][ny] != 0) {
						return visited[x][y]-1; // 이전 방문지까지의 이동횟수 -1: 이동횟수를 구하는게 아니고
								// 놓을 수 있는 다리의 길이를 구하는 것이기에 출발지 카운팅을 빼주고, 이전 방문지 까지만.
					}
					visited[nx][ny] = visited[x][y]+1;//다음 방문지에 방문 표시: 이전 방문지까지의 총 이동횟수 +1.
					que.add(new int[] {nx,ny}); // 큐에 다음 방문지 넣기.
				}
			}
		}
		return Integer.MAX_VALUE; 
	}
	
}
