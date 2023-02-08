package algorithm.daily.ws0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650_N과M2_손민우 {
	private static int arr[]; //조합이 담길 배열
	private static int n;//1~n까지의 수
	private static int m;//조합개수
	private static StringBuilder sb = new StringBuilder(); //출력문 담기
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //n값 초기화
		m = Integer.parseInt(st.nextToken()); //m값 초기화
		
		arr = new int[m];
		solution(0,0);
		System.out.println(sb);
	}
	
	private static void solution(int cnt, int start) {
		if(cnt==m) {
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i<n; i++) {
			arr[cnt] = i+1;
			solution(cnt+1,i+1);
		}
		
	}

}
