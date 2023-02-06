package algorithm.daily.hw0206;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11729_하노이탑이동순서_손민우 {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//이동횟수
		System.out.println((int)Math.pow(2, n)-1);
		solution(n, 1, 3, 2); //n개의 원판, 출발지, 최종 도착지, 경유지
		System.out.println(sb);
	}
 	
	//n = 원판개수 & 원반 번호 , startPoint = 출발지, endPoint = 최종도착지, otherPoint = 경유지.
	private static void solution(int n, int startPoint, int endPoint, int otherPoint) {
		if(n==1) {
			sb.append(startPoint+ " "+ endPoint+"\n");
		} else {
			solution(n-1, startPoint, otherPoint, endPoint);
			sb.append(startPoint+ " "+ endPoint+"\n");
			solution(n-1, otherPoint, endPoint, startPoint);
		}
	}
}
