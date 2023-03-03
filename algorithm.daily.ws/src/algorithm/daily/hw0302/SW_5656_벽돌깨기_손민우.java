package algorithm.daily.hw0302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_5656_벽돌깨기_손민우 {
	static int n, w, h;
	static int map[][], turns[], visited[][], answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());// 부술수있는 횟수
			w = Integer.parseInt(st.nextToken()); // 맵의 가로 길이
			h = Integer.parseInt(st.nextToken()); // 맵의 세로 길이
			map = new int[h][w];// hw크기의 벽돌 필드
			turns = new int[n]; // 몇번째 열을 어떤순서로 부술지 담을 배열. 
//			turns = new int[] {2, 2, 6};
			answer = h*w; // 정답.
			
			for(int i = 0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			getTurn(0); // 부술 순서 정하기
			System.out.println("#"+tc+" "+answer); //출력
		}
	}
	// 부술 순서&라인 짜기.
	static void getTurn(int cnt) {
		if(answer == 0) return;
		if(cnt == n) {
			int count = check(); // 남은 벽돌의 갯수
			answer = Math.min(answer, count); // 갯수 최소값으로 초기화
			return;
		}
		// 중복 가능한 수열: 부술 라인 정하기
		for(int i = 0; i<w; i++) {
			turns[cnt] = i;
			getTurn(cnt+1);
		}
	}
	
	// 벽돌부시고 밀고 남은 벽돌 체킹
	static int check() {
		// 원본 배열 담을 복사본 
		int copyMap[][] = new int[h][w]; 
		//배열 복사.
		for(int i = 0; i<h; i++) {
			copyMap[i] = map[i].clone();
		}
		
		// 부시고 밀어주기
		for(int i = 0; i<n; i++) {
			int line = turns[i];
			//부셔버리기
			attack(line, copyMap,0); // 부술라인, 맵, 0번째 행부터 체크해서 0이아니면 부수기.
			// 아래로 밀어주기
			pushMap(copyMap);// 맵
			if(answer == 0) return 0;
		}
		
		// 남은 갯수 카운팅
		int count = 0;
		for(int i = 0; i<h; i++) {
			for(int j = 0; j<w; j++) {
				if(copyMap[i][j]>0) count++; // 0보다 크면 카운팅: 벽돌이다.
			}
		}
		
		return count; // 갯수 리턴.
	}
	
	// 벽돌 뿌수기ㅠㅠㅠ
	static void attack(int line, int[][] copyMap, int cnt) {// 부술라인, 맵, 0번째 행부터 체크해서 0이아니면 부수기.
		for(int i = cnt; i<h; i++) {
			if(copyMap[i][line] != 0) { // 벽돌을 만나면
				int range = copyMap[i][line]-1;// 4방으로 부셔지는 범위
				copyMap[i][line] = 0; // 본인은 우션 부셔짐
				
				//상부 부시기
				for(int j = i; j>=i-range; j--) {
					if(j<0) break; // 인덱스 벗어나면 탈출.
					if(copyMap[j][line] == 1) copyMap[j][line] = 0; // 1일땐 그냥 본인만 부시기.
					else if(copyMap[j][line] > 1) { // 1이상이면 대상 벽돌을 재귀로 넘겨준다.
						attack(line, copyMap, j);// 열번호, 맵, 행
					}
				}
				
				//하부 부시기
				for(int j = i; j<=i+range; j++) {
					if(j==h) break;
					if(copyMap[j][line] == 1) copyMap[j][line] = 0;
					else if(copyMap[j][line] > 1) {
						attack(line, copyMap, j);
					}
				}
				//좌측 부시기
				for(int j = line; j>=line-range; j--) {
					if(j<0) break;
					if(copyMap[i][j] == 1) copyMap[i][j] = 0;
					else if(copyMap[i][j] > 1) {
						attack(j, copyMap, i);
					}
				}
				//우측 부시기
				for(int j = line; j<=line+range; j++) {
					if(j==w) break;
					if(copyMap[i][j] == 1) copyMap[i][j] = 0;
					else if(copyMap[i][j] > 1) {
						attack(j, copyMap, i);
					}
				}
				break;// 벽돌을 하나 만나서 다 부셔줫으니 이제 그만 부신다.
			}
		}
	}
	// 아래로 밀어주기.
	static Stack<Integer> stack = new Stack<>();
	static void pushMap(int[][] copyMap) {
		// 열별로 조회
		int count = 0;
		for(int i = 0; i<w; i++) {
			
			for(int j = 0; j<h; j++) {
				if(copyMap[j][i]>0) { // 벽돌이면
					count++;
					stack.push(copyMap[j][i]); // 스택에 넣는다.
					copyMap[j][i] = 0; // 벽돌자리는 0으로 초기화
				}
			}
			
			for(int j = h-1; j>=0; j--) { // 마지막 행부터 스택에서 빼서 넣어준다.
				if(stack.isEmpty()) break; // 스택이 비면 탈출.
				copyMap[j][i] = stack.pop(); // 스택에서 꺼내서 마지막 행부터 넣어준다.
			}
		}
		if(count == 0) answer = 0;
	}
}
/*
1
3 10 10
0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 0 0 0 0
1 0 3 0 1 1 0 0 0 1
1 1 1 0 1 2 0 0 0 9
1 1 4 0 1 1 0 0 1 1
1 1 4 1 1 1 2 1 1 1
1 1 5 1 1 1 1 2 1 1
1 1 6 1 1 1 1 1 2 1
1 1 1 1 1 1 1 1 1 5
1 1 7 1 1 1 1 1 1 1
*/
