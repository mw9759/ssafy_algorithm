package algorithm.daily.ws0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1210_SW문제해결기본2일차_Ladder1_손민우 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			int t = Integer.parseInt(br.readLine());
			int arr[][] = new int[102][102]; // 좌우 비교할때 인덱스 에러 방지 상하좌우 열 추가.
			
			for(int i = 1; i <= 100; i++) { // 상하좌우 1열씩 제외하고 중간에 삽입.
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= 100; j++) { // 상하좌우 1열씩 제외하고 중간에 삽입.
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+tc+" "+solution(arr));
			
		}
	}
	
	private static int solution(int arr[][]) {
		int answer = 0; //도착좌표
		int startIdx = 0; // 시작점i좌표 
		for(int i = 1; i<=100; i++) { //좌표찾기 
			if(arr[100][i] == 2) { 
				startIdx = i;
				break;
			}
		}
		int i = 100; // 출발점 i좌표
		int j = startIdx; // 출발점 j좌표
		while(i != 1) { //i가 1에 도착하면 탈출.->왜 1이냐면 102*102크기이다.
			if(arr[i][j-1]==1) { //왼쪽이 1이라면
				j--; //왼쪽으로 이동
				while(arr[i][j-1] ==1) { //만약 왼쪽이 계속 1이라면 계속이동 0일때까지
					j--;//왼쪽으로 이동
				}
				i--;//왼쪽으로 다 이동하고 탈출하면 위로 한칸이동.
			}
			else if(arr[i][j+1]==1) { //오른쪽이 1이라면
				j++; //오른쪽으로 이동
				while(arr[i][j+1] ==1) { //만약 오른쪽이 계속 1이라면 0일때까지 이동.
					j++; //오른쪽으로 이동
				}
				i--; //오른쪽으로 다 이동하고 탈출하면 위로 한칸이동.
			}
			else {
				i--; // 좌우 모두 0일때 그냥 위로이동.
			}
		}
		answer = j-1; //-1이유는 100*100 크기가 아닌 102*102크기로 선언해 맨 위 아래 오른쪽 왼쪽은 더미데이터 들이다.(index문제 때문에 102*102선언)
		return answer;
	}

}
