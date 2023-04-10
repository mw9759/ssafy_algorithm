package algorithm.daily.ws0410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17136_색종이붙이기_손민우 {
	static int map[][], cnt1 = 0, answer = Integer.MAX_VALUE;
	static int cntPapers[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10]; // 종이를 붙일 10*10크기의 맵
		cntPapers = new int[6]; // 종이별 남은 갯수를 담을 배열.
		Arrays.fill(cntPapers, 5); // 남은 갯수 5개로 초기화

		// 입력값 받기.
		for(int i = 0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<10; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
			}
		}
		// dfs호출 
		dfs(0,0,0); //시작좌표x, y, 사용한 종이 갯수
		
		// 출력 : answer값이 변경된 점이 없다면 -1 출력
		System.out.println(answer < 2147483647 ? answer:-1);
	}
	
	private static void dfs(int x, int y, int cnt) {
		// map의 마지막 부분까지 봤다면 최솟값 초기화 해주고 리턴.
		if(x >=9 && y>9) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		if(cnt>=answer) return; // 중간에 이미 사용한 종이의 갯수가 기존 최솟값을 뛰어 넘으면 바로 탈출.
		
		// y축이 인덱스 범위를 넘어가면 x축 증가.
		if(y>9) {
			dfs(x+1, 0, cnt);
			return;
		}
		
		// 종이가 사용되어야 하는 부분이면 어떤 종이가 쓰일지 검증
		if(map[x][y] == 1) {
			for(int i = 5; i>=1; i--) {
				// 남은 종이가 있고, 사이즈가 맞다면 실행.
				if(cntPapers[i]>0 && checkSize(i, x, y)) {
					check(i,x,y,0); // 종이가 담길 범위의 1값을 0으로 바꾸기
					cntPapers[i]--; // 종이 갯수 감소
					dfs(x, y+1, cnt+1); // 다음 dfs문 호출 y값+1, 사용한 종이 갯수+1
					check(i,x,y,1); // 종이가 담겼던 범위 다시 1로 바꾸기
					cntPapers[i]++; // 종이 갯수 복구
				}
			}
		}
		// 종이가 오면 않되는 부분이라면 다음 인덱스 검증
		else dfs(x, y+1, cnt);
		
	}
	
	// k크기의 종이가 사용될 수 있는지.
	private static boolean checkSize(int k, int x, int y) {
		boolean flag = true;
		
		for(int i = x; i<x+k; i++) {
			for(int j = y; j<y+k; j++) {
				// 종이가 삐져오거나 해당 범위에 종이가 들어올 수 없다면 false리턴
				if(i<0 || j<0 || i>=10 || j >= 10 || map[i][j] == 0)return false;
			}
		}
		return flag;
	}
	
	// 방문체크
	private static void check(int k, int x, int y, int n) {
		for(int i = x; i<x+k; i++) {
			for(int j = y; j<y+k; j++) {
				// 해당 지역 방문 표시
				map[i][j] = n;
			}
		}
	}
}
