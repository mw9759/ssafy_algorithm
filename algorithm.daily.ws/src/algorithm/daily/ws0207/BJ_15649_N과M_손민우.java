package algorithm.daily.ws0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649_N과M_손민우 {
	
	private static int[] arr; //조합을 담을 1차원 배열 멤버변수 선언.
	private static boolean[] visit; //1_n까지의 숫자가 사용되었는지 확인하는 논리형 배열 선언
	private static StringBuilder sb = new StringBuilder(); //출력값 담을 빌더 생성.
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력값 받을 뤼더 생성.
		StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열 쪼갤 토크나이져 생성.
		int n = Integer.parseInt(st.nextToken()); // 1~n의 값.
		int m = Integer.parseInt(st.nextToken()); // n의값중 m개 조합.
		
		arr = new int[m]; //초기화
		visit = new boolean[n]; //초기화
		
		solution(n, m,0); //함수호출 1~n까지 중 m개의 조합.0은 m개가 담겼는지 확인하기 위함.
		System.out.println(sb); //담긴 출력값 출력.
	}
	private static void solution(int n, int m, int depth) {
		if(m==depth) { // m개 만큼 배열에 담겼다면
			for(int i : arr) { // 배열에 담긴 조합원 하나씩 추가.
				sb.append(i).append(" ");
			}
			sb.append("\n");//줄바꿈.
			return;//탈출
		}
		
		for(int i = 0; i<n; i++) { //1~n값을 돌며 조합원찾기.
			if(!visit[i]) { // 기본값은 false이기에 false라면 == 사용안댐.
				visit[i] = true; // true로 바꿔주고
				arr[depth]= i+1; // 조합원에 추가 . +1은 i값이 0부터 시작하기에 해줌
				solution(n,m,depth+1); // 재귀호출, 조합원이 증가하였으니 +1을 해서 재귀.
				visit[i] = false; // 다 돌고오면 i값 다시 false로.
			}
		}
		
	}

}
