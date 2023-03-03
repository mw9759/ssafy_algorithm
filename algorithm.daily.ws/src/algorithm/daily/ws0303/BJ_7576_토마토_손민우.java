package algorithm.daily.ws0303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토_손민우 {
	
	static int n, m, ungrow = 0;
	static int[][] tomato;
	static Queue<Integer> que = new LinkedList<Integer>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 가로축 길이
		n = Integer.parseInt(st.nextToken()); // 세로축 길이
		tomato = new int[n+1][m+1]; // 토마토 들어있는 배열
		
		//입력값 저장.
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=m; j++) {
				int a = Integer.parseInt(st.nextToken());
				tomato[i][j] = a;
				if(a == 1) {// 익은 토마토 전부 큐에 넣기: 모든 익은 토마토가 동시에 옆에 토마토를 익게 한다.
					que.add(i); // 세로축 인덱스
					que.add(j);	// 가로축 인덱스
				}
				else if(a == 0) ungrow++; // 안익은 토마토 갯수
			}
		}
		solution(); // 메서드 호출
		if(ungrow != 0) day = -1; // 만약 안익은 토마토가 남아있다면 : -1출력
		System.out.println(day);// 출력
	}
	static int day = 0;// 익을수 있는 토마토가 모두 익는데 걸린 시간.
	private static void solution() {
		while(!que.isEmpty()) { //큐가 빌때까지: 익을수 있는 토마토가 없을 때까지.
			if(ungrow == 0) return; // 토마토 전부 익음.
			int cnt = que.size()/2;// 해당일에 1인 애들 모두 써야하기에 세로가로인덱스 뽑는 횟수
			for(int i = 0; i<cnt; i++) { // cnt만큼 돌면 하루 지남.
				int a = que.poll(); // 토마토의 세로좌표
				int b = que.poll(); // 토마토의 가로좌표
				if(tomato[a][b] == 1) {  // 만약 토마토가 익었다면
					//상부
					if(a>1 && tomato[a-1][b] == 0) { // 인덱스를 만족하며 안익었다면
						tomato[a-1][b] = 1; // 인접 안익은 토바토 익게 만듬
						ungrow--; // 안익은 토마토 개수 줄이기
						que.add(a-1); // 큐에 익은 토마토의 세로좌표 넣기
						que.add(b);   // 큐에 익은 토마토의 가로좌표 넣기
					}
					//하부
					if(a<n && tomato[a+1][b] == 0) {
						tomato[a+1][b] = 1;
						ungrow--;
						que.add(a+1);
						que.add(b);
					}
					//좌측
					if(b>1 && tomato[a][b-1] == 0) {
						tomato[a][b-1] =1;
						ungrow--;
						que.add(a);
						que.add(b-1);
					}
					//우측
					if(b<m && tomato[a][b+1] == 0) {
						tomato[a][b+1] =1;
						ungrow--;
						que.add(a);
						que.add(b+1);
					}
				}
			}
			day++; // 하루가 지났으므로 +1
		}
	}
	

}
