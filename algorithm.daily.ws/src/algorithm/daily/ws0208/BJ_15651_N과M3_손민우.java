package algorithm.daily.ws0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15651_N과M3_손민우 { //순서o 조합원중복o
	private static int arr[]; //조합이 담길 배열
	private static int n;//1~n까지의 수
	private static int m;//조합개수
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //n값 초기화
		m = Integer.parseInt(st.nextToken()); //m값 초기화
		
		arr = new int[m]; //m크기로 초기화
		
		solution(0); //arr 0번째 인덱스부터 담김.
		System.out.println(sb); //출력
	}
	
	private static void solution(int cnt) {
		if(cnt==m) { // arr에 m개의 조합원이 다 찼을때
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i<n; i++) {
			arr[cnt] = i+1;
			solution(cnt+1);
		}
	}

}
