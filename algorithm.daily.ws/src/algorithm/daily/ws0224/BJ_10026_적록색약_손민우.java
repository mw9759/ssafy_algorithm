package algorithm.daily.ws0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10026_적록색약_손민우 {
	
	static int[] dy = {-1, 1, 0, 0}; // 세로축 방향 이동
    static int[] dx = {0, 0, -1, 1}; // 가로축 방향 이동
    static int n, answer[] = new int[2];// 배열길이, 정상인&비정상인 정답 넣을 배열
    static char[][] arr; // 입력 배열
    static boolean visited[][][]; // 정상인&비정상인 별 방문여부를 담을 배열
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	//배열 길이 초기화
    	arr = new char[n][n];
    	visited = new boolean[2][n][n];
    	//배열 데이터 입력.
    	for(int i = 0; i<n; i++) {
    		arr[i] = br.readLine().toCharArray();
    	}
    	//구역의 수 구하기
    	for(int k = 0; k<2; k++) { // 정상인, 비 정상인
    		for(int i = 0; i<n; i++) { // 세로축 길이만큼
    			for(int j = 0; j<n; j++) { // 가로축 길이만큼
    				if(!visited[k][i][j]) { // 해당 지역에 방문 기록 확인 : 없다면-> 한번 재귀돌고오면 연결된 모든 지역은 true가 된다.
    					dfs(i, j, visited[k], arr[i][j]); // i: 세로축좌표, j: 가로축좌표, visited[k]: k가 0이면 정상인 1이면 비정상인의 방문여부,arr[i][j]: 현재값
    					answer[k]++; // 다 돌고 오면 칸수+1
    				}
    				if(arr[i][j] == 'G') arr[i][j] = 'R'; // 이미 재귀를 돌고 온 지역이기에 다음 비정상인 검정을 위해 G를 R로 바꿔준다.
    			}
    		}
    	}
    	//출력
    	System.out.println(answer[0]+ " "+ answer[1]);
    }

    static void dfs(int x, int y, boolean[][] visited, char ch) { // x: 세로좌표, y: 가로좌표, visited[][]: 방문여부, ch: 현재 내용물 
        visited[x][y] = true; // 현재 지역 방문 표시
    	
    	for(int i = 0; i<4; i++) { //4방 확인
    		// 이동했을때의 좌표
    		int nx = x+dx[i]; 
    		int ny = y+dy[i];
    		// 이동후의 좌표가 인덱스 조건 만족 && 방문기록x && 현재좌표와 같은 내용 소유
    		if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && arr[nx][ny] == ch) {
    			dfs(nx, ny, visited, ch); // 재귀: 이동된 지역에서의 4방을 또 확인.
    		}
    	}
    }

}
/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	45790	26282	20187	56.453%
문제
적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.

크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)

예를 들어, 그림이 아래와 같은 경우에

RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)

그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)

둘째 줄부터 N개 줄에는 그림이 주어진다.

출력
적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.

예제 입력 1 
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
예제 출력 1 
4 3

*/