package algorithm.daily.ws0206;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문제3_하노이탑_손민우 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char startPoint = 'A';
		char otherPoint = 'B';
		char endPoint = 'C';
		solution(n,startPoint, endPoint, otherPoint);
	}
	
	private static void solution(int n, char startPoint, char endPoint, char otherPoint) {
		if(n==1) {
			System.out.println(n+"이" +startPoint +"에서 "+ endPoint+"로 이동하였다.");
			return;
		}
		else {
			solution(n-1, startPoint, otherPoint, endPoint);
			System.out.println(n+"이" +startPoint +"에서 "+ endPoint+"로 이동하였다.");
			solution(n-1, otherPoint, endPoint, startPoint);
		}
	}
}
