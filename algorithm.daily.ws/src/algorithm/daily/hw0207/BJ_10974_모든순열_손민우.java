package algorithm.daily.hw0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10974_모든순열_손민우 {
	private static StringBuilder sb = new StringBuilder(); //출력값 담을 빌더 생성.
	private static int arr[]; //조합을 담을 배열 생성.
	private static boolean visit[]; //1_n까지의 숫자가 사용되었는지 확인하는 논리형 배열 선언
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력값 받을 뤼더 생성.
		int n = Integer.parseInt(br.readLine());
		arr = new int[n]; // n개의 조합이 담길 배열 초기화.
		visit = new boolean[n]; // n개의 참조기록이 담길 배열 초기화. 
		solution(n,0); // n값과 현재 조합원의 개수
		System.out.println(sb); //출력.
	}
	
	private static void solution(int n, int m) {//1~3까지의 숫자중 3개 조합. 중복o
		if(m == n) {// n개의 조합원이 필요하기에 m이 n만큼 채워졌다면 탈출.
			for(int i : arr) { // 배열에 담긴 조합원 하나씩 추가.
				sb.append(i).append(" "); //조합원과 공백 추가.
			}
			sb.append("\n");//줄바꿈 추가
			return;//탈출
		}
		
		for(int i = 0; i<n; i++) { //1~n값을 돌며 조합원찾기.
			if(!visit[i]) { //만약 방문기록이 없다면.
				visit[i] = true;  //방문기록
				arr[m]= i+1; // 조합원에 추가 . +1은 i값이 0부터 시작하기에 해줌
				solution(n,m+1); // 재귀호출, 조합원이 증가하였으니 +1을 해서 재귀.
				visit[i] = false; //방문기록 삭제.
			}
				
		}
	}
}
