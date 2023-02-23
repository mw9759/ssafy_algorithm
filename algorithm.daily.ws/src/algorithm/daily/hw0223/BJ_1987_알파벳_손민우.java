package algorithm.daily.hw0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_알파벳_손민우 {
	
	static int r, c, maxMove = 0; //세로길이, 가로길이, 최대로 움직인 횟수
	static int arr[][], visited[]; // 보드판배열, 알파벳 방문여부 체크
	static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};// 우 하 좌 상 : 세로축/가로축 이동좌표
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); // 세로길이
		c = Integer.parseInt(st.nextToken()); // 가로길이
		arr = new int[r][c];					// 보드판 초기화
		visited = new int[27];					// 26개의 알파벳의 방문여부를 담을 배열
		
		//데이터 입력.
		for(int i = 0; i<r; i++) { 
			String str = br.readLine();
			for(int j = 0; j<c; j++) {
				arr[i][j] = str.charAt(j)-64; // 숫자로 변환 : 인덱스로 편하게 핸들링하기 위해 : 출력이 알파벳이 아니여서 괜찮다.
			}
		}
		visited[arr[0][0]] = 1;// 시작점 알파벳 사용 체크.
		dfs(0,0,1);// 메서드 호출
		System.out.println(maxMove); //출력
	}
	
	private static void dfs(int x, int y, int moveCount) {
		maxMove = Math.max(maxMove, moveCount); //메서드가 재귀될 때마다 매개변수로 넘어온 그간 이동횟수와 최대 이동횟수 비교
		//4방 탐색.
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i]; // 4방중 한 방면의 좌표
			int ny = y + dy[i]; // 4방중 한 방면의 좌표
			
			// 인덱스 범위를 만족하며,이동하려는 곳의 방문기록이 없을때
			if(nx>=0 && ny>=0 && nx<r && ny<c && visited[arr[nx][ny]] == 0) { 
				visited[arr[nx][ny]] = 1; // 방문기록
				dfs(nx, ny, moveCount+1); // 해당 방문기록을 유지한채 재귀.
				visited[arr[nx][ny]] = 0; // 재귀가 끝나면 다시 방문을 해제 : 다음 방면으로 새롭게 알아보기 위해 방문기록 해제.
			}
		}
	}

}
