package algorithm.daily.hw0303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2115_벌꿀채취_손민우 {
	
	static int n, m, c;
	static int map[][];
	static int range[][];
	static int combination[][];
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new int[n][n]; // 전체 꿀통 현황 초기화
			range = new int[n*n][]; // 일꾼이 일할 시작 꿀통의 좌표 담을 배열
			combination = new int[2][2]; // 두 일꾼의 시작 꿀통 조합.
			answer = 0; // 전체 최대 가치.
			
			// 입력값 받기.
			int index = 0;
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // 전체 현황
					range[index++] = new int[] {i,j}; // 조합을 짜기 위한 조합원 담기  : 일꾼이 일할 시작 꿀통의 좌표.
				}
			}
			
			// 두 일꾼의 동선을 먼저 짠다. 메서드 호출
			range(0,0);
			System.out.println("#"+tc+" " + answer); // 정답 출력
		}
	}
	// 구해야 할것: 두 일꾼이 동선이 겹치지 않게 일할 구역을 구해야한다.=> [x,y]의 좌표를 담은 조합원들의 조합 사용.
	private static void range(int cnt, int start) {
		if(cnt == 2) {// 일꾼2명의 동선이 짜여진다면
			//인덱스 검증 : 선택할 벌통의 구간이 인덱스를 벗어나면 리턴.
			if(combination[0][1]+m-1>=n || combination[1][1]+m-1>=n) return;
			// 범위 검증: 두 일꾼이 작업할 공간이 겹쳐있으면 리턴.
			if(combination[0][0]==combination[1][0] &&
					combination[0][1]+m-1>=combination[1][1]) return;
			
			int max = findMax(); // 새로운 최대 가치 구해오기.
			answer = Math.max(answer, max); // 현재까지의 최대가치와 비교하여 더 큰것으로 최신화
			return;
		}
		// 조합 구하기.
		for(int i = start; i<range.length; i++) {
			combination[cnt] = range[i];
			range(cnt+1, i+1);
		}
	}
	
	//구해야 할것 : c만큼의 양 제한이 있을 때 얻어갈 수 있는 최대의 가치: 양은 더 적어도 상관없다. 꿀통 사용갯수도 상관없다. 무조건 꿀의 가치가 우선.=>dp사용.
	private static int findMax() {
        int[] honey1 = new int[m+1]; // 꿀의 양을 담을 배열: 1번 일꾼이 작업할 총 공간 +1
        int[] vlaue1 = new int[m+1]; // 꿀의 가치를 담을 배열 : 1번 일꾼이 작업할 총 공간 +1
        int[][] dp1 = new int[m+1][c+1]; // n개의 꿀통을 담았을때 얻을 수 있는 최대 가치
        
        int[] honey2 = new int[m+1]; // 꿀의 양을 담을 배열: 2번 일꾼이 작업할 총 공간 +1
        int[] vlaue2 = new int[m+1]; // 꿀의 가치를 담을 배열 : 2번 일꾼이 작업할 총 공간 +1
        int[][] dp2 = new int[m+1][c+1]; // n개의 꿀통을 담았을때 얻을 수 있는 최대 가치
        
        // 1번 일꾼이 작업할 꿀통별 무게와 각 꿀통별 가치를 각각 1차원 배열에 넣어준다.
        int index = 1;
        int x0 = combination[0][0];
        for(int j = combination[0][1]; j<combination[0][1]+m; j++) {
        	vlaue1[index] = map[x0][j]*map[x0][j];
        	honey1[index++] = map[x0][j];
        }
        // 2번 일꾼이 작업할 꿀통별 무게와 각 꿀통별 가치를 각각 1차원 배열에 넣어준다.
        index = 1;
        int x1 = combination[1][0];
        for(int j = combination[1][1]; j<combination[1][1]+m; j++) {
        	vlaue2[index] =  map[x1][j]*map[x1][j];
        	honey2[index++] = map[x1][j];
        }
        // 1번 일꾼이 얻을 수 있는 최대 가치 구하기 : dp알고리즘.
        for(int i = 1; i<=m; i++) { // 사용할 꿀통 개수
        	for(int j = 1; j<=c; j++) { // 꿀양 제한
        		if(j-honey1[i]>=0) { // 현재 꿀양을 통에 더 담을 수 있는 상황.
        			// i개의 꿀통을 j만큼의 제한이 걸렸을 때의 최대가치 = i-1개의 꿀통사용 최대가치 or 현재 꿀통무게를 빼줬을때[j-honey1[i]]의 가치+현재꿀통가치 중 더 큰것으로 담기.
        			dp1[i][j] = Math.max(dp1[i-1][j], dp1[i-1][j-honey1[i]]+vlaue1[i]);
        		}
        		else dp1[i][j] = dp1[i-1][j]; // 현재 꿀통이 들어갈 수 없는 상황일 때 i-1개의 꿀통사용 최대가치 넣기.
        	}
        }
        // 2번 일꾼이 얻을 수 있는 최대 가치 구하기 : dp알고리즘.
        for(int i = 1; i<=m; i++) { // 사용할 꿀통 개수
        	for(int j = 1; j<=c; j++) { // 꿀양 제한
        		if(j-honey2[i]>=0) { // 현재 꿀양을 통에 더 담을 수 있는 상황.
        			dp2[i][j] = Math.max(dp2[i-1][j], dp2[i-1][j-honey2[i]]+vlaue2[i]);
        		}
        		else dp2[i][j] = dp2[i-1][j];
        	}
        }
        
		return dp1[m][c]+dp2[m][c]; // 1번 일꾼의 최대 가치 + 2번 일꾼의 최대가치
	}

}
/*
1
4 2 13
6 1 9 7    
9 8 5 8
3 4 5 3
8 2 6 7
*/