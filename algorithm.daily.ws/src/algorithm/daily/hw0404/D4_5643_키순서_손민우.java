package algorithm.daily.hw0404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_5643_키순서_손민우 {
	static int n, m, map[][], tCnt, sCnt, visitedT[], visitedS[];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=tc; t++) {
			StringTokenizer st = null;
			n = Integer.parseInt(br.readLine()); // 사람 수
			m = Integer.parseInt(br.readLine()); // 관계 수
			map = new int[n+1][n+1];// 인접행렬: 사람번호가 1번부터이기에 +1
			answer = 0; // 내 키순서를 아는 사람의 수 : 출력할 정답
			
			// 입력값 넣기: 키 차이 관계
			for(int i = 1; i<=m; i++) {// 관계 수만큼 반복.
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()); // 더 작은사람
				int to = Integer.parseInt(st.nextToken()); // 더 큰사람
				map[from][to] = 1; // to가 from보다 키가 크다.
			}
			
			for(int i = 1; i<=n; i++) {
				tCnt = 0; // i번의 사람보다 큰 사람의 수 
				sCnt = 0; // i번의 사람보다 작은 사람의 수
				visitedT = new int[n+1]; // i번째 사람 검증시 사용할 방문체크 배열 taller
				visitedS = new int[n+1]; // i번째 사람 검증시 사용할 방문체크 배열 smaller
				taller(i); // 메서드 호출: 더 큰사람 명수 구하기
				shorter(i); // 메서드 호출: 더 작은사람 명수 구하기
				if(tCnt+sCnt == n-1) answer++; // 큰사람수+작은사람수 == 전체인원수-1(나) 일 경우 정답++
			}
			
			System.out.println("#"+t+" "+answer);
		}
	}
	// 더 작은사람 몇명인지 구하기.
	private static void shorter(int a) { // a번째 사람 기준으로 구하기
		visitedS[a] = 1; // 비교기록 체크
		
		for(int i = 1; i<=n; i++) { // 1부터 n번 사람까지 반복
			if(visitedS[i] == 0 && map[i][a] == 1) { // 비교기록이없고 i사람보다 a사람이 크다면
				sCnt++; // 더 작은사람 수 추가
				shorter(i); // i번 사람보다 작은사람이 있나 재귀호출.
			}
		}
	}
	// 더 큰사람 몇명인지 구하기
	private static void taller(int a) {// a번째 사람 기준으로 구하기
		visitedT[a] = 1; // 비교기록 체크
		
		for(int i = 1; i<=n; i++) { // 1부터 n번 사람까지 반복
			if(visitedT[i] == 0 && map[a][i] == 1) { // 비교기록이없고 a사람보다 i사람이 크다면
				tCnt++; // 더 큰사람 수 추가
				taller(i); // i번 사람보다 더 큰사람이 있나 재귀호출.
			}
		}
	}

}
